package com.company.jedi;

import com.company.planet.PlanetManager;
import com.company.planet.Planet;
import com.company.universe.Universe;

import java.util.*;
import java.util.stream.Collectors;

public class JediManager {

    public static void createJedi(String[] arr) {
        String givenPlanet = arr[0];
        String givenName = arr[1];
        String givenRank = arr[2];
        String givenSaberColor = arr[4];
        JediRank[] jediRanks = JediRank.values();
        JediLightSaberColor[] lightSaberColors = JediLightSaberColor.values();
        JediRank rank = JediRank.INITIATE;
        JediLightSaberColor color = JediLightSaberColor.Blue;

        for(JediRank jediRank: jediRanks){
            if(givenRank.equalsIgnoreCase(jediRank.getName())){
                rank = jediRank;
            }
        }

        for(JediLightSaberColor jediLightSaberColor: lightSaberColors){
            if(givenSaberColor.equalsIgnoreCase(jediLightSaberColor.name())){
                color = jediLightSaberColor;
            }
        }

        HashSet<Jedi> jedi = Universe.getInstance().getJedi_Poppulation();
        if (!PlanetManager.planetExist(givenPlanet)) {
            System.out.println("Such a planet does not Exist");

        }else {
            Optional<Jedi> foundJedi = jedi.stream()
                    .filter(existingJedi -> existingJedi.getPlanet().getPlanetName().equalsIgnoreCase(givenPlanet))
                    .filter(existingJedi -> existingJedi.getName().equalsIgnoreCase(givenName))
                    .findAny();
            if(foundJedi.isPresent()){
                System.out.println("There already exists such a jedi on this planet");
            }
            else {
                jedi.add(new Jedi(givenName, rank, Integer.parseInt(arr[3]), color, Double.parseDouble(arr[5]),
                        new Planet(givenPlanet)));
                Universe.getInstance().setJedi_Poppulation(jedi);
            }
        }
    }

    public static void removeJedi(String[] args) {
        HashSet<Jedi> jedi = Universe.getInstance().getJedi_Poppulation();
        String givenName = args[0];
        String givenPlanet = args[1];
        Optional<Jedi> foundJedi = jedi.stream()
                .filter(jediToRemove -> jediToRemove.getName().equalsIgnoreCase(givenName))
                .filter(jediToRemove -> jediToRemove.getPlanet().getPlanetName().equalsIgnoreCase(givenPlanet))
                .findAny();
        if(foundJedi.isPresent()){
            Universe.getInstance().getJedi_Poppulation().remove(foundJedi.get());
            System.out.println("The Jedi " + givenName + " has been removed.");
        }
        else{
            System.out.println("The jedi " + givenName + " has not been found");
        }
    }

    public static void demoteJedi(String[] args) throws Exception {
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        String name = args[0];
        Optional<Jedi> foundJedi = jedis.stream().filter(jedi -> jedi.getName().equalsIgnoreCase(name)).findAny();
        if(!foundJedi.isPresent()){
            System.out.println("No Jedi with the name " + name + " was found.");
        }
        else {
            if(foundJedi.get().getRank().equals(JediRank.YOUNG_LING)){
                System.out.println(name + " is already at the lowest rank");
            } else {
                Jedi jedi = foundJedi.get();
                Universe.getInstance().getJedi_Poppulation().remove(jedi);
                jedi.setRank(JediHelper.getPreviousRank(jedi));
                jedi.setStrength(JediHelper.multiplier(Double.parseDouble(args[1]), jedi.getStrength()));
                System.out.println(jedi.getName() + " has been demoted to " + jedi.getRank());
                Universe.getInstance().getJedi_Poppulation().add(jedi);
            }
        }
    }

    public static void promoteJedi(String[] args) throws Exception {
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        String name = args[0];
        Optional<Jedi> foundJedi = jedis.stream().filter(jedi -> jedi.getName().equalsIgnoreCase(name)).findAny();
        if(!foundJedi.isPresent()){
            System.out.println("No Jedi with the name " + name + " was found.");
        }
        else {
            if(foundJedi.get().getRank().equals(JediRank.GRAND_MASTER)){
                System.out.println(name + " is already at the highest rank");
            } else {
                Jedi jedi = foundJedi.get();
                Universe.getInstance().getJedi_Poppulation().remove(jedi);
                jedi.setRank(JediHelper.getNextRank(jedi));
                jedi.setStrength(JediHelper.multiplierPromote(Double.parseDouble(args[1]), jedi.getStrength()));
                System.out.println(jedi.getName() + " has been promoted to " + jedi.getRank());
                Universe.getInstance().getJedi_Poppulation().add(jedi);
            }
        }
    }

    public static void getStrongestJedi(String[] args) {
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        String planet = args[0];
        if(!PlanetManager.planetExist(planet)){
            System.out.println("No such planet");
        }else {
            Optional<Jedi> foundStrongestJedi = jedis.stream()
                    .filter(jedi -> jedi.getPlanet().getPlanetName().equalsIgnoreCase(planet))
                    .max(Comparator.comparing(Jedi::getStrength));
            if(foundStrongestJedi.isPresent()){
                Jedi strongestJedi = foundStrongestJedi.get();
                System.out.println("The strongest on this planet is : " + strongestJedi.getName()
                        + " with the strength of : " + strongestJedi.getStrength());
            }else {
                System.out.println("There are no Jedi on this planet");
            }
        }
    }

    public static void getYoungestJedi(String[] args) {
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        String planet = args[0];
        String rank = args[1];
        if(!PlanetManager.planetExist(planet)){
            System.out.println("No such planet");
        }else {
            List<Jedi> foundYoungestJedis = jedis.stream()
                    .filter(jedi -> jedi.getPlanet().getPlanetName().equalsIgnoreCase(planet))
                    .filter(jedi -> jedi.getRank().getName().equalsIgnoreCase(rank))
                    .sorted(Comparator.comparingInt(Jedi::getAge))
                    .collect(Collectors.collectingAndThen(Collectors.toList(), jedisList -> {
                        int youngestAge = jedisList.get(0).getAge();
                        return jedisList.stream()
                                .filter(jedi -> jedi.getAge() == youngestAge)
                                .sorted(Comparator.comparing(Jedi::getName))
                                .collect(Collectors.toList());
                    }));
            if(foundYoungestJedis.isEmpty()){
                System.out.println("No jedi on this planet");
            }else{
                System.out.println("Youngest Jedi on the planet:");
                PlanetManager.getJedInfo(foundYoungestJedis);
            }
        }
    }

    public static void printJediInfo(String[] args) {
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        for (Jedi jedi : jedis) {
            if (jedi.getName().equalsIgnoreCase(args[0])) {
                System.out.println("Jedi Name: "+ jedi.getName());
                System.out.println("Jedi Age: " + jedi.getAge());
                System.out.println("Jedi Rank:" + jedi.getRank().getName());
                System.out.println("Jedi Strength:" + jedi.getStrength());
                System.out.println("Inhibited planet: " + jedi.getPlanet().getPlanetName());
            }
        }
    }

    public static List<Jedi> getAllJediByPlanet(String planetName){
        HashSet<Jedi> jedi = Universe.getInstance().getJedi_Poppulation();
        return jedi.stream()
                .filter(jedi1 -> jedi1.getPlanet().getPlanetName().equalsIgnoreCase(planetName))
                .sorted(Comparator.comparing(Jedi::getRank, Comparator.comparingInt(JediRank::getRankNumber))
                        .thenComparing(Jedi::getName))
                .collect(Collectors.toList());
    }

    public static void getMostUsedSaberColor(String[] args) {

        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        String planetName = args[0];

        long green = jedis.stream()
                .filter(jedi -> jedi.getPlanet().getPlanetName().equalsIgnoreCase(planetName))
                .filter(jedi -> jedi.getSaberColor().equals(JediLightSaberColor.Green)).count();
        long blue =  jedis.stream()
                .filter(jedi -> jedi.getPlanet().getPlanetName().equalsIgnoreCase(planetName))
                .filter(jedi -> jedi.getSaberColor().equals(JediLightSaberColor.Blue)).count();
        long yellow = jedis.stream()
                .filter(jedi -> jedi.getPlanet().getPlanetName().equalsIgnoreCase(planetName))
                .filter(jedi -> jedi.getSaberColor().equals(JediLightSaberColor.Yellow)).count();
        long purple = jedis.stream()
                .filter(jedi -> jedi.getPlanet().getPlanetName().equalsIgnoreCase(planetName))
                .filter((jedi -> jedi.getSaberColor().equals(JediLightSaberColor.Purple))).count();
        long red = jedis.stream()
                .filter(jedi -> jedi.getPlanet().getPlanetName().equalsIgnoreCase(planetName))
                .filter(jedi -> jedi.getSaberColor().equals(JediLightSaberColor.Red)).count();
        long cyan = jedis.stream()
                .filter(jedi -> jedi.getPlanet().getPlanetName().equalsIgnoreCase(planetName))
                .filter(jedi -> jedi.getSaberColor().equals(JediLightSaberColor.Cyan)).count();
        long white = jedis.stream()
                .filter(jedi -> jedi.getPlanet().getPlanetName().equalsIgnoreCase(planetName))
                .filter(jedi -> jedi.getSaberColor().equals(JediLightSaberColor.White)).count();
        long orange = jedis.stream()
                .filter(jedi -> jedi.getPlanet().getPlanetName().equalsIgnoreCase(planetName))
                .filter(jedi -> jedi.getSaberColor().equals(JediLightSaberColor.Orange)).count();

        String saberColor = "No available color on this planet with rank GRAND MASTER";

        Map<JediLightSaberColor, Long> saberJediRelation = new HashMap<>();
        for(Jedi jedi: jedis){
            if(jedi.getSaberColor().equals(JediLightSaberColor.Green) && jedi.getRank().equals(JediRank.GRAND_MASTER)){
                saberJediRelation.put(JediLightSaberColor.Green, green);
            }
            if(jedi.getSaberColor().equals(JediLightSaberColor.Blue) && jedi.getRank().equals(JediRank.GRAND_MASTER)){
                saberJediRelation.put(JediLightSaberColor.Blue, blue);
            }
            if(jedi.getSaberColor().equals(JediLightSaberColor.Yellow) && jedi.getRank().equals(JediRank.GRAND_MASTER)){
                saberJediRelation.put(JediLightSaberColor.Yellow, yellow);
            }
            if(jedi.getSaberColor().equals(JediLightSaberColor.Purple) && jedi.getRank().equals(JediRank.GRAND_MASTER)){
                saberJediRelation.put(JediLightSaberColor.Purple, purple);
            }
            if(jedi.getSaberColor().equals(JediLightSaberColor.Red) && jedi.getRank().equals(JediRank.GRAND_MASTER)){
                saberJediRelation.put(JediLightSaberColor.Red, red);
            }
            if(jedi.getSaberColor().equals(JediLightSaberColor.Cyan) && jedi.getRank().equals(JediRank.GRAND_MASTER)){
                saberJediRelation.put(JediLightSaberColor.Cyan, cyan);
            }
            if(jedi.getSaberColor().equals(JediLightSaberColor.White) && jedi.getRank().equals(JediRank.GRAND_MASTER)){
                saberJediRelation.put(JediLightSaberColor.White, white);
            }
            if(jedi.getSaberColor().equals(JediLightSaberColor.Orange) && jedi.getRank().equals(JediRank.GRAND_MASTER)){
                saberJediRelation.put(JediLightSaberColor.Orange, orange);
            }
        }

        Optional<JediLightSaberColor> color = saberJediRelation.keySet()
                .stream()
                .max(Comparator.comparingLong(Enum::ordinal));

        if(color.isPresent()){
            saberColor = color.get().name();
        }

        System.out.println("Most used saber color on" + planetName + "is: " + saberColor);
    }
    public static void getMostUsedSaberColorWithRank(String[] args) {

        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        String planetName = args[0];
        String jediRank = args[1];

        Map<JediLightSaberColor, Long> saberJediRelation = jedis.stream()
                .filter(jedi -> jedi.getPlanet().getPlanetName().equalsIgnoreCase(planetName))
                .filter(jedi -> jedi.getRank().getName().equalsIgnoreCase(jediRank))
                .collect(Collectors.groupingBy(Jedi::getSaberColor, Collectors.counting()));


        Optional<Map.Entry<JediLightSaberColor, Long>> maxEntry = saberJediRelation.entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue));


        JediLightSaberColor enumWithBiggestCount = maxEntry.map(Map.Entry::getKey).orElse(null);

        if (enumWithBiggestCount != null) {
            System.out.println("The saber color with the biggest count of Jedi: " + enumWithBiggestCount);
        } else {
            System.out.println("No Jedi found for the given planet and rank.");
        }
    }
}

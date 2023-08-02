package com.company.jedi;

import com.company.planet.PlanetManager;
import com.company.planet.Planets;
import com.company.universe.Universe;

import java.util.*;
import java.util.stream.Collectors;

public class JediManager {

    public static void createJedi(String[] arr) {
        String givenPlanet = arr[0];
        String givenName = arr[1];
        String givenRank = arr[2];
        JediRank[] jediRanks = JediRank.values();
        JediRank rank = null;
        for(JediRank jediRank: jediRanks){
            if(givenRank.equalsIgnoreCase(jediRank.getName())){
                rank = jediRank;
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
                jedi.add(new Jedi(givenName, rank, Integer.parseInt(arr[3]), arr[4], Double.parseDouble(arr[5]),
                        new Planets(givenPlanet)));
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
            System.out.println("The Jedi" + givenName + "has been removed.");
        }
        else{
            System.out.println("The jedi" + givenName + "has not been found");
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
            if(foundJedi.get().getRank().equals(JediRank.MASTER)){
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
            }
            System.out.println("There are no Jedi on this planet");
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
                System.out.println("Youngest Jedi on the planet:"+ foundYoungestJedis);
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
}

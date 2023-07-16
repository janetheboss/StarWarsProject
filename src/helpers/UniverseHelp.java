package helpers;

import starWars.Jedi;
import starWars.Planets;
import starWars.Universe;
import enums.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class UniverseHelp {
    public static void help() {
        System.out.println("The following commands are supported:"
                + "open <file> opens <file>"
                + "close closes currently opened file"
                + "save saves the currently open file"
                + "saveas <file> saves the currently open file in <file>"
                + "help prints this information"
                + "exit exists the program");
    }

    public static void create_jedi(String[] arr) {
        String givenPlanet = arr[0];
        String givenName = arr[1];
        HashSet<Jedi> jedi = Universe.getInstance().getJedi_Poppulation();
        if (!planetExist(givenPlanet)) {
            System.out.println("Such a planet does not Exist");

        }else {
         Optional<Jedi> foundJedi = jedi.stream()
                 .filter(existingJedi -> existingJedi.getPlanet().getPlanet_name().equalsIgnoreCase(givenPlanet))
                 .filter(existingJedi -> existingJedi.getName().equalsIgnoreCase(givenName))
                 .findAny();
         if(foundJedi.isPresent()){
             System.out.println("There already exists such a jedi on this planet");
         }
         else {
             jedi.add(new Jedi(givenName, arr[2], Integer.parseInt(arr[3]), arr[4], Double.parseDouble(arr[5]),
                     new Planets(givenPlanet)));
             Universe.getInstance().setJedi_Poppulation(jedi);
         }
        }
    }

    public static boolean planetExist(String planetName) {
        HashSet<Planets> planets = Universe.getInstance().getPlanets();
        for (Planets planet : planets) {
            if (planet.getPlanet_name().equalsIgnoreCase(planetName)) {
                return true;
            }
        }
        return false;
    }

    public static void add_planet(String[] args) {
        String givenPlanet = args[0];
        if (planetExist(givenPlanet)) {
            System.out.println("Such a planet already exists");
        } else {
            Universe.getInstance().getPlanets().add(new Planets(givenPlanet));
            System.out.println("Planet was added");
        }
    }

    public static void remove_jedi(String[] args) {
        HashSet<Jedi> jedi = Universe.getInstance().getJedi_Poppulation();
        String givenName = args[0];
        String givenPlanet = args[1];
        Optional<Jedi> foundJedi = jedi.stream()
                .filter(jediToRemove -> jediToRemove.getName().equalsIgnoreCase(givenName))
                .filter(jediToRemove -> jediToRemove.getPlanet().getPlanet_name().equalsIgnoreCase(givenPlanet))
                .findAny();
        if(foundJedi.isPresent()){
            Universe.getInstance().getJedi_Poppulation().remove(foundJedi.get());
            System.out.println("The Jedi" + givenName + "has been removed.");
        }
        else{
            System.out.println("The jedi" + givenName + "has not been found");
        }
    }

    private static String getPreviousRank(String rank) {
        switch (rank.toUpperCase()) {
            case "INITIATE":
                return "YOUNGLING";
            case "PADAWAN":
                return "INITIATE";
            case "KNIGHT_ASPIRANT":
                return "PADAWAN";
            case "KNIGHT":
                return "KNIGHT_ASPIRANT";
            case "MASTER":
                return "KNIGHT";
            case "BATTLE_MASTER":
                return "MASTER";
            case "GRAND_MASTER":
                return "BATTLE_MASTER";
            default:
                return null;
        }
    }

    private static String getNextRank(String rank) {
        switch (rank.toUpperCase()) {
            case "YOUNGLING":
                return "INITIATE";
            case "INITIATE":
                return "PADAWAN";
            case "PADAWAN":
                return "KNIGHT_ASPIRANT";
            case "KNIGHT_ASPIRANT":
                return "KNIGHT";
            case "KNIGHT":
                return "MASTER";
            case "MASTER":
                return "BATTLE_MASTER";
            case "BATTLE_MASTER":
                return "GRAND_MASTER";
            default:
                return null;
        }
    }


    private static double multiplier(double multiplier, double power) throws Exception {
        if (multiplier <= 0) {
            throw new Exception("Multiplier can't be 0 or lower");
        }

        return power / multiplier;
    }

    private static double multiplierPromote(double multiplier, double power) throws Exception {
        if (multiplier <= 0) {
            throw new Exception("Multiplier can't be 0 or lower");
        }

        return power * multiplier;
    }

    public static void demote_jedi(String[] args) throws Exception {
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        String name = args[0];
        Optional<Jedi> foundJedi = jedis.stream().filter(jedi -> jedi.getName().equalsIgnoreCase(name)).findAny();
        if(!foundJedi.isPresent()){
            System.out.println("No Jedi with the name " + name + " was found.");
        }
        else {
            if(foundJedi.get().getJedi_rank().equalsIgnoreCase(Rank.YOUNGLING.name())){
                System.out.println(name + " is already at the lowest rank");
            } else {
                Jedi jedi = foundJedi.get();
                Universe.getInstance().getJedi_Poppulation().remove(jedi);
                jedi.setJedi_rank(getPreviousRank(jedi.getJedi_rank()));
                jedi.setStrength(multiplier(Double.parseDouble(args[1]), jedi.getStrength()));
                System.out.println(jedi.getName() + " has been demoted to " + jedi.getJedi_rank());
                Universe.getInstance().getJedi_Poppulation().add(jedi);
            }
        }
    }

    public static void promote_jedi(String[] args) throws Exception {
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        String name = args[0];
        Optional<Jedi> foundJedi = jedis.stream().filter(jedi -> jedi.getName().equalsIgnoreCase(name)).findAny();
        if(!foundJedi.isPresent()){
            System.out.println("No Jedi with the name " + name + " was found.");
        }
        else {
            if(foundJedi.get().getJedi_rank().equalsIgnoreCase(Rank.MASTER.name())){
                System.out.println(name + " is already at the highest rank");
            } else {
                Jedi jedi = foundJedi.get();
                Universe.getInstance().getJedi_Poppulation().remove(jedi);
                jedi.setJedi_rank(getNextRank(jedi.getJedi_rank()));
                jedi.setStrength(multiplierPromote(Double.parseDouble(args[1]), jedi.getStrength()));
                System.out.println(jedi.getName() + " has been promoted to " + jedi.getJedi_rank());
                Universe.getInstance().getJedi_Poppulation().add(jedi);
            }
        }
    }

    public static void getStrongestJedi(String[] args) {
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        String planet = args[0];
        if(!planetExist(planet)){
            System.out.println("No such planet");
        }else {
           Optional<Jedi> foundStrongestJedi = jedis.stream()
                   .filter(jedi -> jedi.getPlanet().getPlanet_name().equalsIgnoreCase(planet))
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
        if(!planetExist(planet)){
            System.out.println("No such planet");
        }else {
            List<Jedi> foundYoungestJedis = jedis.stream()
                    .filter(jedi -> jedi.getPlanet().getPlanet_name().equalsIgnoreCase(planet))
                    .filter(jedi -> jedi.getJedi_rank().equalsIgnoreCase(rank))
                    .sorted(Comparator.comparingInt(Jedi::getJedi_age))
                    .collect(Collectors.collectingAndThen(Collectors.toList(), jedisList -> {
                        int youngestAge = jedisList.get(0).getJedi_age();
                        return jedisList.stream()
                                .filter(jedi -> jedi.getJedi_age() == youngestAge)
                                .collect(Collectors.toList());
                    }));
            if(foundYoungestJedis.isEmpty()){
                System.out.println("No jedi on this planet");
            }else{
                System.out.println("Youngest Jedi on the planet:"+ foundYoungestJedis);
            }
        }
    }

    public static void print(String[] args) {
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        for (Jedi jedi : jedis) {
            if (jedi.getName().equalsIgnoreCase(args[0])) {
                System.out.println(jedi);
            }
        }
    }

    public static void printPlanet(String[] args) {
        HashSet<Planets> planets = Universe.getInstance().getPlanets();
        for (Planets planet : planets) {
            if (planet.getPlanet_name().equalsIgnoreCase(args[0])) {
                System.out.println(planet);
            }
        }
    }

//    public static void planetName(String[] args) {
//        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
//        HashSet<Planets> planets = Universe.getInstance().getPlanets();
//        TreeSet<String> jediNames = new TreeSet<>();
//
//        for (Planets planet : planets) {
//            for (Jedi jedi : jedis) {
//                if (jedi.getPlanet().equals(planet)) {
//                    jediNames.add(jedi.getName());
//
//                }
//            }
//        }
//        for (String jedi : jediNames) {
//            System.out.println(jedi);
//        }
//    }
}


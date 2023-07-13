package helpers;

import starWars.Jedi;
import starWars.Planets;
import starWars.Universe;
import enums.Rank;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

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
        try {
            String givenPlanet = arr[0];
            String givenName = arr[1];
            HashSet<Planets> planets = Universe.getInstance().getPlanets();
            HashSet<Jedi> jedi = Universe.getInstance().getJedi_Poppulation();
            if (!planetExist(givenPlanet)) {
                for (Jedi jedi1 : jedi) {
                    if (jedi1.getName().equalsIgnoreCase(givenName) && jedi1.getPlanet().getPlanet_name().equalsIgnoreCase(givenPlanet)) {
                        System.out.println("There already exists such a jedi on this planet");
                    } else {
                        jedi.add(new Jedi(givenName, arr[2], Integer.parseInt(arr[3]), arr[4], Double.parseDouble(arr[5]), new Planets(givenPlanet)));
                        Universe.getInstance().getJedi_Poppulation().addAll(jedi);
                    }
                }
            } else {
                System.out.println("Such a planet does not Exist");
            }
        } catch (Exception e) {
            System.out.println("Error");
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
        HashSet<Planets> planets = Universe.getInstance().getPlanets();
        String givenPlanet = args[0];
        if (!planetExist(givenPlanet)) {
            planets.add(new Planets(givenPlanet));
            Universe.getInstance().getPlanets().addAll(planets);
            System.out.println("Planet was added");
        } else {
            System.out.println("Such a planet already exists");
        }
    }

    public static void remove_jedi(String[] args) {
        HashSet<Jedi> jedi = Universe.getInstance().getJedi_Poppulation();
        for (Jedi jedi1 : jedi) {
            String givenName = args[0];
            String givenPlanet = args[1];
            if (jedi1.getName().equalsIgnoreCase(givenName) && jedi1.getPlanet().getPlanet_name().equalsIgnoreCase(givenPlanet)) {
                Universe.getInstance().getJedi_Poppulation().remove(jedi1);
                System.out.println("The Jedi" + givenName + "has been removed.");
            } else {
                System.out.println("The jedi" + givenName + "has not been found");
            }
        }
    }

    public static String getPreviousRank(String rank) {
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

    public static String getNextRank(String rank) {
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


    public static double multiplier(double multiplier, double power) throws Exception {
        if (multiplier <= 0) {
            throw new Exception("Multiplier can't be 0 or lower");
        }

        return power = power / multiplier;
    }

    public static double multiplierPromote(double multiplier, double power) throws Exception {
        if (multiplier <= 0) {
            throw new Exception("Multiplier can't be 0 or lower");
        }

        return power = power * multiplier;
    }

    public static void demote_jedi(String[] args) throws Exception {
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        String name = args[0];
        for (Jedi jedi : jedis) {
            if (jedi.getName().equalsIgnoreCase(jedi.getName())) {
                if (jedi.getJedi_rank().equalsIgnoreCase(Rank.YOUNGLING.name())) {
                    System.out.println(jedi.getName() + " is already at the lowest rank");
                } else {
                    jedi.setJedi_rank(getPreviousRank(jedi.getJedi_rank()));
                    jedi.setStrength(multiplier(Double.parseDouble(args[1]), jedi.getStrength()));
                    System.out.println(jedi.getName() + " has been demoted to " + jedi.getJedi_rank());
                    Universe.getInstance().setJedi_Poppulation(jedis);
                }
            }
            System.out.println("No Jedi with the name " + jedi.getName() + " was found.");
        }
    }

    public static void promote_jedi(String[] args)
            throws Exception {
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        String name = args[0];
        for (Jedi jedi : jedis) {
            if (jedi.getName().equalsIgnoreCase(name)) {
                if (jedi.getJedi_rank().equalsIgnoreCase(Rank.MASTER.name())) {
                    System.out.println(jedi.getName() + " is already at the highest rank");
                } else {
                    jedi.setJedi_rank(getNextRank(jedi.getJedi_rank()));
                    jedi.setStrength(multiplierPromote(Double.parseDouble(args[1]), jedi.getStrength()));
                    System.out.println(jedi.getName() + " has been promoted to " + jedi.getJedi_rank());
                    Universe.getInstance().setJedi_Poppulation(jedis);
                }
            }
            System.out.println("No Jedi with the name " + jedi.getName() + " was found.");
        }
    }

    public static void getStrongestJedi(String[] args) {
        HashSet<Planets> planets = Universe.getInstance().getPlanets();
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        String planet = args[0];
        String strongestJedi = null;
        double maxPower = 0;
        for (Jedi jedi : jedis) {
            if (jedi.getPlanet().getPlanet_name().equalsIgnoreCase(planet)) {
                if (jedi.getStrength() > maxPower) {
                    strongestJedi = jedi.getName();
                    maxPower = jedi.getStrength();

                }
            }
        }
        System.out.println("The strongest on this planet is : " + strongestJedi + " with the stremgth of : " + maxPower);
    }

    public static void getYoungestJedi(String[] args) {
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        HashSet<Planets> planets = Universe.getInstance().getPlanets();
        String planet = args[0];
        String rank = args[1];
        String youngestJediName = null;
        int youngestJediAge = Integer.MAX_VALUE;

        TreeMap<Integer, Jedi> jedisByAge = new TreeMap<>();

        for (Jedi jedi : jedis) {
            if (jedi.getPlanet().getPlanet_name().equalsIgnoreCase(planet)
                    && jedi.getJedi_rank().equalsIgnoreCase(rank)) {
                int age = jedi.getJedi_age();
                if (age < youngestJediAge) {
                    youngestJediAge = age;
                    youngestJediName = jedi.getName();
                }
                jedisByAge.put(age, jedi);
            }
        }

        if (jedisByAge.size() > 1) {
            youngestJediName = jedisByAge.firstEntry().getValue().getName();
        }

        System.out.println("The youngest Jedi is " + youngestJediName);
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

    public static void planetName(String[] args) {
        HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
        HashSet<Planets> planets = Universe.getInstance().getPlanets();
        TreeSet<String> jediNames = new TreeSet<>();

        for (Planets planet : planets) {
            for (Jedi jedi : jedis) {
                if (jedi.getPlanet().equals(planet)) {
                    jediNames.add(jedi.getName());

                }
            }
        }
        for (String jedi : jediNames) {
            jedi.toString();
        }
    }
}


package helpers;

import StarWars.Jedi;
import StarWars.Planets;
import StarWars.Universe;
import enums.Rank;

import java.util.ArrayList;
import java.util.HashSet;

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
            case "PADWAN": {
                return "YOUNGLING";
            }
            case "KNIGHT": {
                return "PADWAN";
            }
            case "MASTER": {
                return "KNIGHT";
            }
            default: {
                return null;
            }
        }
    }
    public static String getNextRank(String rank) {
        switch (rank.toUpperCase())
        {
            case "YOUNGLING" :
            {
                return "PADWAN";
            }
            case "PADWAN": {
                return "KNIGHT";
            }
            default: {
                return null;
            }
        }
    }

    public static double multiplier(double multiplier,double power) throws Exception {
        if(multiplier <= 0 )
        { throw new Exception("Multiplier can't be 0 or lower");}

                return power = power / multiplier;
    }

    public static double multiplierPromote(double multiplier,double power) throws Exception {
        if(multiplier <= 0 )
        { throw new Exception("Multiplier can't be 0 or lower");}

        return power = power * multiplier;
    }
        public static void demote_jedi (String[] args) throws Exception {
            HashSet<Jedi> jedis = Universe.getInstance().getJedi_Poppulation();
            String name = args[0];
            for (Jedi jedi : jedis) {
                if (jedi.getName().equalsIgnoreCase(jedi.getName())) {
                    if (jedi.getJedi_rank().equalsIgnoreCase(Rank.YOUNGLING.name())) {
                        System.out.println(jedi.getName() + " is already at the lowest rank");
                    } else {
                        jedi.setJedi_rank(getPreviousRank(jedi.getJedi_rank()));
                        jedi.setStrength(multiplier(Double.parseDouble(args[1]),jedi.getStrength()));
                        System.out.println(jedi.getName() + " has been demoted to " + jedi.getJedi_rank());
                        Universe.getInstance().setJedi_Poppulation(jedis);
                    }
                }
                System.out.println("No Jedi with the name " + jedi.getName() + " was found.");
            }
        }
         public static void promote_jedi (String[] args)
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
    }

package com.company.planet;


import com.company.jedi.Jedi;
import com.company.jedi.JediHelper;
import com.company.jedi.JediManager;
import com.company.universe.Universe;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PlanetManager {

    public static boolean planetExist(String planetName) {
        HashSet<Planet> planets = Universe.getInstance().getPlanets();
        for (Planet planet : planets) {
            if (planetName.equalsIgnoreCase(planet.getPlanetName())) {
                return true;
            }
        }
        return false;
    }

    public static void addPlanet(String[] args) {
        String givenPlanet = args[0];
        if (planetExist(givenPlanet)) {
            System.out.println("Such a planet already exists");
        } else {
            Universe.getInstance().getPlanets().add(new Planet(givenPlanet));
            System.out.println("Planet was added");
        }
    }



    public static void printInfo(String[] args) {
        String name = args[0];
        if(planetExist(name)){
            List<Jedi> jedis = JediManager.getAllJediByPlanet(name);
            System.out.println("Planet Name: " + name);
            System.out.println("Jedi inhabitants:");
            getJedInfo(jedis);
        }

        if(JediHelper.jediExists(name)){
            JediManager.printJediInfo(args);
        }
    }

    public static void getJediInhabitantsInPlanets(String[] args) {
        String planetName = args[0];
        String planetName2 = args[1];
        List<Jedi> jedis = JediManager.getAllJediByPlanet(planetName);
        List<Jedi> jedis2 = JediManager.getAllJediByPlanet(planetName2);
        jedis.addAll(jedis2);
        List<Jedi> jedis3 = jedis.stream().sorted(Comparator.comparing(Jedi::getName)).collect(Collectors.toList());
        getJedInfo(jedis3);
    }

    public static void getJedInfo(List<Jedi> jedis3) {
        for (Jedi jedi: jedis3){
            System.out.println("Jedi Name: "+ jedi.getName());
            System.out.println("Jedi Age: " + jedi.getAge());
            System.out.println("Jedi Rank:" + jedi.getRank().getName());
            System.out.println("Jedi Strength:" + jedi.getStrength());
        }
    }
}


package com.company.universe;

import com.company.jedi.Jedi;
import com.company.planet.Planet;

import java.util.HashSet;

public class Universe {
    private String fileName;
    private HashSet<Planet> planets;
    private HashSet<Jedi> jedi_Poppulation;
    private static Universe universe_instance = null;
    private Universe ()
    {
    }
    public static Universe getInstance()
    {
        if(universe_instance == null)
        {
            universe_instance = new Universe();
        }
        return universe_instance;
    }
    public void close ()
    {
        universe_instance = null;
    }

    public HashSet<Jedi> getJedi_Poppulation() {
        return jedi_Poppulation;
    }

    public void setJedi_Poppulation(HashSet<Jedi> jedi_Poppulation) {
        this.jedi_Poppulation = jedi_Poppulation;
    }

    public Universe getuniverse_instance()
    {
        return universe_instance;
    }

    public HashSet<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(HashSet<Planet> planets) {
        this.planets = planets;
    }

    public static Universe getUniverse_instance() {
        return universe_instance;
    }

    public static void setUniverse_instance(Universe universe_instance) {
        Universe.universe_instance = universe_instance;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}

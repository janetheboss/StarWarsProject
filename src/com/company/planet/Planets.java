package com.company.planet;

public class Planets {
    private String planetName;

    public Planets(String planetName) {
        this.planetName = planetName;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    @Override
    public String toString() {
        return planetName;
    }
}

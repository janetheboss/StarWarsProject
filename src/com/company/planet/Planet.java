package com.company.planet;

public class Planet {
    private String planetName;

    public Planet(String planetName) {
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

package com.company.jedi;

import com.company.planet.Planet;

public class Jedi {
    private String name;
    private JediRank rank;
    private int age;
    private JediLightSaberColor saberColor;
    private Double strength;
    private Planet planet;

    public Jedi(String name, JediRank rank, int age, JediLightSaberColor saberColor, Double strength, Planet planet) {
        this.name = name;
        this.rank = rank;
        this.age = age;
        this.saberColor = saberColor;
        this.strength = strength;
        this.planet = planet;
    }
    public Planet getPlanet() {
        return planet;
    }
    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public JediRank getRank() {
        return rank;
    }
    public void setRank(JediRank rank) {
        this.rank = rank;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public JediLightSaberColor getSaberColor() {
        return saberColor;
    }
    public void setSaberColor(JediLightSaberColor saberColor) {
        this.saberColor = saberColor;
    }
    public Double getStrength() {
        return strength;
    }
    public void setStrength(Double strength) {
        this.strength = strength;
    }
}

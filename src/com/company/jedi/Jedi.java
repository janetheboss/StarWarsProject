package com.company.jedi;

import com.company.planet.Planets;

public class Jedi {
    private String name;
    private JediRank rank;
    private int age;
    private String saber_color;
    private Double strength;
    private Planets planet;

    public Jedi(String name, JediRank rank, int age, String saber_color, Double strength, Planets planet) {
        this.name = name;
        this.rank = rank;
        this.age = age;
        this.saber_color = saber_color;
        this.strength = strength;
        this.planet = planet;
    }

    public Planets getPlanet() {
        return planet;
    }

    public void setPlanet(Planets planet) {
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

    public String getSaber_color() {
        return saber_color;
    }

    public void setSaber_color(String saber_color) {
        this.saber_color = saber_color;
    }

    public Double getStrength() {
        return strength;
    }
    public void setStrength(Double strength) {
        this.strength = strength;
    }
}

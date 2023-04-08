package StarWars;

import enums.Rank;

public class Jedi {
    private String name;
    private String jedi_rank;
    private int jedi_age ;
    private String saber_color;
    private Double strength;
    private Planets planet;

    public Jedi(String name, String jedi_rank, int jedi_age, String saber_color, Double strength, Planets planet) {
        this.name = name;
        this.jedi_rank = jedi_rank;
        this.jedi_age = jedi_age;
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

    public String getJedi_rank() {
        return jedi_rank;
    }

    public void setJedi_rank(String jedi_rank) {
        this.jedi_rank = jedi_rank;
    }

    public int getJedi_age() {
        return jedi_age;
    }

    public void setJedi_age(int jedi_age) {
        this.jedi_age = jedi_age;
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

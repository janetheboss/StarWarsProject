package StarWars;

import java.util.HashSet;

public class Planets {
    private String planet_name;

    public Planets(String planet_name) {
        this.planet_name = planet_name;
    }
    public String getPlanet_name() {
        return planet_name;
    }

    public void setPlanet_name(String planet_name) {
        this.planet_name = planet_name;
    }
}

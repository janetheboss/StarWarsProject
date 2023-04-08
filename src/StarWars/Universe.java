package StarWars;
import java.util.HashSet;

public class Universe {
    private HashSet<Planets> planets;
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

    public HashSet<Planets> getPlanets() {
        return planets;
    }

    public void setPlanets(HashSet<Planets> planets) {
        this.planets = planets;
    }

    public static Universe getUniverse_instance() {
        return universe_instance;
    }

    public static void setUniverse_instance(Universe universe_instance) {
        Universe.universe_instance = universe_instance;
    }
}

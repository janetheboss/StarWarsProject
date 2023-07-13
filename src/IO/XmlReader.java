package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import starWars.Jedi;
import starWars.Planets;
import starWars.Universe;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlReader {
    private static final String PLANET = "planet";
    private static final String JEDI = "jedi";
    private static final String NAME = "name";
    private static final String RANK = "rank";
    private static final String AGE = "age";
    private static final String SABER_COLOR = "saber_color";
    private static final String STRENGTH = "strength";
    private static final String PLANET_NAME = "planet_name";
    private static final String PLANETS = "planets";
    private static final String JEDI_POPULATION = "jedi_population";

    public static void readUniverse(String[] fileName) throws Exception {
        File file = new File(fileName[0]);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found!");
        }

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new FileInputStream(file));

        // Read planets
        HashSet<Planets> planets = new HashSet<>();
        NodeList planetNodes = doc.getElementsByTagName(PLANET);
        for (int i = 0; i < planetNodes.getLength(); i++) {
            Node planetNode = planetNodes.item(i);
            if (planetNode.getNodeType() == Node.ELEMENT_NODE) {
                Element planetElement = (Element) planetNode;
                String planetName = planetElement.getAttribute(PLANET_NAME);
                planets.add(new Planets(planetName));
            }
        }

        // Read Jedi population
        HashSet<Jedi> jediPopulation = new HashSet<>();
        NodeList jediNodes = doc.getElementsByTagName(JEDI);
        for (int i = 0; i < jediNodes.getLength(); i++) {
            Node jediNode = jediNodes.item(i);
            if (jediNode.getNodeType() == Node.ELEMENT_NODE) {
                Element jediElement = (Element) jediNode;
                String name = jediElement.getAttribute(NAME);
                String rank = jediElement.getAttribute(RANK);
                int age = Integer.parseInt(jediElement.getAttribute(AGE));
                String saberColor = jediElement.getAttribute(SABER_COLOR);
                Double strength = Double.parseDouble(jediElement.getAttribute(STRENGTH));
                String planetName = jediElement.getAttribute(PLANET_NAME);
                Planets planet = null;
                for (Planets p : planets) {
                    if (p.getPlanet_name().equals(planetName)) {
                        planet = p;
                        break;
                    }
                }
                Jedi jedi = new Jedi(name, rank, age, saberColor, strength, planet);
                jediPopulation.add(jedi);
            }
        }

        // Create universe instance
        Universe universe = Universe.getInstance();
        universe.setPlanets(planets);
        universe.setJedi_Poppulation(jediPopulation);
    }
}

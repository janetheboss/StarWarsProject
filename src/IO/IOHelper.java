package IO;

import starWars.Jedi;
import starWars.Planets;
import starWars.Universe;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class IOHelper {
    private File file;

    public IOHelper(File file) {
        this.file = file;
    }

    public void save() throws IOException, TransformerException, ParserConfigurationException {
        if (file == null) {
            throw new IOException("File not found.");
        }
        saveAs(file);
    }

    public void saveAs(File newFile) throws IOException, TransformerException, ParserConfigurationException {
        if (newFile == null) {
            throw new IOException("File not found.");
        }
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element rootElement = document.createElement("Universe");

        Universe universe = Universe.getInstance();

        HashSet<Planets> planets = universe.getPlanets();
        Element planetsElement = document.createElement("Planets");
        for (Planets planet : planets) {
            Element planetElement = document.createElement("Planet");
            planetElement.setTextContent(planet.getPlanet_name());
            planetsElement.appendChild(planetElement);
        }
        rootElement.appendChild(planetsElement);

        HashSet<Jedi> jediPopulation = universe.getJedi_Poppulation();
        Element jediElement = document.createElement("Jedis");
        for (Jedi jedi : jediPopulation) {
            Element jediNode = document.createElement("Jedi");
            jediNode.appendChild(createElementWithTextContent(document, "Name", jedi.getName()));
            jediNode.appendChild(createElementWithTextContent(document, "Rank", jedi.getJedi_rank()));
            jediNode.appendChild(createElementWithTextContent(document, "Age", String.valueOf(jedi.getJedi_age())));
            jediNode.appendChild(createElementWithTextContent(document, "SaberColor", jedi.getSaber_color()));
            jediNode.appendChild(createElementWithTextContent(document, "Strength", String.valueOf(jedi.getStrength())));
            jediNode.appendChild(createElementWithTextContent(document, "Planet", jedi.getPlanet().getPlanet_name()));
            jediElement.appendChild(jediNode);
        }
        rootElement.appendChild(jediElement);

        document.appendChild(rootElement);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(newFile);
        transformer.transform(source, result);
    }
    private static Node createElementWithTextContent(Document document, String elementName, String textContent) {
        Element element = document.createElement(elementName);
        element.setTextContent(textContent);
        return element;
    }
}

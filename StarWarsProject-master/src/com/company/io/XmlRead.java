package com.company.io;

import com.company.jedi.Jedi;
import com.company.jedi.JediLightSaberColor;
import com.company.jedi.JediRank;
import com.company.planet.Planet;
import com.company.universe.Universe;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashSet;

public class XmlRead {

    public void readXmlFile(String fileName) {
        Universe universe = Universe.getInstance();
        HashSet<Planet> planets = new HashSet<>();
        HashSet<Jedi> jediPopulation = new HashSet<>();

        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList planetNodes = doc.getElementsByTagName("Planet");
            for (int i = 0; i < planetNodes.getLength(); i++) {
                Node planetNode = planetNodes.item(i);
                if (planetNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element planetElement = (Element) planetNode;
                    NodeList nameNodes = planetElement.getElementsByTagName("Name");
                    String planetName = "";
                    if (nameNodes.getLength() > 0) {
                        planetName = nameNodes.item(0).getTextContent();
                    }
                    Planet planet = new Planet(planetName);
                    planets.add(planet);
                }
            }


            NodeList jediNodes = doc.getElementsByTagName("Jedi");
            for (int i = 0; i < jediNodes.getLength(); i++) {
                Node jediNode = jediNodes.item(i);
                if (jediNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element jediElement = (Element) jediNode;
                    String name = jediElement.getElementsByTagName("Name").item(0).getTextContent();
                    NodeList rankNodes = jediElement.getElementsByTagName("Rank");
                    String rank = rankNodes.getLength() > 0 ? rankNodes.item(0).getTextContent() : "";
                    int age = Integer.parseInt(jediElement.getElementsByTagName("Age").item(0).getTextContent());
                    NodeList saberColorNodes = jediElement.getElementsByTagName("SaberColor");
                    String saberColor = saberColorNodes.getLength() > 0 ? saberColorNodes.item(0).getTextContent() : "";
                    double strength = Double.parseDouble(jediElement.getElementsByTagName("Strength").item(0).getTextContent());
                    String planetName = jediElement.getElementsByTagName("Planet").item(0).getTextContent();
                    JediRank jediRank = getJediRank(rank);
                    JediLightSaberColor jediLightSaberColor = getJediColor(saberColor);
                    Planet planet = getPlanetByName(planets, planetName);
                    Jedi jedi = new Jedi(name, jediRank, age, jediLightSaberColor, strength, planet);
                    jediPopulation.add(jedi);
                }
            }

            universe.setPlanets(planets);
            universe.setJedi_Poppulation(jediPopulation);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Planet getPlanetByName(HashSet<Planet> planets, String planetName) {
        for (Planet planet : planets) {
            if (planet.getPlanetName().equalsIgnoreCase(planetName)) {
                return planet;
            }
        }
        return null;
    }

    private JediRank getJediRank(String rank) {
        JediRank[] ranks = JediRank.values();
        for (JediRank jediRank : ranks) {
            if (rank.equalsIgnoreCase(jediRank.getName())) {
                return jediRank;
            }
        }
        return null;
    }

    private JediLightSaberColor getJediColor(String color) {
        JediLightSaberColor[] colors = JediLightSaberColor.values();
        for (JediLightSaberColor jediLightSaberColor : colors) {
            if (color.equalsIgnoreCase(jediLightSaberColor.name())) {
                return jediLightSaberColor;
            }
        }
        return null;
    }

}
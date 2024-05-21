package com.company.io;

import com.company.jedi.Jedi;
import com.company.planet.Planet;
import com.company.universe.Universe;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class XmlWrite {

    public void writeXmlFile(Universe universe, String fileName) {
        StringBuilder xmlContent = new StringBuilder();
        xmlContent.append("<Universe>\n");

        HashSet<Planet> planets = universe.getPlanets();
        xmlContent.append("    <Planets>\n");
        for (Planet planet : planets) {
            xmlContent.append("        <Planet>\n");
            xmlContent.append("            <Name>").append(planet.getPlanetName()).append("</Name>\n");
            xmlContent.append("        </Planet>\n");
        }
        xmlContent.append("    </Planets>\n");

        HashSet<Jedi> jediPopulation = universe.getJedi_Poppulation();
        xmlContent.append("    <JediPopulation>\n");
        for (Jedi jedi : jediPopulation) {
            xmlContent.append("        <Jedi>\n");
            xmlContent.append("            <Name>").append(jedi.getName()).append("</Name>\n");
            xmlContent.append("            <Rank>").append(jedi.getRank()).append("</Rank>\n");
            xmlContent.append("            <Age>").append(jedi.getAge()).append("</Age>\n");
            xmlContent.append("            <SaberColor>").append(jedi.getSaberColor()).append("</SaberColor>\n");
            xmlContent.append("            <Strength>").append(jedi.getStrength()).append("</Strength>\n");
            xmlContent.append("            <Planet>").append(jedi.getPlanet().getPlanetName()).append("</Planet>\n");
            xmlContent.append("        </Jedi>\n");
        }
        xmlContent.append("    </JediPopulation>\n");

        xmlContent.append("</Universe>");
    }
}

//package com.company.io;
//
//import com.company.jedi.Jedi;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.OutputKeys;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import java.io.File;
//import java.util.HashSet;
//
//public class XmlWrite{
//    private File[] outputFiles;
//
//    public void XMLWriter(File[] outputFiles) {
//        this.outputFiles = outputFiles;
//    }
//
//    public void writeJediData(HashSet<Jedi> jediSet, File file) {
//        try {
//            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//
//            // root elements
//            Document doc = docBuilder.newDocument();
//            Element rootElement = doc.createElement("Jedis");
//            doc.appendChild(rootElement);
//
//            // write Jedi data
//            for (Jedi jedi : jediSet) {
//                Element jediElement = doc.createElement("Jedi");
//                rootElement.appendChild(jediElement);
//
//                Element nameElement = doc.createElement("Name");
//                nameElement.appendChild(doc.createTextNode(jedi.getName()));
//                jediElement.appendChild(nameElement);
//
//                Element rankElement = doc.createElement("Rank");
//                rankElement.appendChild(doc.createTextNode(jedi.getRank()));
//                jediElement.appendChild(rankElement);
//
//                Element ageElement = doc.createElement("Age");
//                ageElement.appendChild(doc.createTextNode(Integer.toString(jedi.getAge())));
//                jediElement.appendChild(ageElement);
//
//                Element planetElement = doc.createElement("Planet");
//                planetElement.appendChild(doc.createTextNode(jedi.getPlanet().getPlanetName()));
//                jediElement.appendChild(planetElement);
//
//                Element saberColorElement = doc.createElement("SaberColor");
//                saberColorElement.appendChild(doc.createTextNode(jedi.getSaber_color()));
//                jediElement.appendChild(saberColorElement);
//
//                Element strengthElement = doc.createElement("Strength");
//                strengthElement.appendChild(doc.createTextNode(Double.toString(jedi.getStrength())));
//                jediElement.appendChild(strengthElement);
//            }
//
//            // write the content into xml files
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
//            DOMSource source = new DOMSource(doc);
//
//            for (File outputFile : outputFiles) {
//                StreamResult result = new StreamResult(outputFile);
//                transformer.transform(source, result);
//                System.out.println("Jedi data was successfully written to " + outputFile.getAbsolutePath());
//            }
//        } catch (ParserConfigurationException | TransformerException e) {
//            e.printStackTrace();
//        }
//    }
//}
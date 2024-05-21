package com.company.command;

import com.company.cli.Command;
import com.company.io.XmlWrite;
import com.company.universe.Universe;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Save implements Command {
    @Override
    public void execute(String[] args) throws IOException, ParserConfigurationException, TransformerException {
        if (Universe.getUniverse_instance() != null) {
            if (args.length != 0) {
                Universe universe = Universe.getInstance();
                XmlWrite xmlWrite = new XmlWrite();
                xmlWrite.writeXmlFile(universe, universe.getFileName());
                System.out.println("Successfully saved file");
            } else {
                System.out.println("Missing file name argument");
            }
        }else{
            System.out.println("You must open a file first");
        }
    }
}

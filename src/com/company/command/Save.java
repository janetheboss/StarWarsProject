//package com.company.command;
//
//import com.company.io.XmlWrite;
//import com.company.cli.Command;
//import com.company.jedi.Jedi;
//import com.company.universe.Universe;
//
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.TransformerException;
//import java.io.File;
//import java.io.IOException;
//import java.util.HashSet;
//
//public class Save implements Command {
//    @Override
//    public void execute(String[] args) throws IOException, ParserConfigurationException, TransformerException {
//        HashSet<Jedi> jediSet = Universe.getInstance().getJedi_Poppulation();
//        if (!jediSet.isEmpty()) {
//            if (args.length != 0) {
//                String fileName = args[0];
//                File file = new File(fileName);
//                XmlWrite xmlWrite = new XmlWrite();
//                xmlWrite.writeJediData(jediSet, file);
//                System.out.println("Successfully saved to " + file.getAbsolutePath());
//            } else {
//                System.out.println("Missing file name argument");
//            }
//        } else {
//            System.out.println("There are no Jedi to save");
//        }
//    }
//}

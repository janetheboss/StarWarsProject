package com.company.comands;

import IO.XmlWrite;
import Interfaces.Command;
import starWars.Jedi;
import starWars.Universe;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class SaveAs implements Command {
    @Override
    public void execute(String[] args) {
        if (!(Universe.getInstance() == null)) {
            if (args.length != 0) {
                String filePath = args[0];

                try {
                    File file = new File(filePath);
                    if (file.exists()) {
                        System.out.println("File already exists. Do you want to overwrite it? (Y/N)");
                        Scanner scanner = new Scanner(System.in);
                        String answer = scanner.nextLine().toUpperCase();
                        if (!answer.equals("Y")) {
                            return;
                        }
                    }

                    XmlWrite xmlWrite = new XmlWrite();
                    HashSet<Jedi> jediSet = Universe.getInstance().getJedi_Poppulation();
                    xmlWrite.writeJediData(jediSet, file);
                    System.out.println("Successfully saved " + filePath);
                } catch (Exception e) {
                    System.out.println("Failed to save the data. " + e.getMessage());
                }
            }
        }
    }
}
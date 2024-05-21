package com.company.command;

import com.company.cli.Command;
import com.company.io.XmlWrite;
import com.company.universe.Universe;

public class SaveAs implements Command {
    @Override
    public void execute(String[] args) {
        if (Universe.getInstance() != null) {
            if(args.length != 1){
                System.out.println("Command is saveas <file_name>");
            }else {
                String fileName = args[0];
                XmlWrite xmlWrite = new XmlWrite();
                Universe universe = Universe.getInstance();
                xmlWrite.writeXmlFile(universe, fileName);
                System.out.println("Successfully saved " + fileName);
            }
        }else {
          System.out.println("You must open a file first");
        }
    }
}
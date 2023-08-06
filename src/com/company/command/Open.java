package com.company.command;

import com.company.cli.Command;
import com.company.io.XmlRead;
import com.company.universe.Universe;

public class Open implements Command {
    @Override
    public void execute(String[] args) throws Exception {
        if(Universe.getUniverse_instance() == null){
           Universe.getInstance().readFromXml(args[0]);
        } else{
            System.out.println("App already opened, please close it before opening another");
        }
    }
}

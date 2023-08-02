package com.company.command;

import com.company.cli.Command;
import com.company.jedi.JediManager;
import com.company.universe.Universe;

public class RemoveJedi implements Command {
    @Override
    public void execute(String[] args) {
        if(!(Universe.getInstance()==null))
        {
            if(args.length != 5)
            {
                System.out.println("removeJedi   <jedi_name> <planet_name>");
            }else
            {
                JediManager.removeJedi(args);
            }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

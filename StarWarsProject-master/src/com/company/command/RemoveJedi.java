package com.company.command;

import com.company.cli.Command;
import com.company.jedi.JediManager;
import com.company.universe.Universe;

public class RemoveJedi implements Command {
    @Override
    public void execute(String[] args) {
        if(Universe.getUniverse_instance()!=null)
        {
            if(args.length != 2)
            {
                System.out.println("remove_jedi <jedi_name> <planet_name>");
            }else
            {
                JediManager.removeJedi(args);
            }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

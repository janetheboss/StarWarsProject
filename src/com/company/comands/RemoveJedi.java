package com.company.comands;

import Interfaces.Command;
import StarWars.Universe;
import helpers.UniverseHelp;

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
                UniverseHelp.remove_jedi(args);
            }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

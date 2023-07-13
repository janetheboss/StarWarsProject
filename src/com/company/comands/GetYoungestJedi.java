package com.company.comands;

import Interfaces.Command;
import starWars.Universe;
import helpers.UniverseHelp;

public class GetYoungestJedi implements Command {
    @Override
    public void execute(String[] args) {
        if(!(Universe.getInstance()==null))
        {
            if(args.length != 2)
            {
                System.out.println("It's get_youngest_jedi <planet_name> <jedi_rank> ");
            }else
            {
                UniverseHelp.getYoungestJedi(args);
            }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

package com.company.comands;

import Interfaces.Command;
import starWars.Universe;
import helpers.UniverseHelp;

public class GetStrongestJedi implements Command {
    @Override
    public void execute(String[] args) {
        if(!(Universe.getInstance()==null))
        {
            if(args.length != 1)
            {
                System.out.println("It's get_strongest_jedi ,<planet_name> ");
            }else
            {
                UniverseHelp.getStrongestJedi(args);
            }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
    }

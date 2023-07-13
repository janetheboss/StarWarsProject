package com.company.comands;

import Interfaces.Command;
import starWars.Universe;
import helpers.UniverseHelp;

public class AddPlanet implements Command {
    @Override
        public void execute(String[] args) {
            if(!(Universe.getInstance()==null))
            {
                if(args.length != 1)
                {
                    System.out.println("It's add_planet <planet_name>");
                }else
                {
                    UniverseHelp.add_planet(args);
                }
            }else {System.out.println("OPEN THE FILE FIRST");}
        }
    }

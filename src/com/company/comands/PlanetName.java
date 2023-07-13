package com.company.comands;

import Interfaces.Command;
import starWars.Universe;
import helpers.UniverseHelp;

public class PlanetName implements Command {
    @Override
    public void execute(String[] args) {
            if(!(Universe.getInstance()==null))
            {
                if(args.length != 1)
                {
                    System.out.println("It's <planet_name> <planet_name> ");
                }else
                {
                    UniverseHelp.printPlanet(args);
                }
            }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

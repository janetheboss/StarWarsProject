package com.company.command;

import com.company.cli.Command;
import com.company.universe.Universe;
import com.company.planet.PlanetManager;

public class PlanetName implements Command {
    @Override
    public void execute(String[] args) {
            if(!(Universe.getInstance()==null))
            {
                if(args.length != 2)
                {
                    System.out.println("It's planet_name <planet_name> <planet_name> ");
                }else
                {
                    PlanetManager.getJediInhabitantsInPlanets(args);
                }
            }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

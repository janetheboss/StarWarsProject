package com.company.command;

import com.company.cli.Command;
import com.company.universe.Universe;
import com.company.planet.PlanetManager;

public class AddPlanet implements Command {
    @Override
        public void execute(String[] args) {
            if(Universe.getUniverse_instance() != null)
            {
                if(args.length != 1)
                {
                    System.out.println("It's add_planet <planet_name>");
                }else
                {
                    PlanetManager.addPlanet(args);
                }
            }else {System.out.println("OPEN THE FILE FIRST");}
        }
    }


package com.company.command;

import com.company.cli.Command;
import com.company.universe.Universe;
import com.company.planet.PlanetManager;

public class Print implements Command {
    @Override
    public void execute(String[] args) {
        if (Universe.getInstance() == null) {
            System.out.println("No file is open.");
            return;
        }
        if (args.length != 1) {
            System.out.println("The command is Print <planet_name/jedi_name>");
        } else {
            PlanetManager.printInfo(args);
        }
    }
}

package com.company.comands;

import Interfaces.Command;
import starWars.Universe;
import helpers.UniverseHelp;

public class Print implements Command {
    @Override
    public void execute(String[] args) {
        if (Universe.getInstance() == null) {
            System.out.println("No file is open.");
            return;
        }
        if (args.length != 0) {
            System.out.println("The command is Print");
        } else {
            UniverseHelp.print(args);
        }
    }
}

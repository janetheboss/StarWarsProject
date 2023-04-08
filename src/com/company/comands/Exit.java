package com.company.comands;

import Interfaces.Command;
import StarWars.Universe;

public class Exit implements Command {
    @Override
    public void execute(String[] args) {
        if (!(Universe.getInstance() == null))
        {
            if (args.length != 0)
            {
                System.out.println("The command is Exit");
            } else {
                System.exit(0);
            }
        }
    }
}

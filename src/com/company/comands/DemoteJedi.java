package com.company.comands;

import Interfaces.Command;
import starWars.Universe;
import helpers.UniverseHelp;

public class DemoteJedi implements Command {
    @Override
    public void execute(String[] args) throws Exception {
        if(!(Universe.getInstance()==null))
        {
            if(args.length != 1)
            {
                System.out.println("It's demote_jedi <jedi_name> <multiplier>");
            }else
            {
                UniverseHelp.demote_jedi(args);
            }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

package com.company.comands;

import Interfaces.Command;
import StarWars.Universe;
import helpers.UniverseHelp;

public class Create_jedi implements Command {
    @Override
    public void execute(String[] args) {
        if(!(Universe.getInstance()==null))
        {
            if(args.length != 5)
            {
                System.out.println("It's create_jedi <planet_name> <jedi_name>  <jedi_rank> <jedi_age>  <saber_color> <jedi_strength>");
            }else
                {
                    UniverseHelp.create_jedi(args);
                }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

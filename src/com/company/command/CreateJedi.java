package com.company.command;

import com.company.cli.Command;
import com.company.jedi.JediManager;
import com.company.universe.Universe;

public class CreateJedi implements Command {
    @Override
    public void execute(String[] args) {
        if(Universe.getUniverse_instance()!=null)
        {
            if(args.length != 6)
            {
                System.out.println("It's create_jedi <planet_name> <jedi_name>  <jedi_rank> <jedi_age>  <saber_color> <jedi_strength>");
            }else
                {
                    JediManager.createJedi(args);
                }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

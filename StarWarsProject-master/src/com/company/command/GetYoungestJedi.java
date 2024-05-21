package com.company.command;

import com.company.cli.Command;
import com.company.jedi.JediManager;
import com.company.universe.Universe;

public class GetYoungestJedi implements Command {
    @Override
    public void execute(String[] args) {
        if(!(Universe.getInstance()==null))
        {
            if(args.length != 2)
            {
                System.out.println("It's get_youngest_jedi <planet_name> <jedi_rank> ");
            }else
            {
                JediManager.getYoungestJedi(args);
            }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

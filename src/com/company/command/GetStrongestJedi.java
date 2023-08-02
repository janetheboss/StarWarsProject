package com.company.command;

import com.company.cli.Command;
import com.company.jedi.JediManager;
import com.company.universe.Universe;

public class GetStrongestJedi implements Command {
    @Override
    public void execute(String[] args) {
        if(!(Universe.getInstance()==null))
        {
            if(args.length != 1)
            {
                System.out.println("It's get_strongest_jedi ,<planet_name> ");
            }else
            {
                JediManager.getStrongestJedi(args);
            }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
    }

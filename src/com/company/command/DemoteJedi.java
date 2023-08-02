package com.company.command;

import com.company.cli.Command;
import com.company.jedi.JediManager;
import com.company.universe.Universe;

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
                JediManager.demoteJedi(args);
            }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

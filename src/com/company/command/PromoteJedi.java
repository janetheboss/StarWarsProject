package com.company.command;

import com.company.cli.Command;
import com.company.jedi.JediManager;
import com.company.universe.Universe;

public class PromoteJedi implements Command {
    @Override
    public void execute(String[] args) throws Exception {
        if(Universe.getUniverse_instance()!=null)
        {
            if(args.length != 2)
            {
                System.out.println("It's promote_jedi <jedi_name> <multiplier>");
            }else
            {
                JediManager.promoteJedi(args);
            }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

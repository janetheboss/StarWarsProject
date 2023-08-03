package com.company.command;

import com.company.cli.Command;
import com.company.jedi.JediManager;
import com.company.universe.Universe;

public class GetMostUsedSaberColor implements Command {
    @Override
    public void execute(String[] args) throws Exception {
        if(!(Universe.getInstance()==null))
        {
            if(args.length == 1)
            {

                JediManager.getMostUsedSaberColor(args);
            }
            if (args.length == 2)
            {
                JediManager.getMostUsedSaberColorWithRank(args);
            }
                else
            {
                System.out.println("It's get_most_used_saber_color <planet_name> <jedi_rank>(jedi_rank is optional) ");
            }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

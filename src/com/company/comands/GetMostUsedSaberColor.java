package com.company.comands;

import Interfaces.Command;
import starWars.Universe;
import helpers.ColorHelper;

public class GetMostUsedSaberColor implements Command {
    @Override
    public void execute(String[] args) throws Exception {
        if(!(Universe.getInstance()==null))
        {
            if(args.length == 1)
            {
                ColorHelper instace=ColorHelper.getInstance();
                instace.getMostUsedSaberColor(args);
            }
            if (args.length == 2)
            {
                ColorHelper instace=ColorHelper.getInstance();
                instace.getMostUsedSaberColorWithRank(args);
            }
                else
            {
                System.out.println("It's get_most_used_saber_color <planet_name> <jedi_rank>(jedi_rank is optional) ");
            }
        }else {System.out.println("OPEN THE FILE FIRST");}
    }
}

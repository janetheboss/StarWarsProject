package com.company.comands;

import Interfaces.Command;
import starWars.Universe;

public class Open implements Command {
    @Override
    public void execute(String[] args) throws Exception {
        if(Universe.getInstance() == null){
            System.out.println("WIP");
        }
    }
}

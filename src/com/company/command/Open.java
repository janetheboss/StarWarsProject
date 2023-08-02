package com.company.command;

import com.company.cli.Command;
import com.company.universe.Universe;

public class Open implements Command {
    @Override
    public void execute(String[] args) throws Exception {
        if(Universe.getInstance() == null){
            System.out.println("WIP");
        }
    }
}

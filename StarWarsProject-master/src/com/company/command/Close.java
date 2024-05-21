package com.company.command;

import com.company.cli.Command;
import com.company.universe.Universe;

public class Close implements Command {
    @Override
    public void execute(String[] args) throws Exception {
        if(Universe.getUniverse_instance() != null){
            Universe.getInstance().close();
        } else {
            System.out.println("NO FILE IS OPENED");
        }
    }
}


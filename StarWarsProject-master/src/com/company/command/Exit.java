package com.company.command;

import com.company.cli.Command;
import com.company.universe.Universe;

public class Exit implements Command {
    @Override
    public void execute(String[] args) {
        if (Universe.getInstance() == null) {
            System.out.println("No file is opened.");
        } else
            if (args.length != 1) {
            System.out.println("The command is exit");
        } else {
            System.out.println("Exiting the app.");
            System.exit(0);
        }
    }
}


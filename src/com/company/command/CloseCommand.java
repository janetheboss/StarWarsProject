package com.company.command;

import com.company.cli.Command;
import com.company.universe.Universe;

public class CloseCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (Universe.getInstance() == null) {
            System.out.println("OPEN THE FILE FIRST");
        } else {
            if (args.length != 0) {
                System.out.println("The command is Close");
            }else
            {
                System.out.println("Successfully closed file.xml");
                Universe.getInstance().setUniverse_instance(null);
            }
        }
    }
}
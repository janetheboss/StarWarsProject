package com.company.command;

import com.company.cli.Command;
import com.company.universe.Universe;

public class Help implements Command {
    @Override
    public void execute(String[] args) {
        if (Universe.getUniverse_instance() == null) {
            System.out.println("No file is open.");
            return;
        }

        if (args.length != 1) {
            System.out.println("The command is Help");
        } else {
            System.out.println("The following commands are supported:"
                    + "\nopen <file> opens <file>"
                    + "\nclose closes currently opened file"
                    + "\nsave saves the currently open file"
                    + "\nsaveas <file> saves the currently open file in <file>"
                    + "\nhelp prints this information"
                    + "\nexit exists the program");
        }
    }
}

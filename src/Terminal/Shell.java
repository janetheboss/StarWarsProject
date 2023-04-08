package Terminal;

import CLI.CommandFactory;
import Interfaces.Command;

import java.util.Scanner;

public class Shell {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome");;
        System.out.println("Input open <file> down below!");
        while(true){
            System.out.print(">");
            String userInput = scanner.nextLine();
            String[] splitedInput = userInput.split("[ ]");
            String commandName = splitedInput[0];
            String[] commandArgs = new String[splitedInput.length-1];
            System.arraycopy(splitedInput,1,commandArgs,0,commandArgs.length);
            Command command = CommandFactory.receiveCommand(commandName);
            if(command!=null) {
                command.execute(commandArgs);
            }
            else {
                System.out.println("Bad command. Try again or use help.");
            }

        }
    }
}

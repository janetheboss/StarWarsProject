package CLI;

import Interfaces.Command;
import com.company.comands.*;

public abstract class CommandFactory {
    public static Command receiveCommand(String command)
    {
            if(command.equalsIgnoreCase("add_planet"))
            {
                return new Add_planet();
            }
         else if(command.equalsIgnoreCase("Close"))
            {
                return new CloseCommand();
            }
            else if(command.equalsIgnoreCase("create_jedi"))
            {
                return new Create_jedi();
            }
            else if(command.equalsIgnoreCase("demote_jedi"))
            {
                return new Demote_jed();
            }
            else if(command.equalsIgnoreCase("Exit"))
            {
                return new Exit();
            }
            else if(command.equalsIgnoreCase("get_strongest_jedi"))
            {
                return new Get_strongest_jedi();
            }
            else if(command.equalsIgnoreCase("get_youngest_jedi "))
            {
                return new Get_youngest_jedi();
            }
            else if(command.equalsIgnoreCase("get_most_used_saber_color"))
            {
                return new GetMostUsedSaberColor();
            }
            else if(command.equalsIgnoreCase("print "))
            {
                return new Print();
            }
            else if(command.equalsIgnoreCase("planet_name")) {
                return new PlanetName();
            }
            else
            {
                return null;
            }
    }
}

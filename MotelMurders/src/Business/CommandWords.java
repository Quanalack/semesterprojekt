package Business;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Contains all the commands 
 * 
 */
public class CommandWords
{
    //Hashmap with all the commands
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor puts all valid commands into validCommands hashmap
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Get a commandword from a string (player input)
     * @param commandWord the player input
     * @return the command from the list or unknown
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Check if a string (player input) is a valid command
     * @param aString player input string
     * @return true if command exists
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    /**
     * Shows all the calid commands
     * @return an arrayList of the valid commands
     */
    public ArrayList<String> showAll() 
    {
        ArrayList<String> commands = new ArrayList<>();
        
        for(String command : validCommands.keySet()) {
            commands.add(command);
        }
        return  commands;
    }
}

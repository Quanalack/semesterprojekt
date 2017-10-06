package motelmurders;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public enum CommandWord
{
    //Predefined enums for commands
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), INVESTIGATE("investigate"), PICKUP("pickup"), TALK("talk"), LOGBOOK("logbook"), DROP("drop");
    
    private String commandString;
    
    //Setter method
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    //getter method
    public String toString()
    {
        return commandString;
    }
}

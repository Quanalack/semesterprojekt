package worldofzuul;

/**
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public enum CommandWord
{
    //Predefined enums
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?");
    
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

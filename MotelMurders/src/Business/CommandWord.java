package Business;

/**
 * Contains all the enum commandwords 
 *
 */
public enum CommandWord
{
    GO("go"),
    QUIT("quit"),
    HELP("help"),
    UNKNOWN("?"),
    INVENTORY("inventory"),
    PICKUP("pickup"),
    DROP("drop"),
    INVESTIGATE("investigate"),
    TALK("talk"),
    USE("use"),
    ACCUSE("accuse"),
    SAVE("save");
    
    
    private String commandString;
    
    /**
     * Set a net commandString
     * @param commandString the new string
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * Override the toString() from object class
     * @return the commandString.
     */
    @Override
    public String toString()
    {
        return commandString;
    }
}

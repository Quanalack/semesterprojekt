package Business;


public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), INVENTORY("inventory"), PICKUP("pickup"), DROP("drop"), INVESTIGATE("investigate"), TALK("talk"), USE("use"), ACCUSE("accuse"), SAVE("save");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}

package Business;

/**
 * The command class represents a command from the player
 * Player types input and a command is generated based by the input
 * through parser
 */
public class Command
{
    private CommandWord commandWord;
    private String secondWord;

    /**
     * The constructor for a command
     * @param commandWord the players first word (The actual command)
     * @param secondWord what to do with the command 
     */
    public Command(CommandWord commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    /**
     * Get the commandword. The actual command
     * @return the commandword
     */
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    /**
     * Get the second word of command
     * @return the second word
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * Check if command is unknown
     * @return true if it is else false.
     */
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    /**
     * Check if a command has two words
     * @return true if a command has two words else returns false
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}


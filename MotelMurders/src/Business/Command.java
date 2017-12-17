package Business;



/**
 * 
 * 
 */
public class Command
{
    private CommandWord commandWord;
    private String secondWord;

    //Constructor, Command
    public Command(CommandWord commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    //Getter
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    //Getter
    public String getSecondWord()
    {
        return secondWord;
    }

    //Return unknown
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    //Return secondword
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}


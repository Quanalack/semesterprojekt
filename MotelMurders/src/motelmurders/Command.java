package motelmurders;

/** 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Command
{
    private CommandWord commandWord;
    private String secondWord;

    //Constructor for command class
    //Creates a command with two words
    public Command(CommandWord commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    //Getter method to get the commandword
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    //Getter metod to get the second word 
    public String getSecondWord()
    {
        return secondWord;
    }

    //Method to return true or false whether the typed commandword exists or not
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    //Method to determine wheter a command has a seconds word. True or false
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}


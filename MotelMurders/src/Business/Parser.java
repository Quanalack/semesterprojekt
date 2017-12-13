package Business;

import java.util.Scanner;
//import java.util.StringTokenizer; <---- Unused library 

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Parser 
{
    private CommandWords commands;
    private Scanner reader;

    /**
     * The constructor of the parser
     * creates the commands and a scanner to read user input
     */
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * Get command from user input and split it into two word.
     * @return a customized command  with the users two words in.
     * The first word is the commandword and the second is what should be done.
     */
    public Command getCommand() 
    {
        //Declare user inputline and the two words.
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        //Read user input
        inputLine = reader.nextLine();

        //Create scanner object from user input
        Scanner tokenizer = new Scanner(inputLine);
        
        //If the scanner object has a next word set the next as word1
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            //If the scanner object has a next word set the next as word2
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }

    /**
     * Shows all the valid commands
     */
    public void showCommands()
    {
        commands.showAll();
    }
}

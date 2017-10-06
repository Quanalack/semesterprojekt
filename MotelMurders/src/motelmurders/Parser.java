package motelmurders;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Parser 
{
    private CommandWords commands;
    private Scanner reader;

    public Parser() //Constructor for parser
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    //Method to get command
    public Command getCommand() 
    {
        String inputLine; // The user inputline
        String word1 = null; //Both string are NULL for now 
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine(); //Reads user input

        Scanner tokenizer = new Scanner(inputLine); //Create a tokenizer with scanner and use the user input as argument
        if(tokenizer.hasNext()) { //if the "tokenizer" meaning the user input has a word
            word1 = tokenizer.next(); //word1 is defined as the first word from the user
            if(tokenizer.hasNext()) { //if the "tokenizer" meaning the user input has another word after the first
                word2 = tokenizer.next(); //Word2 is defined as that word
            }
        }

        return new Command(commands.getCommandWord(word1), word2); // returns the words. Note that if user only types one word it will return (word1, NULL)
    }

    public void showCommands()
    {
        commands.showAll();
    }
}

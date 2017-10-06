package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) //Constructor for Room
    {
        this.description = description; // Room description
        exits = new HashMap<String, Room>(); //Room exits in a hashmap
    }

    //Method for setting exits from one room to another
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    //Method to return the description of a specified room
    public String getShortDescription()
    {
        return description;
    }

    //Method for showing description and exits
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

	//Method for showing all possible exits
	private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet(); // The keySet() returns a set view of the keys contained in the exits hashmap
        for(String exit : keys) { //For loop to run through all the keys in exit. Hence exit : keys
            returnString += " " + exit; //Adds the existing exit to the return string
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}


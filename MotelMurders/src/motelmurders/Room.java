package motelmurders;

import java.util.ArrayList;
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
    ArrayList<Item> items = new ArrayList<Item>(); 

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + getItemString();
    }

	private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
        private String getItemString() {
            String returnString = "\nItems in room:\n";
            returnString += getRoomItems();
            
            return returnString;
        }
                

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    /*
    * Get items from the room
    */
    public Item getItem(int index) {
        return items.get(index);
    }
    public Item getItem(String itemName) {
      //pointing to nothing in memory. Nullpointerexception; cant grab things u havent created
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getDescription().equals(itemName)) {
                return items.get(i);
            }
         
     }
        return null;
    }
     public void removeItem(String itemName) {
      
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getDescription().equals(itemName)) {
                items.remove(i);
            }
        }    
     }
    /*
    * Set a item in the room
    */
    public void setItem(Item newitem) {
        items.add(newitem);
    }
    /*
    * Description of items in room
    */
    public String getRoomItems() {
       String output = "";
        for (int i = 0; i < items.size(); i++) {
            output += items.get(i).getDescription() + "  ";
        }
            return output;
    }




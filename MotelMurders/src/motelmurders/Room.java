package motelmurders;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
// import java.util.Iterator; <---- Unused library 


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room 
{
    private String description;
    private String investigateString;
    private String roomName;
    private HashMap<String, Room> exits;
    ArrayList<Item> items = new ArrayList<Item>();

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Room(String description, String roomName) 
    {
        this.description = description;
        this.roomName = roomName;
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
    
    public String getInvestigateString() {
        return investigateString;
    }

    public void setInvestigateString(String investigateString) {
        this.investigateString = investigateString;
    }

    public String getLongDescription()
    {
        
        return "Current location: " + roomName + "."+ description + ".\n" + getExitString() + getItemString();
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
        
        public String getNeighbors() {
            Game game = new Game();
            String neighbors = "";
           for (String key: exits.keySet()) {
           neighbors += exits.get(key);
        }
           return neighbors;
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
            if (items.get(i).getDescription().equalsIgnoreCase(itemName)) {
                return items.get(i);
            }
         
     }
        return null;
    }
     public void removeItem(String itemName) {
      
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getDescription().equalsIgnoreCase(itemName)) {
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

}




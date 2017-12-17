package Business;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;

/**
 * The room class creates an object representing a room in the game.
 * 
 */
public class Room 
{
    //Room description
    private String description;
    
    //Investigation string
    private String investigateString;
    
    //Name of the room
    private String roomName;
    
    //Rooms exit
    private HashMap<String, Room> exits;
    
    //Items in room
    ArrayList<Item> items = new ArrayList<Item>();

    //Constructor 
    public Room(String description, String roomName) 
    {
        this.description = description;
        this.roomName = roomName;
        exits = new HashMap<String, Room>();
    }
    
    /**
     * 
     * @return the name of the room
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Change the name of a room
     * @param roomName the new room name
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * Set a new exit for another room.
     * @param direction the direction that leads to the other room
     * @param neighbor the room 
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * Get the short description of the room
     * @return the short description of the room
     */
    public String getShortDescription()
    {
        return description;
    }
    
    /**
     * Get the string that comes when the player use the investigate command
     * @return the investigate string
     */
    public String getInvestigateString() {
        return investigateString;
    }

    /**
     * Change the investigate string
     * @param investigateString  the investigate string
     */
    public void setInvestigateString(String investigateString) {
        this.investigateString = investigateString;
    }

    /**
     * Combines room name, description, exits and items in room in one string
     * @return A string with all info of the room
     */
    public String getLongDescription()
    {
        return "\n>Current location: " + 
                roomName + ". " + 
                description + ".\n" + 
                getExitString() + 
                getItemString();
    }
    
    /**
     * Gets exits for room
     * @return String of the possible exits 
     */
	private String getExitString()
    {   
        String returnString = ">Exits:";
        
        //Set of exit keys
        Set<String> keys = exits.keySet();
        
        //Iterate through each exit of room
        for(String exit : keys) {
            returnString += " " + exit;
        }
        
        return returnString;
    }
        
    /**
     * Get all items in a room
     * @return String of all the current items in room
     */    
    private String getItemString() {
        
        String itemsInRoom = "\n\n>Items in room:\n";
        
        for (Item item : items) {
            itemsInRoom += item.itemName + ",  ";
        }
            
        return itemsInRoom;
    }
        
    /**
     * Finds a room from another room and a direction
     * @param direction The direction to go: right, left, back, up
     * @return the room the direction points towards
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * Get an item at specific index
     * @param index What number index the item is
     * @return the item at specified index
     */
    public Item getItem(int index) {
        return items.get(index);
    }
    
    /**
     * Get an item from an itemname
     * @param itemName the name of the item to get
     * @return the item from searched for
     */
    public Item getItem(String itemName) {
      
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            } 
        }
        return null;
    }
    
    /**
     * Removes an item from room
     * @param itemName the item to be removed
     */
    public void removeItem(String itemName) {
      
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).itemName.equalsIgnoreCase(itemName)) {
                items.remove(i);
            }
        }    
     }
    
    /**
     * Set an item into the room
     * @param newitem the item to be placed
     */
    public void setItem(Item newitem) {
        items.add(newitem);
    }
}




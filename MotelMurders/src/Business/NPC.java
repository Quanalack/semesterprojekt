/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author malte
 */
public class NPC implements IPerson{
    
    private String name; //Name of the NPC
    private Room currentRoom; //Current room of the NPC
    private String description; //A short description of the NPC
    private boolean isMurderer; //Whether or not the NPC is the murderer
    
    public NPC(String name, String description, Room startRoom) {
        this.name = name;
        this.description = description;
        this.isMurderer = false;
        this.currentRoom = new Room(startRoom.getLongDescription(), startRoom.getRoomName());
    }
    
    /**
     * Check if this NPC is the murderer
     * @return true if NPC is murderer else false
     */
    public boolean isIsMurderer() {
        return isMurderer;
    }

    /**
     * Set the isIsMurderer to true or false for this NPC
     * @param isMurderer true or false. True if NPC is murderer else false
     */
    public void setIsMurderer(boolean isMurderer) {
        this.isMurderer = isMurderer;
    }
   
    /**
     * Get the name of the NPC
     * @return NPC's name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Move the NPC to another room.
     * @param newRoom the room to be moved to.
     */
    @Override
    public void goRoom(Room newRoom) {
        this.currentRoom = newRoom;
    }

    /**
     * Get the current room of the NPC
     * @return the current room
     */
    @Override
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * Get the description of the NPC
     * @return the description
     */
    @Override
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Set a new descrition for the NPC
     * @param description The new description
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    
}

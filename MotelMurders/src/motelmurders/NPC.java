/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motelmurders;

/**
 *
 * @author malte
 */
public class NPC implements Person{
    
    private String name; //Name of the NPC
    private Room currentRoom; //Current room of the NPC
    private String description; //A short description of the NPC
    private boolean isMurderer; //Whether or not the NPC is the murderer
    
    public NPC( String name, String description, Room startRoom) {
        this.name = name;
        this.description = description;
        this.isMurderer = false;
        this.currentRoom = new Room(startRoom.getLongDescription(), startRoom.getRoomName());
    }
    
    public boolean isIsMurderer() {
        return isMurderer;
    }

    public void setIsMurderer(boolean isMurderer) {
        this.isMurderer = isMurderer;
    }
    
        //Getter
    public String getName() {
        return name;
    }
    
    //Setter
    public void setName(String name) {
        this.name = name;
    }
    

    @Override
    public void goRoom(Room newRoom) {
        this.currentRoom = newRoom;
    }

    @Override
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    @Override
    public String getDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDescription(String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

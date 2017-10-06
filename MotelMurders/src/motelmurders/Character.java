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
public class Character {
    private String name;
    private String description;
    private boolean isMurderer;
    private Room currentRoom;
    
        public Character(String name, String description, Room startRoom) {
                this.name = name;
                this.description = description;
                this.isMurderer = false;
                this.currentRoom = new Room(startRoom.getLongDescription());
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        
        public void goRoom(Room newRoom) {
            this.currentRoom = newRoom;
        }
        
        public Room getCurrentRoom() {
            return this.currentRoom;
        }
        
        public void setIsMurderer(boolean bool) {
            isMurderer = bool;
        }
        
        public boolean getIsMurderer () {
            return isMurderer;
        }
        
    
}

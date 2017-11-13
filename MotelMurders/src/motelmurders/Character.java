/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motelmurders;

import java.util.ArrayList;

/**
 *
 * @author malte
 */

//Class Create characters
public class Character {
    private String name;
    private String description;
    private boolean isMurderer;
    private Room currentRoom;
    
    

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
        
        //Constructer Character: Name, Description, Room
        public Character(String name, String description, Room startRoom) {
                this.name = name;
                this.description = description;
                this.isMurderer = false;    //False by default?????
                this.currentRoom = new Room(startRoom.getLongDescription(), startRoom.getRoomName());
        }

    //Getter
    public String getName() {
        return name;
    }
    
    //Setter
    public void setName(String name) {
        this.name = name;
    }
    
    //Getter
    public String getDescription() {
        return description;
    }

    //Setter
    public void setDescription(String description) {
        this.description = description;
    }
        
        //Movement from one to another, change current room
        public void goRoom(Room newRoom) {
            this.currentRoom = newRoom;
        }
        
        //Getter
        public Room getCurrentRoom() {
            return this.currentRoom;
        }
        
        //Setter
        public void setIsMurderer(boolean bool) {
            isMurderer = bool;
        }
        
        //Getter
        public boolean getIsMurderer () {
            return isMurderer;
        }
        

        
}

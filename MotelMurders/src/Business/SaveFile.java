/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author malte
 */
public class SaveFile {
    
    //The arraylist will hold the characters/NPC's for our game
    ArrayList<Object> NPC = new ArrayList<>();

    //Holds the rooms for the game
    ArrayList<Object> rooms = new ArrayList<>();

    //Holds the main character/player of the game
    Object player;
    
    public SaveFile(ArrayList<Object> NPC, ArrayList<Object> rooms, Object player){
        this.NPC = NPC;
        this.player = player;
        this.rooms = rooms;
        
    }

    public ArrayList<Object> getNPC() {
        return NPC;
    }

    public ArrayList<Object> getRooms() {
        return rooms;
    }

    public Object getPlayer() {
        return player;
    }

    
}

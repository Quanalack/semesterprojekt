/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.ISaveFile;
import java.util.ArrayList;

/**
 *
 * @author malte
 */
public class SaveFile implements ISaveFile{
    
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

    @Override
    public ArrayList<Object> getNPC() {
        return NPC;
    }

    @Override
    public ArrayList<Object> getRooms() {
        return rooms;
    }

    @Override
    public Object getPlayer() {
        return player;
    }

    
}

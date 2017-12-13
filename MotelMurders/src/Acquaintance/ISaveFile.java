/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.ArrayList;

/**
 * ISaveFile interface is for saving and loading the game.
 * Contains method in order to retieve data from the saved file
 * 
 */
public interface ISaveFile {
    /***
     * Gets the NPC from file
     * @return the NPC's
     */
    ArrayList<Object> getNPC();
    
    /**
     * Gets the rooms from file
     * @return the rooms
     */
    ArrayList<Object> getRooms();
    
    /**
     * Get the player
     * @return the player
     */
    Object getPlayer();
    
}

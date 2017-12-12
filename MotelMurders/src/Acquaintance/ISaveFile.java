/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.ArrayList;

/**
 *
 * @author malte
 */
public interface ISaveFile {
    ArrayList<Object> getNPC();
    ArrayList<Object> getRooms();
    Object getPlayer();
    
}

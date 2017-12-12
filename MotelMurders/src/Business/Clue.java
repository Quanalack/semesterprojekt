/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Jeppe
 */
public class Clue extends Item {
    
    boolean pickupAble = true;

    public Clue(String description, String roomName, boolean pickupAble) {
        super(description, roomName, pickupAble);
    }
    
    
    public Clue(String newdescription) {
        super(newdescription);
    }

    
    
    
}

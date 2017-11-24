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
public interface IPerson {
    
    public void goRoom(Room newRoom); //Change currentRoom
    
    public Room getCurrentRoom(); //Get the currentRoom
    
    public String getName(); //Get the name of a character
    
    public String getDescription();
    
    public void setDescription(String description);
    
    
}

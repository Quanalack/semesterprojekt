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
public interface Person {
    
    public void goRoom(Room newRoom);
    
    public Room getCurrentRoom();
    
    public String getName();
    
    public void setName(String name);
    
    public String getDescription();
    
    public void setDescription(String description);
    
    
}

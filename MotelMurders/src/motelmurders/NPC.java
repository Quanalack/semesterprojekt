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
public class NPC extends Character{
    
    private String name;
    
        //Getter
    public String getName() {
        return name;
    }
    
    //Setter
    public void setName(String name) {
        this.name = name;
    }
    
    public NPC(String name, String description, Room startRoom) {
        super(name, description, startRoom);
    }
    
}

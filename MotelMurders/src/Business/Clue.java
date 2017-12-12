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
    
    
    public Clue(String description, String itemName, boolean pickupAble) {
        super(description, itemName, pickupAble = true);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public boolean isPickupAble() {
        return pickupAble;
    }

    @Override
    public void setPickupAble(boolean pickupAble) {
        this.pickupAble = pickupAble;
    }
    
    

    
    
    
}

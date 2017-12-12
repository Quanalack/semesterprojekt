package Business;

import java.util.ArrayList;

public class Item {
    
    //For items 
    String description;
    String itemName;
    boolean pickupAble;
    
    public String getItemName() {
        return this.itemName;
        //passing back this string when i need an item for it
    }
    
    public Item(String description, String itemName, boolean pickupAble) {
        this.description = description;
        this.itemName = itemName;   
        this.pickupAble = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPickupAble() {
        return pickupAble;
    }

    public void setPickupAble(boolean pickupAble) {
        this.pickupAble = pickupAble;
    }

   
    
    
}

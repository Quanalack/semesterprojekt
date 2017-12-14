package Business;

import java.util.ArrayList;

public class Item {
    
    //For items 
    String itemName;
    boolean pickupAble;
    
    public String getItemName() {
        return this.itemName;
        //passing back this string when i need an item for it
    }
    
    public Item(String itemName, boolean pickupAble) {
        this.itemName = itemName;   
        this.pickupAble = false;
    }


    public boolean isPickupAble() {
        return pickupAble;
    }

    public void setPickupAble(boolean pickupAble) {
        this.pickupAble = pickupAble;
    }

   
    
    
}

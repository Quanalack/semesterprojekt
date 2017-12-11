package Business;

import java.util.ArrayList;

public class Item {
    
    //For items 
    String description;
    String itemName;
    boolean pickupAble;
    
    public Item(String newDescription) { //constructor
        this.description = newDescription;
    }
           
    public String getItemName() {
        return this.itemName;
        //passing back this string when i need an item for it
    }
    
    public Item(String description, String itemName, boolean pickupAble) {
        this.description = description;
        this.itemName = itemName;   
        this.pickupAble = pickupAble;
    }

    boolean pickupAble(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

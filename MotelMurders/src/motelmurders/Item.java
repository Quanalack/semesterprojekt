
package motelmurders;

class Item {
    
    private String description;
    
    public Item(String newdescription) { //constructor
        description = newdescription;
        
    }
    
    public String getDescription() {
        return description;
        //passing back this string when i need a item for it
    }
    
}

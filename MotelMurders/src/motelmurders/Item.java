
package motelmurders;

class Item {
    
    private String description;
    
    public Item(String newdescription) { //constructor
        this.description = newdescription;
        
    }
    
    public String getDescription() {
        return this.description;
        //passing back this string when i need a item for it
    }
    
}
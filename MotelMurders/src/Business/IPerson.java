
package Business;

/**
 * Interface in order to implement methods relevant 
 * for the characters in the game
 */
public interface IPerson {
    
    public void goRoom(Room newRoom); //Change currentRoom
    
    public Room getCurrentRoom(); //Get the currentRoom
    
    public String getName(); //Get the name of a character
    
    public String getDescription(); //Get the character description
    
    public void setDescription(String description); //set the character description
    
    
}

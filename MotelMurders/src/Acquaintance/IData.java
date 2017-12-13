package Acquaintance;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
Interface for data layer. Contains the methods implemented in 
 * dataFacade in order to use in business layer.
 */
public interface IData {
	
    /**
     * Saves the current state of: The NPC's, the rooms and the player
     * @param characters The NPC's
     * @param rooms The rooms
     * @param player The player
     */
    void saveGame(ArrayList<Object> characters, ArrayList<Object> rooms, Object player);
        
    /**
     * Loads a saved game
     * @return a saveFile with an ISaveFile interface
     */    
    ISaveFile loadGame();
    
    /**
     * Get the highscore as linkedList of IScore
     * @return the linkedList of highscores
     */
    LinkedList<IScore> getHighscore();
    void saveHighscore(double seconds, String playerName);
        
}

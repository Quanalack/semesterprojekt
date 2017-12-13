package Acquaintance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Interface for business layer. Contains the methods implemented in 
 * businessFacade in order to use in presentation layer.
 * 
 */

public interface IBusiness {
        /**
         * Injects the data layer into the business layer
         * @param dataLayer The data layer
         */
	void injectData(IData dataLayer);
        
        /**
         * Gets players current room
         * @return players current room as object
         */
        Object getCurrentRoom();
        
        /**
         * Get the message that welcomes the player to the game.
         * @return the welcome message
         */
        ArrayList<String> getWelcomeMessage();
        
        /**
         * Get the highscore
         * @return the highscore as an IScore interface
         */
        LinkedList<IScore> getHighscore();
        
        /**
         * Save highscore
         */
        void saveHighscore();
        
        /**
         * Saves current state of the game
         */
        void saveGame();
        
        /**
         * Loads a saved game
         */
        void loadGame();

}

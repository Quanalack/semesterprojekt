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
         * 
         * @return 
         */
        LinkedList<Object> getHighscore();
        
        /**
         * 
         */
        void saveHighscore();
        
        /**
         * 
         */
        void saveGame();
        
        /**
         * 
         */
        void loadGame();

}

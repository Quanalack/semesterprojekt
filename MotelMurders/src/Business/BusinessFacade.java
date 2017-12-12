package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;


public class BusinessFacade implements IBusiness {
	private IData data;
        private Game game = new Game();

    /**
     * Injects the datalayer into the business layer
     * @param dataLayer The data layer
     */    
    @Override
    public void injectData(IData dataLayer) {
    	this.data = dataLayer;
    }
        
    /**
     * Get the highscore from the data layer
     * @return the highscore in a linked list of Scores
     */
    @Override
    public LinkedList<Object> getHighscore() {
        
        return data.getHighscore();
    }

    /**
     * Process the player command from GUI
     * @param command the players command from GUI
     */
    @Override
    public void processCommand(Object command) {
        
        game.processCommand((Command)command);
    }

    /**
     * Get the current room of the player
     * @return the current room as an object
     */
    @Override
    public Object getCurrentRoom() {
        return game.player.getCurrentRoom();
    }

    /**
     * Get the welcome message to display when the game starts
     * @return an arraylist of the message.
     */
    @Override
    public ArrayList<String> getWelcomeMessage() {
        return game.getWelcomeMessage();
    }

    /**
     * Saves the highscore by calling the saveHighscore method from data layer
     */
    @Override
    public void saveHighscore() {
        
        //Calculate time left from elapsedTime and max time
        double timePlayed = game.getCurrentTime() - game.MAXTIME;
        
        data.saveHighscore(timePlayed, game.player.getName());
    }    

    @Override
    public void saveGame() {
        
        ArrayList characters = game.characters;
        ArrayList rooms = game.rooms;
        Object player = game.player;
        
        data.saveGame(characters, rooms, player);
    }

    @Override
    public void loadGame() {
        
    }
}

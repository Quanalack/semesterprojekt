package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import Acquaintance.ISaveFile;
import Acquaintance.IScore;
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
    public LinkedList<IScore> getHighscore() {
        
        return data.getHighscore();
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

    /**
     * Converts characters and rooms to arraylist of object
     * Converts player to an object and then calls saveGame from data layer
     */
    @Override
    public void saveGame() {
        
        ArrayList characters = game.characters;
        ArrayList rooms = game.rooms;
        Object player = game.player;
        
        data.saveGame(characters, rooms, player);
    }

    /**
     * Gets a saveFile via loadGame from data layer
     * Cast character and room array from object to NPC and Room.
     * Casts player as maincharacter
     */
    @Override
    public void loadGame() {
        ISaveFile saveFile = data.loadGame();
        
        ArrayList charactersObject = saveFile.getNPC();
        ArrayList roomsObject = saveFile.getRooms();
        
        ArrayList<NPC> characters = new ArrayList<>();
        ArrayList<Room> rooms = new ArrayList<>();
        
        //Cast from object to NPC
        for(Object character: charactersObject) {
            characters.add((NPC)character);
        }
        
        //Cast from object to room
        for (Object room : roomsObject) {
            rooms.add((Room)room);
        }
        
        //Change variables
        game.rooms = rooms;
        game.characters =  characters;
        game.player = (MainCharacter)saveFile.getPlayer();
    }

}

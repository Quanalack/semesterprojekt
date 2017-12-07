package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import java.util.ArrayList;
import java.util.Collection;


public class BusinessFacade implements IBusiness {
	private IData data;
        private Game game = new Game();

	@Override
	public void injectData(IData dataLayer) {
		this.data = dataLayer;
	}
        
        //The actual methods 

    @Override
    public ArrayList<Object> getHighscore() {
        return data.getHighscore();
    }

    @Override
    public void saveHighscore() {
        //Calculate time played out of max time
        double timePlayed = game.getCurrentTime() - game.MAXTIME;
        
        data.saveHighscore(timePlayed, game.player.getName());
    }

    @Override
    public void processCommand(Object command) {
        
        game.processCommand((Command)command);
    }

    @Override
    public Object getCurrentRoom() {
        return game.player.getCurrentRoom();
    }

    @Override
    public ArrayList<String> getWelcomeMessage() {
        return game.getWelcomeMessage();
    }
    
    

    
    
        
        
}

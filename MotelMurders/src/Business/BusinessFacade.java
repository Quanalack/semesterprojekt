package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import java.util.ArrayList;
import java.util.Arrays;
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
        
        ArrayList<Object> scores = data.getHighscore();  
        ArrayList<Score> scoresCasted = new ArrayList<>();
        
        //Copy the content of arrayList<Object> to arrayList<Score> and casts as a Score
        for (int i = 0; i < scores.size(); i++) {
            Score score = (Score)scores.get(i);
            scoresCasted.add(score);
        }
        Score score = new Score();
        
        
        
        
        
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

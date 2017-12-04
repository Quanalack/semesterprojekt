package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
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
    public Collection<?> getHighscore() {
        return data.getHighscore();
    }

    @Override
    public void saveHighscore() {
        //Calculate time played out of max time
        double timePlayed = game.getCurrentTime() - game.MAXTIME;
        
        data.SaveHighscore(timePlayed, game.player.getName());
    }

    @Override
    public void processCommand(Object command) {
        
        game.processCommand((Command)command);
    }
        
        
}

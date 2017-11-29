package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import java.util.Collection;
import java.util.HashSet;


public class BusinessFacade implements IBusiness {
	private IData data;
        private Game game = new Game();

	@Override
	public void injectData(IData dataLayer) {
		this.data = dataLayer;
	}
        
        //The actual methods 

    @Override
    public Object getHighscore() {
        return data.LoadHighscore();
    }

    @Override
    public void startGameText() {
        Game game = new Game();
        game.play();
    }

    @Override
    public void saveHighscore() {
        
        data.SaveHighscore(game.getCurrentTime(), game.player.getName(), game.MAXTIME);
    }

    @Override
    public void processCommand(Object command) {
        
        game.processCommand((Command)command);
    }
        
        
}

package Business;

import Acq.IBusiness;
import Acq.IData;
import java.util.Collection;
import java.util.HashSet;


public class BusinessFacade implements IBusiness {
	private IData data;

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
        
        
}

package Acq;

import java.util.Collection;

public interface IData {
    
    //Methods for data highscore - Make methods as abstract/generalized as possible f.eks. Collection instead of arraylist
	Object LoadHighscore();
        Boolean SaveHighscore(int seconds, String playerName, int MAXTIME);
        Boolean SaveGame(Object[] game);
        Collection<Object>LoadGame();
        
}
package Acquaintance;

import java.util.Collection;

public interface IData {
    
    //Methods for data highscore - Make methods as abstract/generalized as possible f.eks. Collection instead of arraylist
	Collection[] getHighscore();
        void SaveHighscore(double seconds, String playerName, int MAXTIME);
        void SaveGame(Object[] game);
        Collection<Object>LoadGame();
        
}

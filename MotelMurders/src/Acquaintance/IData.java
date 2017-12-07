package Acquaintance;

import java.util.ArrayList;
import java.util.Collection;

public interface IData {
    
    //Methods for data highscore - Make methods as abstract/generalized as possible f.eks. Collection instead of arraylist
	ArrayList<Object> getHighscore();
        void saveHighscore(double seconds, String playerName);
        void saveGame(ArrayList<Object> NPC, ArrayList<Object> rooms, Object player);
        Object loadGame();
        
}

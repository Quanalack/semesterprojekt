package Acquaintance;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public interface IData {
    
    //Methods for data highscore - Make methods as abstract/generalized as possible f.eks. Collection instead of arraylist
	
        void saveGame(ArrayList<Object> characters, ArrayList<Object> rooms, Object player);
        Object loadGame();
        LinkedList<Object> getHighscore();
        void saveHighscore(double seconds, String playerName);
        
}

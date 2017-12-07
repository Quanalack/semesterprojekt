package Acquaintance;

import java.util.ArrayList;
import java.util.Collection;

public interface IBusiness {
        //Method to inject the data layer into business layer
	void injectData(IData dataLayer);
	
        //Methods for our business layer. Make methods as abstract/generalized as possible f.eks. Collection instead of arraylist
        ArrayList<Object> getHighscore(); //Get highscore from business to presentation
        void saveHighscore();
        void processCommand(Object command);
        Object getCurrentRoom();
        ArrayList<String> getWelcomeMessage();
        
}

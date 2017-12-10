package Acquaintance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public interface IBusiness {
        //Method to inject the data layer into business layer
	void injectData(IData dataLayer);
        void processCommand(Object command);
        Object getCurrentRoom();
        ArrayList<String> getWelcomeMessage();
        LinkedList<Object> getHighscore();
        void saveHighscore();
        
}

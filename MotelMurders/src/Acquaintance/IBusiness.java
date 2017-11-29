package Acquaintance;

import java.util.Collection;

public interface IBusiness {
        //Method to inject the data layer into business layer
	void injectData(IData dataLayer);
	
        //Methods for our business layer. Make methods as abstract/generalized as possible f.eks. Collection instead of arraylist
        public Object getHighscore(); //Get highscore from business to 
        public void saveHighscore();
        public void processCommand(Object command); // <---- Fix dis plzz
        
}

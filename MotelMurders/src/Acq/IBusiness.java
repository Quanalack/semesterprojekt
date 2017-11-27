package Acq;

import java.util.Collection;

public interface IBusiness {
	void injectData(IData dataLayer);
	
        //Methods for our business layer. Make methods as abstract/generalized as possible f.eks. Collection instead of arraylist
        public Object getHighscore();
        public void startGameText();
}

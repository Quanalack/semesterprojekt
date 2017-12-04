package Acquaintance;

import java.util.Collection;

public interface IUI {
	void injectBusiness(IBusiness businessLayer);
        void startApplication(String[] args);
        Collection<?> getHighscore();
        
        
}

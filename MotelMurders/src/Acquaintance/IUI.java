package Acquaintance;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Interface for the methods in UI
 * 
 */
public interface IUI {
    /**
     * Inects the business layer into the UI
     * @param businessLayer the businessLayer
     */
    void injectBusiness(IBusiness businessLayer);
    
    /**
     * Starts the application
     * @param args command line arguments
     */
    void startApplication(String[] args);
        
        
}

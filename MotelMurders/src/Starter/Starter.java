/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import Acquaintance.IUI;
import Business.BusinessFacade;
import Data.DataFacade;
import Presentation.UI;

/**
 *
 * @author madsd
 */
public class Starter{
    
    public static void main(String[] args) {
        //Create instance of data interface
        IData data = new DataFacade();
        
        //Create instance of business interface
        IBusiness business = new BusinessFacade();
        
        //Inject the data layer into the business layer
        business.injectData(data);
        System.out.println("Data injected");
        
        //Create the presentation layer
        IUI ui = new UI();
        
        //Inject the business layer into the presentation layer
        //ui.injectBusiness(business);
        System.out.println("Business injected");

        //Print to user 
        System.out.println("Ready to launch");
        
        //Start application throught the presentation layer   
        
        ui.startApplication(args);
        
    }
}

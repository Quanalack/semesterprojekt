/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acquaintance.IBusiness;
import Acquaintance.IUI;
import java.util.ArrayList;
import java.util.Collection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class UI extends Application implements IUI{
    
    private static UI ui;
    
    private IBusiness business;
    
    /**
     * Get the UI
     * @return an instance of the UI
     */
    public static UI getInstance(){
        return ui;
    }
    
    /**
     * Starts the application. @override from Application
     * @param primaryStage the starting stage
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Injects the business layer into the UI
     * @param businessLayer the business layer
     */
    @Override
    public void injectBusiness(IBusiness businessLayer) {
        business = businessLayer;
    }

    /**
     * Starts the game
     * @param args 
     */
    @Override
    public void startApplication(String[] args) {
        System.out.println("Is in UI startApplication");
        ui = this;
        launch(args);
    }
    
}

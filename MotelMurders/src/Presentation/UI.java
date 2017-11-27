/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Acq.IBusiness;
import Acq.IUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author madsd
 */
public class UI extends Application implements IUI{
    
    private static UI ui;
    
    public static UI getInstance(){
        return ui;
    }
    
    private IBusiness business;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void injectBusiness(IBusiness businessLayer) {
        business = businessLayer;
    }

    @Override
    public void startApplication(String[] args) {
        System.out.println("Is in UI startApplication");
        ui = this;
        launch(args);
    }
    
    public IBusiness getBusiness(){
        return business;
    }
    
}

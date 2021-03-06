package Presentation;

import Acquaintance.IBusiness;
import Acquaintance.IScore;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {

    private IBusiness business;
    
    @FXML
    private TextField textField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void injectBusiness(IBusiness business) {
        this.business = business;
    }
    
    @FXML
    private void usernameButtonAction(ActionEvent event) {
        //textField.setText("username");
        textField.setText("");
    }

    @FXML
    private void amountButtonAction(ActionEvent event) {
        //textField.setText("amount");
        
        LinkedList<IScore> IScores = business.getHighscore();
        
        textField.setText(IScores.get(0).getDate().toString());
        
        System.out.println("get Highscore");
        
    }

    @FXML
    private void averagePriceAction(ActionEvent event) {
       
    }

}

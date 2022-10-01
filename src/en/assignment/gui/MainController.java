package en.assignment.gui;

import dk.javahandson.User;
import es.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TableView<?> resultTable;
    @FXML
    private TextField full_name;
    @FXML
    private Button proceed;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        proceed.setOnAction(event ->
                Utils.changeScene(event,
                        "/Questionaire.fxml",full_name.getText(),0));
    }

   // public void setScore(Integer score){
//        test.setText(String.valueOf(score));
//    }

    public void getUser(User u) {

        if(!u.isListed()){
            // add for another row

        }else {
            // count score up
        }
    }
}

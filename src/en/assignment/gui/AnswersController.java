package en.assignment.gui;

import dk.javahandson.User;
import es.utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AnswersController implements Initializable {

    @FXML
    private Label score_final;
    @FXML
    private Label full_name;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prepareData();
    }

    @FXML
    public void setUser(String name){
        full_name.setText(name);
    }

    private void prepareData(){
        User fetchedUser = Utils.fetchUserByName("kondom");

//        if (fetchedUser != null){
//            // display answers in labels
//        }
    }
}

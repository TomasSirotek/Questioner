package en.assignment.gui;

import es.utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class QuestController implements Initializable {
    @FXML
    private Button calculate;
    @FXML
    private Label score_final;
    @FXML
    private Label full_name;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calculate.setOnAction(event ->
                Utils.calculateScore());
    }
    @FXML
    public void setUser(String name){
        full_name.setText(name);
    }

    @FXML
    public void setScore(Integer score){
       score_final.setText(String.valueOf(score));
    }

}

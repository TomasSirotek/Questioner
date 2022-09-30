package en.assignment.gui;

import es.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TextField full_name;
    @FXML
    private Button proceed;
    @FXML
    private Label lbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        proceed.setOnAction(event ->
                Utils.changeScene(event,
                        "/Questionaire.fxml",full_name.getText()));
    }

}

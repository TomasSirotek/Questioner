package en.assignment.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class QuestController {
    public Label full_name;

    @FXML
    public void setUser(String name){
       full_name.setText(name);
    }
}

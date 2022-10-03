package en.assignment.gui;

import dk.javahandson.User;
import es.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AnswersController implements Initializable {
    @FXML
    private GridPane gridPane;
    @FXML
    private Label score_final;
    @FXML
    private Label full_name;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void setUser(String name) {
        full_name.setText(name);
        prepareData();
    }

    private void prepareData() {
        String[] strArray = {"Delhi", "Mumbai", "Kolkata", "Chennai", "Delhi", "Nether", "Bitcoin"};
        List<String> arrayList = new ArrayList<>(Arrays.asList(strArray));

        User fetchedUser = Utils.fetchUserByName(full_name.getText());

        if (fetchedUser != null) {
            // display answers in labels
            int position = 0;
            for (int i = 9; i < 16; i++) {
                Node nodeOut = gridPane.getChildren().get(i);
                if (nodeOut instanceof HBox) {
                    for (Node nodeIn : ((HBox) nodeOut).getChildren()) {
                        if (nodeIn instanceof VBox) {
                            for (Node label : ((VBox) nodeIn).getChildren()) {
                                if (label instanceof Label) {
                                    ((Label) label).setText(arrayList.get(position));
                                    position++;
                                }
                            }

                        }
                    }
                }
            }
        }

    }
}

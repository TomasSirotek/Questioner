package en.assignment.gui;

import dk.javahandson.Question;
import dk.javahandson.User;
import es.utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
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
        User fetchedUser = Utils.fetchUserByName(full_name.getText());

        if (fetchedUser != null) {
            List<Question> arrayList = fetchedUser.getQuestionList();
            score_final.setText(String.valueOf((fetchedUser.getTotal())));
            // display answers in labels for each node starting from 9
            int position = 0;
            for (int i = 9; i < 16; i++) {
                Node nodeOut = gridPane.getChildren().get(i);
                if (nodeOut instanceof HBox) {
                    for (Node nodeIn : ((HBox) nodeOut).getChildren()) {
                        if (nodeIn instanceof VBox) {
                            for (Node label : ((VBox) nodeIn).getChildren()) {
                                if (label instanceof Label) {
                                    ((Label) label).setText(arrayList.get(position).getAnswer());
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

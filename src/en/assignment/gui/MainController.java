package en.assignment.gui;

import dk.javahandson.User;
import es.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TableColumn<User, String> id;
    @FXML
    private TableColumn<User,String> name;
    @FXML
    private TableColumn<User,Double> time;
    @FXML
    private TableColumn<User,Integer> total;
    @FXML
    private TableView<User> resultTable;

    @FXML
    private TextField full_name;
    @FXML
    private Button proceed;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fetchData();
        proceed.setOnAction(event ->
                Utils.changeScene(event,
                        "/Questionaire.fxml",full_name.getText()));
    }

    private void fetchData() {
        ObservableList<User> obsUsersList = FXCollections.observableArrayList();
        List<User> fetchedUsers = Utils.fetchData();

        if(fetchedUsers != null) {
            for (User u : fetchedUsers
            ) {
                obsUsersList.add(u);
                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                name.setCellValueFactory(new PropertyValueFactory<>("name"));
                total.setCellValueFactory(new PropertyValueFactory<>("total"));
                time.setCellValueFactory(new PropertyValueFactory<>("time"));
            }
            resultTable.setItems(obsUsersList);
        }
    }
}

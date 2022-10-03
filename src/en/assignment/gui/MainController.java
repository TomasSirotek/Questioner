package en.assignment.gui;

import dk.javahandson.User;
import es.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TableColumn<User, String> id;
    @FXML
    private TableColumn<User,String> name;
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
        handleClick();

        proceed.setOnAction(event ->
                Utils.changeScene(event,
                        "/Questionaire.fxml",full_name.getText()));
    }

    private void handleClick() {
        resultTable.setRowFactory(new Callback<TableView<User>, TableRow<User>>()
        {
            @Override
            public TableRow<User> call(TableView<User> param)
            {
                TableRow<User> row = new TableRow<User>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event)
                    {
                        if (event.getClickCount() == 2 && (! row.isEmpty()) )
                        {
                            System.out.println(row.getIndex());
                            User serialData = row.getItem();
                            System.out.println(serialData.getName());
                        }
                    }
                });
                return row;
            }
        });
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
            }
            resultTable.setItems(obsUsersList);
        }
    }


}

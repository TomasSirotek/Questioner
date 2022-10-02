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
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public TableColumn<User, String> id;
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

    private final ObservableList<User> usersList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        proceed.setOnAction(event ->
                Utils.changeScene(event,
                        "/Questionaire.fxml",new User(1,full_name.getText(),0,0,false)));
    }

   // public void setScore(Integer score){
//        test.setText(String.valueOf(score));
//    }
   @FXML
    public void getUser(User u) {

        usersList.add(u);

        id.setCellValueFactory(new PropertyValueFactory<User,String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
        total.setCellValueFactory(new PropertyValueFactory<User,Integer>("total"));
        time.setCellValueFactory(new PropertyValueFactory<User,Double>("time"));

       for (User us: usersList
            ) {
           if(u.getName() == us.getName()){
               // add for another row
               System.out.print("Exists");
           }else {
               // count score up
               resultTable.setItems(usersList);
           }
       }
    }

}

package es.utils;

import dk.javahandson.Question;
import dk.javahandson.User;
import en.assignment.gui.MainController;
import en.assignment.gui.QuestController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Utils {

    public static void changeScene(ActionEvent event, String fxmlFile,User user){
        Parent root = null;

        if(user.getName() != null){
            try {
                FXMLLoader loader = new FXMLLoader(Utils.class.getResource(fxmlFile));
                root = loader.load();
                QuestController pc = loader.getController();
                pc.setUser(user);
            }catch(IOException e){
                e.printStackTrace();
            }

        } else {
            try{
                root = FXMLLoader.load(Objects.requireNonNull(Utils.class.getResource(fxmlFile)));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Welcome to questioner " + user.getName());
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }



}

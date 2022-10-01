package en.assignment.gui;

import dk.javahandson.Main;
import dk.javahandson.Question;
import dk.javahandson.User;
import es.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class QuestController implements Initializable {

    @FXML
    private Button save;
    @FXML
    private ToggleGroup first_question,
                        second_question,
                        third_question,
                        forth_question,
                        fifth_question,
                        sixth_question,
                        seventh_question;
    @FXML
    private Button calculate;
    @FXML
    private Label score_final;
    @FXML
    private Label full_name;
    @FXML
    private GridPane gridPane;

    private MainController controller;

    private int score = 0;

    private final List<String> resultFromQuestions = new ArrayList<>();
    private final List<Question> resultList= new ArrayList<>();

    private final List<User> userList= new ArrayList<>();

    private User user;
    // agree = +1, neutral = 0, disagree= -1.

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //  calculate.setOnAction(event
        calculate.setOnAction(this::setTextButton);
        //save.setOnAction(event -> saveData(event,score,full_name.getText()));
        save.setOnAction(event -> Utils.changeScene(event,"/MainWindow.fxml",user));
    }

    private void saveData(ActionEvent event,int score,String name) {


        ObservableList<User> usersList = FXCollections.observableArrayList();
        int id = 0;
        boolean existInList = false;

        User us = new User(id,name,score,3.3,true);
//        userList.add(us);
//
//        for (int i = 0; i < usersList.size(); i++) {
//            if(userList.size() != 0){
//                    id++;
//                    User r = new User(id,name,score,3.3,true);
//                    userList.add(r);
//            } else {
//
//            }
//        }





//        Parent root = null;
//        if(name != null){
//            try {
//                FXMLLoader loader = new FXMLLoader(Utils.class.getResource("/MainWindow.fxml"));
//                root = loader.load();
//                MainController pc = loader.getController();
//                pc.getUser(us);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } else {
//            try{
//                root = FXMLLoader.load(Objects.requireNonNull(Utils.class.getResource("/MainWindow.fxml")));
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setTitle("Welcome back " + name);
//        stage.setScene(new Scene(root));
//        stage.setResizable(false);
//        stage.show();

       //  w.returnUser(u,name);

//        Node node = (Node) event.getSource();
//        Stage stage = (Stage)node.getScene().getWindow();
//        stage.close();
    }

    enum State {
        AGREE,
        NEUTRAL,
        DISAGREE;
    }
    @FXML
    public void setUser(User user) {
        full_name.setText(user.getName());
    }

    @FXML
    public void setTextButton(ActionEvent e) {
        restart();
        getScore();
        save.setDisable(false);
    }

    @FXML
    private void restart(){
        score=0;
        resultFromQuestions.clear();
        resultList.clear();
    }
    @FXML
    private void getScore(){
        String[] resultGroup1 = first_question.getSelectedToggle().toString().split("'");
        String[] resultGroup2 = second_question.getSelectedToggle().toString().split("'");
        String[] resultGroup3 = third_question.getSelectedToggle().toString().split("'");
        String[] resultGroup4 = forth_question.getSelectedToggle().toString().split("'");
        String[] resultGroup5 = fifth_question.getSelectedToggle().toString().split("'");
        String[] resultGroup6 = sixth_question.getSelectedToggle().toString().split("'");
        String[] resultGroup7 = seventh_question.getSelectedToggle().toString().split("'");

        resultFromQuestions.add(resultGroup1[1]);
        resultFromQuestions.add(resultGroup2[1]);
        resultFromQuestions.add(resultGroup3[1]);
        resultFromQuestions.add(resultGroup4[1]);
        resultFromQuestions.add(resultGroup5[1]);
        resultFromQuestions.add(resultGroup6[1]);
        resultFromQuestions.add(resultGroup7[1]);

        for (int i = 0; i < resultFromQuestions.size(); i++) {
            switch (resultFromQuestions.get(i)) {
                case "Disagree" -> {
                    score -= 1;
                    resultList.add(new Question(i + 1, "Disagree", full_name.getText()));
                }
                case "Neutral" -> {
                    score += 0;
                    resultList.add(new Question(i + 1, "Neutral", full_name.getText()));
                }
                case "Agree" -> {
                    score += 1;
                    resultList.add(new Question(i + 1, "Agree", full_name.getText()));
                }
                default -> {
                }
            }

        }
        score_final.setText(String.valueOf(score));
    }

}

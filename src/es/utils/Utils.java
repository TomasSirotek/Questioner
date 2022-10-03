package es.utils;

import dk.javahandson.Question;
import dk.javahandson.User;
import en.assignment.gui.QuestController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utils {

    public static void changeScene(ActionEvent event, String fxmlFile,String name){
        Parent root = null;

        if(name != null){
            try {
                FXMLLoader loader = new FXMLLoader(Utils.class.getResource(fxmlFile));
                root = loader.load();
                QuestController pc = loader.getController();
                pc.setName(name);
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
        stage.setTitle("Welcome to questioner");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    public static List<User> fetchData(){
        List<User> userList = new ArrayList<>();
        try (Connection con = DbConnection.getConnection()){
            String sql = "SELECT * FROM user ORDER BY total DESC";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int total = rs.getInt("total");
                User u = new User(id, name, total);
                userList.add(u);
            }
            return userList;
        } catch (
                SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public static User fetchUserByName(String name){

        try (Connection con = DbConnection.getConnection()){
            String sql = "SELECT * FROM user as u WHERE u.name=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                String fetchedName = rs.getString("name");
                int total = rs.getInt("total");

                return new User(id,fetchedName,total);
            }

        } catch (
                SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public static void saveData(ActionEvent event, User user) {
        List<User> fetchedUser = fetchData();
        boolean isListed = false;

        assert fetchedUser != null;
        for (User u : fetchedUser
             ) {
            if(Objects.equals(u.getName(), user.getName())){
               isListed = true;
            } else {
                isListed = false;
            }
        }

        if(!isListed){
            try(Connection con = DbConnection.getConnection()){
                String sql = "INSERT INTO user (id,name,total) VALUES (?,?,?);";
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                preparedStatement.setInt(1, user.getId());
                preparedStatement.setString(2,user.getName());
                preparedStatement.setInt(3,user.getTotal());
                preparedStatement.executeUpdate();

                User createdUser = fetchUserByName(user.getName());

                if(!user.getQuestionList().isEmpty() || createdUser != null){
                    for (Question q : user.getQuestionList()
                         ) {
                        String qSql = "INSERT INTO question (id,user_id,question,answer) VALUES (?,?,?,?);";
                        PreparedStatement qPreparedStatement = con.prepareStatement(qSql);

                        qPreparedStatement.setInt(1, q.getId() + 1);
                        qPreparedStatement.setInt(2, createdUser.getId());
                        qPreparedStatement.setString(3,q.getQuestion());
                        qPreparedStatement.setString(4,q.getAnswer());
                        qPreparedStatement.executeUpdate();
                    }
                }

                changeScene(event,"/MainWindow.fxml",null);
            }  catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }else {
            updateData(event, user.getName(), user.getTotal());
        }

    }
    public static void updateData(ActionEvent e,String name,int score) {
        try(Connection con = DbConnection.getConnection()){
            String sql = "UPDATE user SET total = ? where name = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1, score);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();

            changeScene(e,"/MainWindow.fxml",null);
        }  catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void fetchQuestionData(String name) {


    }
}

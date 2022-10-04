package en.assignment.gui;

import dk.javahandson.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class GraphController implements Initializable {
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private LineChart<String,Integer> graph;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setData();
    }

    public void setData() {
//        x.setLabel("Questions");
//        y.setLabel("Avg");

        // avarage answer to that question
        // I love working with java =
        graph.setTitle("Graph stats");

        String[] hardCodedQuestion = { "I love working with Java","Test question 1","Test question 2","Test question 3"};
        List<String> wordList = Arrays.asList(hardCodedQuestion);
        int[] avgPoint = {1,2,3,4,5,6};

        ObservableList<XYChart.Series<String,Integer>> sl = FXCollections.observableArrayList();
        XYChart.Series<String, Integer> sr = new XYChart.Series<>();

        for (int i = 0; i < wordList.size(); i++) {
            sr.getData().add((new XYChart.Data<>( wordList.get(i), i)));
        }
        

        // Create dataset for  males and add it to the series
//        ObservableList<XYChart.Data<String,Integer>> l1 = FXCollections.observableArrayList(
//                new XYChart.Data<>("Question1",0),
//                new XYChart.Data<>("Question2",20),
//                new XYChart.Data<>("Question3",50),
//                new XYChart.Data<>("Question4",60)
//                );
//
//        sl.add(new XYChart.Series<>("Question", l1));

        graph.getData().add(sr);
    }
}

package en.assignment.gui;

import es.utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.net.URL;
import java.util.*;

public class GraphController implements Initializable {
    @FXML
    private LineChart<String,Double> graph;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setData();
    }

    public void setData() {
        graph.setTitle("Graph stats");
        String[] hardCodedQuestion = { "I like to work with Java","I think Java is fun","Java is my preffered language","My assignment are fun","My assignment are to easy","I always do my assignments","I always attend my class"};
        List<String> wordList = Arrays.asList(hardCodedQuestion);
        List<Map<String,Double>> resultMap = new ArrayList<>();
        XYChart.Series<String,Double> series = new XYChart.Series<>();

        for (int i = 0; i < wordList.size(); i++) {
            Map<String,Double> avg = Utils.fetchGraphData(wordList.get(i));
            resultMap.add(avg);
        }

        for (Map<String, Double> map : resultMap) {
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                series.getData().add(new XYChart.Data<>(key, value));
            }
        }
        series.setName("Average answers");
        graph.getData().add(series);
    }
}

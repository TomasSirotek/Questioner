package en.assignment.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class GraphController implements Initializable {
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private LineChart graph;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            // fetch data into the graph
        setData();
    }


    public void setData() {
        //x axis representation
        x.setLabel("Questions");
        //y axis representation
        y.setLabel("Avg");
        graph.setTitle("Graph stats");

        XYChart.Series series = new XYChart.Series();
        series.setName("No of schools in an year");

        series.getData().add(new XYChart.Data(1970, 15));
        series.getData().add(new XYChart.Data(1980, 30));
        series.getData().add(new XYChart.Data(1990, 60));
        series.getData().add(new XYChart.Data(2000, 120));
        series.getData().add(new XYChart.Data(2013, 240));
        series.getData().add(new XYChart.Data(2014, 300));

        //Setting the data to Line chart
        graph.getData().add(series);


    }
}

package dk.javahandson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ToggleGroup;

public class Survey {
    private final ObservableList<ToggleGroup> answers = FXCollections.observableArrayList();

    public ObservableList<ToggleGroup> getQuestions() {
        return answers;
    }
}

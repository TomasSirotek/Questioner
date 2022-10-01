package dk.javahandson;

import javafx.collections.ObservableList;

public class Store {
    private String answer;
    private int scoreAnswer;

    private final ObservableList<User> usersObservableList;


    public Store(String answer, ObservableList<User> usersObservableList){
        this.answer=answer;
        this.usersObservableList = usersObservableList;
    }

    public ObservableList<User> getUsersObservableList(){
        return usersObservableList;
    }

    public void setUsersObservableList(User u){
        usersObservableList.add(u);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getScoreAnswer() {
        return scoreAnswer;
    }

    public void setScoreAnswer(int scoreAnswer) {
        this.scoreAnswer = scoreAnswer;
    }
}

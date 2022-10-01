package dk.javahandson;

import java.util.List;

public class User {
    private String id;

    private String userName;
    private int reachedScore;
    private double timeTaken;

    private List<Question> resultList;
    private boolean isListed;

    public User(String id, String userName,int reachedScore, double timeTaken, boolean isListed) {
        this.id = id;
        this.userName = userName;
        this.reachedScore = reachedScore;
        this.timeTaken = timeTaken;
        this.isListed = isListed;
    }

    public boolean isListed(){
        return isListed;
    }

    public String getId(){
       return id;
    }
    public int getReachedScore(){
        return reachedScore;
    }
}

package dk.javahandson;

import java.util.List;

public class User {
    private Integer id;

    private String name;
    private Integer total;
    private Double time;

    private List<Question> resultList;
    private boolean isListed;

    public User(Integer id, String name,int total, double time, boolean isListed) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.time = time;
        this.isListed = isListed;
    }

    public boolean isListed(){
        return isListed;
    }

    public Integer getId(){
       return id;
    }
    public int getTotal(){
        return total;
    }
    public String getName(){
        return name;
    }
    public Double getTime(){
        return time;
    }
}
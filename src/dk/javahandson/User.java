package dk.javahandson;


public class User {
    private Integer id;
    private String name;
    private Integer total;
    private Double time;
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
    public void setId(Integer id){
        this.id = id;
    }
    public int getTotal(){
        return total;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public Double getTime(){
        return time;
    }
}

package dk.javahandson;


public class User {
    private Integer id;
    private String name;
    private Integer total;

    public User(Integer id, String name,int total) {
        this.id = id;
        this.name = name;
        this.total = total;
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

    public void setTotal(Integer total){ this.total = total;}
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}

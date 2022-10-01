package dk.javahandson;


public class Question {
   // private String question;
    private int id;
    private String answer;
    private String userName;

    public Question(int id,String answer,String userName){
        // this.question=question;
        this.id= id;
        this.answer=answer;
        this.userName= userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() { return answer; }

    public void setAnswer(String answer) { this.answer = answer; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }
}

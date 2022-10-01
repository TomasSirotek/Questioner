package dk.javahandson;


public class Question {
   // private String question;
    private int numQuestion;
    private String answer;
    private String userName;

    public Question(int numQuestion,String answer,String userName){
        // this.question=question;
        this.numQuestion= numQuestion;
        this.answer=answer;
        this.userName= userName;
    }

//    public String getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(String question) {
//        this.question = question;
//    }

    public int getNumQuestion() {
        return numQuestion;
    }

    public void setNumQuestion(int numQuestion) {
        this.numQuestion = numQuestion;
    }

    public String getAnswer() { return answer; }

    public void setAnswer(String answer) { this.answer = answer; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }
}

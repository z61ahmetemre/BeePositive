package com.example.android.bee;

public class BlankQuestion extends Questions {
    String answer;

    BlankQuestion() {
        answer = "";
    }

    /**
     * @return Desired answer.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param theAnswer The users' answer which will be stored.
     */
    public void setAnswer(String theAnswer) {
        answer = theAnswer;
    }
}

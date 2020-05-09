package com.example.android.bee;

public class ChoiceQuestion extends Questions {
    int answer;

    public ChoiceQuestion() {
        answer = -1;
    }

    /**
     * @return answer of the user.
     */
    public int getAnswer() {
        return answer;
    }

    /**
     * @param theAnswer The users' answer which will be stored.
     */
    public void setAnswer(int theAnswer) {
        answer = theAnswer;
    }
}

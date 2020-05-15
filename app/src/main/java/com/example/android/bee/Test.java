package com.example.android.bee;

import java.util.ArrayList;
import java.util.List;

public class Test {
    List<Questions> questions;
    List<BlankQuestion> dailyQuestions;
    String date;

    /**
     * if type 0: daily test
     * type 1: weekly test
     *
     * @param type
     */
    public Test(int type) {
        if (type == 0) {
            dailyQuestions = new ArrayList<>();
            for (int i = 0; i < 3; i++)
                dailyQuestions.add(new BlankQuestion());
        } else if (type == 1) {
            questions = new ArrayList<>();
            for (int i = 0; i < 15; i++)
                questions.add(i, new ChoiceQuestion());
            for (int i = 15; i < 21; i++)
                questions.add(i, new BlankQuestion());
        }
        date = null;
    }

    public List<BlankQuestion> getDailyQuestions() {
        return dailyQuestions;
    }

    public void setDailyQuestions(List<BlankQuestion> dailyQuestions) {
        this.dailyQuestions = dailyQuestions;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> q) {
        for (int i = 0; i < 21; i++) {
            if (i < 15)
                ((ChoiceQuestion) questions.get(i)).setAnswer(((ChoiceQuestion) q.get(i)).getAnswer());
            else
                ((BlankQuestion) questions.get(i)).setAnswer(((BlankQuestion) q.get(i)).getAnswer());
        }
    }

    public void setAnswerChoices(int no, int answer) {
        ((ChoiceQuestion) questions.get(no)).setAnswer(answer);
    }

    public void setAnswerBlank(int no, String answer) {
        ((BlankQuestion) questions.get(no)).setAnswer(answer);
    }

    public void setDailyAnswer(int no, String answer) {
        dailyQuestions.get(no).setAnswer(answer);
    }
}

package com.example.android.bee;

import java.util.ArrayList;
import java.util.List;

public class Test {
    List<Questions> questions;
    List<BlankQuestion> dailyQuestions;
    String date;
    List<Double> nlpResultsPositive;
    List<Double> nlpResultsNegative;
    List<Double> nlpResultsChoices;

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
        nlpResultsPositive = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            nlpResultsPositive.add(-1.0);
        }
        nlpResultsNegative = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            nlpResultsNegative.add(-1.0);
        }
        nlpResultsChoices = new ArrayList<>();
        for(int i = 0; i < 15; i++) {
            nlpResultsChoices.add(-1.0);
        }
    }

    public Test() {
        questions = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            if (i < 15)
                questions.add(new ChoiceQuestion());
            else
                questions.add(new BlankQuestion());
        }
        dailyQuestions = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            dailyQuestions.add(new BlankQuestion());
        nlpResultsPositive = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            nlpResultsPositive.add(-1.0);
        }
        nlpResultsNegative = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            nlpResultsNegative.add(-1.0);
        }
        nlpResultsChoices = new ArrayList<>();
        for(int i = 0; i < 15; i++) {
            nlpResultsChoices.add(-1.0);
        }
    }

    public List<Double> getNlpResultsChoices() {
        return nlpResultsChoices;
    }

    public void setNlpResultsChoices(List<Double> nlpResultsChoices) {
        this.nlpResultsChoices = nlpResultsChoices;
    }

    public List<Double> getNlpResultsPositive() {
        return nlpResultsPositive;
    }

    public void setNlpResultsPositive(List<Double> nlpResultsPositive) {
        this.nlpResultsPositive = nlpResultsPositive;
    }

    public List<Double> getNlpResultsNegative() {
        return nlpResultsNegative;
    }

    public void setNlpResultsNegative(List<Double> nlpResultsNegative) {
        this.nlpResultsNegative = nlpResultsNegative;
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
        this.questions = q;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

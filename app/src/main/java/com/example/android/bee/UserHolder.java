package com.example.android.bee;

import java.util.List;

/**
 * This class exist in order to handle data reading from firebase database.
 */
public class UserHolder {
    private String name;
    private String userID;
    private int sex;
    private double happinessPercentage;
    private int age;
    private List<Integer> dopamine;
    private List<Integer> serotonin;
    private List<Integer> endorphins;
    private List<Integer> oxytocin;
    private String password;
    private List<Double> happinessHistory;
    private String notes;
    private int testCounter;
    private String regisrationDate;
    private int weekCounter;
    private int dayCounter;
    private int momentCounter;
    private List<Moment> moments;
    private List<Test> dailyTests;
    private List<Test> weeklyTests;

    public UserHolder() {
    }

    public List<Test> getDailyTests() {
        return dailyTests;
    }

    public void setDailyTests(List<Test> dailyTests) {
        this.dailyTests = dailyTests;
    }

    public List<Test> getWeeklyTests() {
        return weeklyTests;
    }

    public void setWeeklyTests(List<Test> weeklyTests) {
        this.weeklyTests = weeklyTests;
    }

    public int getDayCounter() {
        return dayCounter;
    }

    public void setDayCounter(int dayCounter) {
        this.dayCounter = dayCounter;
    }

    public int getMomentCounter() {
        return momentCounter;
    }

    public void setMomentCounter(int momentCounter) {
        this.momentCounter = momentCounter;
    }

    public List<Moment> getMoments() {
        return moments;
    }

    public void setMoments(List<Moment> moments) {
        this.moments = moments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public double getHappinessPercentage() {
        return happinessPercentage;
    }

    public void setHappinessPercentage(double happinessPercentage) {
        this.happinessPercentage = happinessPercentage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getDopamine() {
        return dopamine;
    }

    public void setDopamine(List<Integer> dopamine) {
        this.dopamine = dopamine;
    }

    public List<Integer> getSerotonin() {
        return serotonin;
    }

    public void setSerotonin(List<Integer> serotonin) {
        this.serotonin = serotonin;
    }

    public List<Integer> getEndorphins() {
        return endorphins;
    }

    public void setEndorphins(List<Integer> endorphins) {
        this.endorphins = endorphins;
    }

    public List<Integer> getOxytocin() {
        return oxytocin;
    }

    public void setOxytocin(List<Integer> oxytocin) {
        this.oxytocin = oxytocin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Double> getHappinessHistory() {
        return happinessHistory;
    }

    public void setHappinessHistory(List<Double> happinessHistory) {
        this.happinessHistory = happinessHistory;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getTestCounter() {
        return testCounter;
    }

    public void setTestCounter(int testCounter) {
        this.testCounter = testCounter;
    }

    public String getRegisrationDate() {
        return regisrationDate;
    }

    public void setRegisrationDate(String regisrationDate) {
        this.regisrationDate = regisrationDate;
    }

    public int getWeekCounter() {
        return weekCounter;
    }

    public void setWeekCounter(int weekCounter) {
        this.weekCounter = weekCounter;
    }

}

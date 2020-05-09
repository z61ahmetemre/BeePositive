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
    private int dopamine;
    private int serotonin;
    private int endorphins;
    private int oxytocin;
    private String password;
    private boolean isRegistered;
    private List<Double> happinessHistory;
    private String notes;
    private int testCounter;
    private String regisrationDate;
    private int weekCounter;

    public UserHolder() {
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

    public int getDopamine() {
        return dopamine;
    }

    public void setDopamine(int dopamine) {
        this.dopamine = dopamine;
    }

    public int getSerotonin() {
        return serotonin;
    }

    public void setSerotonin(int serotonin) {
        this.serotonin = serotonin;
    }

    public int getEndorphins() {
        return endorphins;
    }

    public void setEndorphins(int endorphins) {
        this.endorphins = endorphins;
    }

    public int getOxytocin() {
        return oxytocin;
    }

    public void setOxytocin(int oxytocin) {
        this.oxytocin = oxytocin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
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

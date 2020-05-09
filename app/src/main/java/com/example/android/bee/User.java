package com.example.android.bee;

import java.util.ArrayList;
import java.util.List;

public class User {

  private static User instance = new User();

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
  private String notes;     //in profile users can store their own notes
  private int testCounter;  //to know how many test is solved
  private String regisrationDate;
  private int weekCounter;
  private String updater = "NULL";


  private User() {
    happinessHistory = new ArrayList<Double>();
    happinessHistory.add(-1.0);
  }

  public static User getInstance() {
    if(instance == null)
      instance = new User();
    return instance;
  }

  public String getUpdater() {
    return updater;
  }

  public void setUpdater(String updater) {
    this.updater = updater;
  }

  public int getWeekCounter() { return weekCounter;}

  public void setWeekCounter( int i ) { weekCounter = i;}

  public String getRegisrationDate() { return regisrationDate;}

  public void setRegisrationDate( String str) { regisrationDate = str;}

  public int getTestCounter() { return testCounter;}

  public void setTestCounter( int i) { testCounter = i;}

  public List<Double> getHappinessHistory() { return happinessHistory;}

  public void setHappinessHistory( List<Double> l) { happinessHistory = l;}

  public String getNotes() { return notes;}

  public void setNotes( String s) { notes = s;}

  public int getDopamine() { return dopamine;}

  public int getSerotonin() { return serotonin;}

  public int getEndorphins() { return endorphins;}

  public int getOxytocin() { return oxytocin;}

  public void setDopamine( int i) { dopamine = i;}

  public void setSerotonin( int i) { serotonin = i;}

  public void setEndorphins( int i) { endorphins = i;}

  public void setOxytocin( int i) { oxytocin = i;}

  public double getHappinessPercentage() {
    return happinessPercentage;
  }

  public void setHappinessPercentage( double d) {
    happinessPercentage = d;
  }

  public String getName() {
    return name;
  }

  public String getUserID() {
    return userID;
  }

  public int getSex() {
    return sex;
  }

  public int getAge() {
    return age;
  }

  public String getPassword() {
    return password;
  }

  public boolean getIsRegistered() {
    return isRegistered;
  }

  public void setName( String theName) {
    name = theName;
  }

  public void setUserID( String theID) {
    userID = theID;
  }

  public void setSex( int theSex) {
    sex = theSex;
  }

  public void setAge( int theAge) {
    age = theAge;
  }

  public void setPassword( String thePass) {
    password = thePass;
  }

  public void setIsRegistered( boolean b) {
    isRegistered = b;
  }

  public int[][] showHappinessHistory() {
    return null;
  }

  public void sendDailyDataToServer() {
    return;
  }

  public void synchronize() {
    return;
  }

  public void deleteAccount() {
    return;
  }
}






















package com.example.android.bee;

public class User {
  private String name;
  private String userID;
  private int sex;
  private double happinessPercentage;
  private int age;
  private int[] hormones;
  private String password;
  private boolean isRegistered;
  private ServerManager sm;


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






















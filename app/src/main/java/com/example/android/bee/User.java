package com.example.android.bee;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private int testCounter;  //to know how many daily test is solved
    private String regisrationDate;
    private int weekCounter;  //to know how many weekly test is solved
    private String updater = "NULL"; //TODO: delete , also check syncroniz()
    private int dayCounter;
    private int momentCounter;
    private List<Moment> moments;
    private List<Test> dailyTests;
    private List<Test> weeklyTests;

    private User() {
        happinessHistory = new ArrayList<Double>();
        happinessHistory.add(-1.0);
        moments = new ArrayList<>();
        Moment tmp = new Moment();
        moments.add(tmp);

        Test d = new Test(0);
        Test w = new Test(1);
        dailyTests = new ArrayList<>();
        weeklyTests= new ArrayList<>();
        dailyTests.add(d);
        weeklyTests.add(w);

    }

    public static User getInstance() {
        if (instance == null)
            instance = new User();
        return instance;
    }

    public boolean checkDailyTestExist() {
        if(dayCounter > testCounter)
            return true;
        else
            return false;
    }

    public boolean checkWeeklyTestExist() {
        if(dayCounter % 7 == 0)
            return true;
        else
            return false;
    }

    public void addMoment(Moment m) {
        moments.add(m);
    }

    public void addDailyTests(Test t) {
        dailyTests.add(t);
    }

    public void addWeeklyTests(Test t) {
        weeklyTests.add(t);
    }

    public int calculateDayCounter() {
        int result = -1;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String theDate = sdf.format(new Date());
            String CurrentDate= theDate;
            String FinalDate= regisrationDate;
            Date date1;
            Date date2;
            SimpleDateFormat dates = new SimpleDateFormat("dd/MM/yyyy");
            date1 = dates.parse(CurrentDate);
            date2 = dates.parse(FinalDate);
            long difference = Math.abs(date1.getTime() - date2.getTime());
            long differenceDates = difference / (24 * 60 * 60 * 1000);
            //dayCounter = (int) differenceDates;
            result = (int) differenceDates;
            //String dayDifference = Long.toString(differenceDates);
            //textView.setText("The difference between two dates is " + dayDifference + " days");
        } catch (Exception exception) {
            //Toast.makeText(this, "Unable to find difference", Toast.LENGTH_SHORT).show();
        }
        return result + 1;
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

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public int getWeekCounter() {
        return weekCounter;
    }

    public void setWeekCounter(int i) {
        weekCounter = i;
    }

    public String getRegisrationDate() {
        return regisrationDate;
    }

    public void setRegisrationDate(String str) {
        regisrationDate = str;
    }

    public int getTestCounter() {
        return testCounter;
    }

    public void setTestCounter(int i) {
        testCounter = i;
    }

    public List<Double> getHappinessHistory() {
        return happinessHistory;
    }

    public void setHappinessHistory(List<Double> l) {
        happinessHistory = l;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String s) {
        notes = s;
    }

    public int getDopamine() {
        return dopamine;
    }

    public int getSerotonin() {
        return serotonin;
    }

    public int getEndorphins() {
        return endorphins;
    }

    public int getOxytocin() {
        return oxytocin;
    }

    public void setDopamine(int i) {
        dopamine = i;
    }

    public void setSerotonin(int i) {
        serotonin = i;
    }

    public void setEndorphins(int i) {
        endorphins = i;
    }

    public void setOxytocin(int i) {
        oxytocin = i;
    }

    public double getHappinessPercentage() {
        return happinessPercentage;
    }

    public void setHappinessPercentage(double d) {
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

    public void setName(String theName) {
        name = theName;
    }

    public void setUserID(String theID) {
        userID = theID;
    }

    public void setSex(int theSex) {
        sex = theSex;
    }

    public void setAge(int theAge) {
        age = theAge;
    }

    public void setPassword(String thePass) {
        password = thePass;
    }

    public void setIsRegistered(boolean b) {
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






















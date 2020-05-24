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
    private List<Integer> dopamine;     //Indexes show daily values
    private List<Integer> serotonin;    //Indexes show daily values
    private List<Integer> endorphins;   //Indexes show daily values
    private List<Integer> oxytocin;     //Indexes show daily values
    private String password;
    private List<Double> happinessHistory;  //Indexes show daily values
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
        for(int i = 0; i < 31; i++) {
            happinessHistory.add(i,-1.0);
        }

        dopamine = new ArrayList<Integer>();
        for(int i = 0; i < 31; i++) {
            dopamine.add(i,-1);
        }

        serotonin = new ArrayList<Integer>();
        for(int i = 0; i < 31; i++) {
            serotonin.add(i,-1);
        }

        endorphins = new ArrayList<Integer>();
        for(int i = 0; i < 31; i++) {
            endorphins.add(i,-1);
        }

        oxytocin = new ArrayList<Integer>();
        for(int i = 0; i < 31; i++) {
            oxytocin.add(i,-1);
        }

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
        if((dayCounter % 7 == 0) || (dayCounter < 7 && weekCounter == 0))
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
}






















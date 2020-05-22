package com.example.android.bee;

import java.util.ArrayList;
import java.util.List;

public class Moment {

    String  date;
    String  emoji;

    List<Boolean> activities;

    String theMoment;

    Moment() {
        date = "NULL";
        emoji = "NULL";

        activities = new ArrayList<>();
        for(int i = 0; i < 12; i++)
            activities.add(false);

        theMoment = "NULL";
    }

    public void selectActivity(int i, boolean b) {
        activities.set(i,b);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public List<Boolean> getActivities() {
        return activities;
    }

    public void setActivities(List<Boolean> activities) {
        this.activities = activities;
    }

    public String getTheMoment() {
        return theMoment;
    }

    public void setTheMoment(String theMoment) {
        this.theMoment = theMoment;
    }
}

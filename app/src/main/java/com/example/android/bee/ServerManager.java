package com.example.android.bee;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ServerManager {

    private static ServerManager instance;

    User user;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    public ServerManager() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        user = User.getInstance();
        mAuth = FirebaseAuth.getInstance();
    }

    public static ServerManager getInstance() {
        if (instance == null)
            instance = new ServerManager();
        return instance;
    }

    /**
     * This method will pull the data of the user from database every time opening app.
     * In User object, there is integer value storing test number. According to this
     * number method will search for tests data in database.
     * The test will be stored in database like this way:
     * "UID"-"Number of the Test"
     * e.g. 1N6kEwz6qJehYyeplUIhmFQdle42-D1 => means 1N6kEwz6qJehYyeplUIhmFQdle42 named user's daily test 1
     * ...-W1 will store weekly tests.
     */
    public void syncronize() {
        final UserHolder[] holder = new UserHolder[1];
        holder[0] = new UserHolder();
        try {
            mDatabase.child("users").child(mAuth.getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (!user.getUpdater().equals("-")) {
                        try {
                            holder[0] = dataSnapshot.getValue(UserHolder.class);
                            user.setDayCounter(holder[0].getDayCounter());
                            user.setName(holder[0].getName());
                            user.setUserID(holder[0].getUserID());
                            user.setSex(holder[0].getSex());
                            user.setHappinessPercentage(holder[0].getHappinessPercentage());
                            user.setAge(holder[0].getAge());
                            user.setDopamine(holder[0].getDopamine());
                            user.setSerotonin(holder[0].getSerotonin());
                            user.setEndorphins(holder[0].getEndorphins());
                            user.setOxytocin(holder[0].getOxytocin());
                            user.setPassword(holder[0].getPassword());
                            user.setHappinessHistory(holder[0].getHappinessHistory());
                            user.setNotes(holder[0].getNotes());
                            user.setTestCounter(holder[0].getTestCounter());
                            user.setRegisrationDate(holder[0].getRegisrationDate());
                            user.setWeekCounter(holder[0].getWeekCounter());
                            user.setMomentCounter(holder[0].getMomentCounter());
                            user.setMoments(holder[0].getMoments());
                            user.setDailyTests(holder[0].getDailyTests());
                            user.setWeeklyTests(holder[0].getWeeklyTests());
                        } catch (Exception e) {
                            Log.e("**********SYNC ERROR***", "ERROR");
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } catch (Error e) {
            Log.e("SYNCRONIZE ERROR", "User account deleted.");
        }
    }

    public void sendNLPDataToDatabase(int i) {
        final Testing testing = new Testing(i);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                testing.analyzeAnswers();
            }
        }, 1000);
    }

    public void createAccount() {
        mDatabase.child("users").child(mAuth.getUid()).setValue(user);
        return;
    }
}
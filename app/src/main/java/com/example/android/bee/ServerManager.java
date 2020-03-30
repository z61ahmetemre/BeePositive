package com.example.android.bee;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.  FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ServerManager {

  private static ServerManager instance;

  private User user;
  private DatabaseReference mDatabase;
  private DatabaseReference mUser;
  private FirebaseAuth mAuth;

  public ServerManager() {
    mDatabase = FirebaseDatabase.getInstance().getReference();
    user = User.getInstance();
    mAuth = FirebaseAuth.getInstance();
  }

  public static ServerManager getInstance() {
    if(instance == null)
      instance = new ServerManager();
    return instance;
  }

  public void getHappinessHistory() {
    return;
  }

  public void sendDailyData() {
    return;
  }

  /**
   * This method will pull the data of the user from database everytime opening app.
   * In User object, there is integer value storing test number. According to this
   * number method will search for tests data in database.
   * The test will be stored in database like this way:
   *    "UID"-"Number of the Test"
   *    e.g. 1N6kEwz6qJehYyeplUIhmFQdle42-D1 => means 1N6kEwz6qJehYyeplUIhmFQdle42 named user's daily test 1
   *         ...-W1 will store weekly tests.
   */
  public void syncronize() {
    mDatabase.child("users").child(mAuth.getUid()).addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        user = dataSnapshot.getValue(User.class);
        user.setNotes("YEDİ");
        mDatabase.child("notes").child(mAuth.getUid()).setValue(user.getNotes());
      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {

      }
    });
    Log.w("WORKED", user.getTestCounter() + "--------------------------------------------"
          + "\n " + user.getNotes());
    return;
  }

  public void deleteAccount() {
    return;
  }

  public void sendDataToServer() {
    return;
  }

  public void getTestDataFromServer() {
    return;
  }

  public void checkIsRegistered() {
    return;
  }

  public void setRegistered() {
    return;
  }

  public void createAccount() {
    mDatabase.child("users").child(mAuth.getUid()).setValue(user);
    mDatabase.child("notes").child(mAuth.getUid()).setValue(user.getNotes());
    return;
  }
}

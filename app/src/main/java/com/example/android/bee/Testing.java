package com.example.android.bee;

public class Testing {
  ServerManager sm;
  Test daily;
  Test weekly;
  static int dayCounter; //TO DO: Buna bir daha bak.
  User user;

  //Constructiona bak
  Testing( User theUser, ServerManager s) {
    user = theUser;
    sm = s;

  }

  public void setAnswer( int testType, int dayCounter) {
    return;
  }

  public void sendTestDataToServer( Test t) {
    return;
  }

  public void getTestDataFromServer() {
    return;
  }

  /**
   * NLP PART. NLP algorithms will be here.
   */
  public void analyzeAnswers() {
    return;
  }

  public void calculteHormonesPoints() {
    return;
  }
}

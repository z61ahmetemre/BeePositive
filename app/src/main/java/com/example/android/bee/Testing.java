package com.example.android.bee;

public class Testing {
  ServerManager sm;
  Test daily;
  Test weekly[];
  static int dayCounter; //TODO: Buna bir daha bak.
  User user;

  //Construction a bak
  Testing() {
    weekly = new Test[4];
    sm = ServerManager.getInstance();
    user = User.getInstance();
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

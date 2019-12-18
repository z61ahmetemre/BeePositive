package com.example.android.bee;

public class BlankQuestion extends Questions {
  String[] answer; //every index will store per week answers for the question.
  int type;

  BlankQuestion() {
    answer = new String[4];
    for(int i = 0; i < 4; i++)
      answer[i] = "EMPTY";
    type = 0;
  }

  /**
   * @param i The index of the answer.
   * @return Desired answer.
   */
  public String getAnswer(int i) {
    return null;
  }

  /**
   * @param i The index of the answer.
   * @param theAnswer The users' answer which will be stored.
   */
  public void setAnswer(int i, String theAnswer) {
    return;
  }
}

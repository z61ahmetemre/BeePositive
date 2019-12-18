package com.example.android.bee;

public class ChoiceQuestion extends Questions {
  int[] answer;    //every index will store per week answers for the question.
  int type;
  int choiceNumber;
  String[] choices;

  /**
   *  Firstly, the choice question will be created by the constructor. The question will be stored in the parent Question class.
   * @param theChoiceNumber The number of choices which the question have.
   * @param theChoices All choices of the question.
   */
  ChoiceQuestion(int theChoiceNumber, String[] theChoices) {
    choiceNumber = theChoiceNumber;
    for( int i = 0; i < choiceNumber; i++)
      choices[i] = theChoices[i];
    for(int i = 0; i < 4; i++)
      answer[i] = -1;
  }

  /**
   * @param i The index of the answer.
   * @return Desired answer of the user.
   */
  public int getAnswer( int i) {
    return answer[i];
  }

  /**
   * @param i The index of the answer.
   * @param theAnswer The users' answer which will be stored.
   */
  public void setAnswer( int i, int theAnswer) {
    answer[i] = theAnswer;
  }
}

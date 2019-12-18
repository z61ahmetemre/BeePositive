package com.example.android.bee;

public class Notifications {
  User user;
  Information info;
  String[] recommendation;

  Notifications( User theUser, Information theInfo) {
    user = theUser;
    info = theInfo;
  }

  /**
   * Gives recommendation to user as notifications.
   */
  public void giveRecommendation() {
    return;
  }

  /**
   * This method checks periodically the hormones level.
   * If there need to be given recommendation to increase
   * the hormone level, the method will call giveRecommendation() method.
   */
  public void checkHormoneLevels() {
    return;
  }
}

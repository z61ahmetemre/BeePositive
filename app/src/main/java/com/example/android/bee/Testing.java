package com.example.android.bee;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Testing {

    double[] coef = new double[21];

    //choices questions        //Sentiment analysis of questions
  /*final double Q_1  =  2.84; //negative":0.584156,"positive":0.415844  2
    final double Q_2  =  1.89; //negative":0.102636,"positive":0.897364  1
    final double Q_3  = -2.67; //negative":0.888205,"positive":0.111795 -3
    final double Q_4  =  1.73; //negative":0.272555,"positive":0.727445  1
    final double Q_5  = -2.13; //negative":0.705068,"positive":0.294932 -3
    final double Q_6  =  1.06; //negative":0.479832,"positive":0.520168  2
    final double Q_7  =  1.22; //negative":0.782356,"positive":0.217644  1
    final double Q_8  =  3.48; //negative":0.837782,"positive":0.162218  3
    final double Q_9  = -1.76; //negative":0.439462,"positive":0.560538 -4
    final double Q_10 =   3.9; //negative":0.057339,"positive":0.942661  2
    final double Q_11 =   4.5; //negative":0.471179,"positive":0.528821  3
    final double Q_12 =   3.6; //negative":0.224468,"positive":0.775532  2
    final double Q_13 =  3.58; //negative":0.206332,"positive":0.793668  2
    final double Q_14 =  1.72; //negative":0.288288,"positive":0.711712  1
    final double Q_15 =  3.72; //negative":0.13181, "positive":0.86819   2
    //blank questions         //Sentiment analysis of questions
    final double Q_16 = 1.32; //negative":0.679355,"positive":0.320645
    final double Q_17 = 1.67; //negative":0.320848,"positive":0.679152
    final double Q_18 = 1.61; //negative":0.38973," positive":0.61027
    final double Q_19 = 1.34; //negative":0.655309,"positive":0.344691
    final double Q_20 = 1.99; //negative":0.007719,"positive":0.992281
    final double Q_21 = 1.52; //negative":0.479364,"positive":0.520636 */


    int testNumber;
    ServerManager sm;
    User user;
    double[][] nlpResult;  //0: positive 1: negative
    String[] answers;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    List<Double> c = new ArrayList<>();

    Testing(int testNumber) {
        sm = ServerManager.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        user = User.getInstance();
        mAuth = FirebaseAuth.getInstance();
        nlpResult = new double[6][2];
        this.testNumber = testNumber;
        answers = new String[6];
        coef[0] = 2.84;
        coef[1] = 1.89;
        coef[2] = -2.67;
        coef[3] = 1.73;
        coef[4] = -2.13;
        coef[5] = 1.06;
        coef[6] = 1.22;
        coef[7] = 3.48;
        coef[8] = -1.76;
        coef[9] = 3.9;
        coef[10] = 4.5;
        coef[11] = 3.6;
        coef[12] = 3.58;
        coef[13] = 1.72;
        coef[14] = 3.72;
        coef[15] = 1.32;
        coef[16] = 1.67;
        coef[17] = 1.61;
        coef[18] = 1.34;
        coef[19] = 1.99;
        coef[20] = 1.52;
    }

    /**
     * NLP PART. NLP algorithms will be here.
     */
    public void analyzeAnswers() {
        getBlankAnswersFromTest();
        getChoiceAnswersFromTest();

        for (int i = 0; i < 6; i++) {
            analyzeText(i, answers[i]);
        }

        for (int i = 0; i < 15; i++) {
            c.set(i, c.get(i) * coef[i]);
        }

        user.getWeeklyTests().get(testNumber).setNlpResultsChoices(c);
        mDatabase.child("users").child(mAuth.getUid()).child("weeklyTests").child(testNumber + "").child("nlpResultsChoices").setValue(c);
    }

    public void getChoiceAnswersFromTest() {
        for (int i = 0; i < 15; i++)
            c.add(user.getWeeklyTests().get(testNumber).getQuestions().get(i).getAnswerC() * 1.0);
    }

    public void getBlankAnswersFromTest() {
        for (int i = 0; i < 6; i++)
            answers[i] = user.getWeeklyTests().get(testNumber).getQuestions().get(15 + i).getAnswerB();
    }

    /**
     * NLP Sentiment Analysis
     * This methods calculate the positivity and negativity of the input string
     *
     * @return JSON object storing positive and negative percentages
     */
    public void analyzeText(final int index, String sourceText) {
        final String[] resultArr = new String[2];
        resultArr[0] = "";
        resultArr[1] = "";
        //String sourceText = "I am an old man.";
        String getURL = "https://api.uclassify.com/v1/uclassify/sentiment/classify/?readKey=gla684iIDJNp&text=" + encodeURL(sourceText);

        OkHttpClient client = new OkHttpClient();

        try {
            Request request = new Request.Builder()
                .url(getURL)
                .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    System.out.println(e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final JSONObject jsonResult;
                    final String result = response.body().string();
                    try {
                        jsonResult = new JSONObject(result);
                        final String convertedText = jsonResult.getString("positive");
                        final String convertedText1 = jsonResult.getString("negative");
                        mDatabase.child("users").child(mAuth.getUid())
                            .child("weeklyTests")
                            .child(testNumber + "")
                            .child("nlpResultsPositive")
                            .child(index+"")
                            .setValue(Double.parseDouble(jsonResult.getString("positive")));

                        mDatabase.child("users").child(mAuth.getUid())
                            .child("weeklyTests")
                            .child(testNumber + "")
                            .child("nlpResultsNegative")
                            .child(index+"")
                            .setValue(Double.parseDouble(jsonResult.getString("negative")));

                        Log.d("okHTTP", jsonResult.toString());
                        /*runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                float a;
                                a=Float.parseFloat(convertedText);
                                a=a*100;
                                resultArr[0] = "Positive: " + String.valueOf(a) + "%";
                                a=Float.parseFloat(convertedText1);
                                a=a*100;
                                resultArr[1] = "Negative: " + String.valueOf(a) + "%";

                            }
                        });*/
                        float a;
                        a = Float.parseFloat(convertedText);
                        a = a * 100;
                        resultArr[0] = "Positive: " + String.valueOf(a) + "%";
                        a = Float.parseFloat(convertedText1);
                        a = a * 100;
                        resultArr[1] = "Negative: " + String.valueOf(a) + "%";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //return resultArr;
    }


    public String encodeURL(String str) {
        String query = null;
        try {
            query = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //String url = "http://stackoverflow.com/search?q=" + query;
        return query;
    }
}
package com.example.android.bee;

import android.telecom.Call;
import android.util.Log;

import com.google.android.gms.common.api.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Testing {
    ServerManager sm;
    Test daily;
    Test weekly[];
    User user;

    //Construction a bak
    Testing() {
        weekly = new Test[4];
        sm = ServerManager.getInstance();
        user = User.getInstance();
    }

    public void setAnswer(int testType, int dayCounter) {
        return;
    }

    /**
     * NLP PART. NLP algorithms will be here.
     */
    public void analyzeAnswers() {
        return;
    }

    public String[] analyzeText() {
        final String[] resultArr = new String[2];
        resultArr[0] = "";
        resultArr[1] = "";
        String sourceText = "I am an old man.";
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

                        Log.d("okHTTP",jsonResult.toString());
                        runOnUiThread(new Runnable() {
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
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultArr;
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
package com.example.android.bee;

import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ListAdapter extends RecyclerView.Adapter {
    View view;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    User user = User.getInstance();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_weekly_questions, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);
        final Button submit = view.findViewById(R.id.submit_button_weekly);
        final RadioButton[][] choices = new RadioButton[15][5];

        RadioButton rb = new RadioButton(App.getContext());
        for (int k = 0; k < 15; k++) {
            for (int j = 0; j < 5; j++) {
                choices[k][j] = rb;
            }
        }

        choices[0][0] = view.findViewById(R.id.q1_c1);
        choices[0][1] = view.findViewById(R.id.q1_c2);
        choices[0][2] = view.findViewById(R.id.q1_c3);
        choices[0][3] = view.findViewById(R.id.q1_c4);
        choices[0][4] = view.findViewById(R.id.q1_c5);

        choices[1][0] = view.findViewById(R.id.q2_c1);
        choices[1][1] = view.findViewById(R.id.q2_c2);
        choices[1][2] = view.findViewById(R.id.q2_c3);
        choices[1][3] = view.findViewById(R.id.q2_c4);
        choices[1][4] = view.findViewById(R.id.q2_c5);

        choices[2][0] = view.findViewById(R.id.q3_c1);
        choices[2][1] = view.findViewById(R.id.q3_c2);
        choices[2][2] = view.findViewById(R.id.q3_c3);
        choices[2][3] = view.findViewById(R.id.q3_c4);
        choices[2][4] = view.findViewById(R.id.q3_c5);

        choices[3][0] = view.findViewById(R.id.q4_c1);
        choices[3][1] = view.findViewById(R.id.q4_c2);
        choices[3][2] = view.findViewById(R.id.q4_c3);
        choices[3][3] = view.findViewById(R.id.q4_c4);
        choices[3][4] = view.findViewById(R.id.q4_c5);

        choices[4][0] = view.findViewById(R.id.q5_c1);
        choices[4][1] = view.findViewById(R.id.q5_c2);
        choices[4][2] = view.findViewById(R.id.q5_c3);
        choices[4][3] = view.findViewById(R.id.q5_c4);
        choices[4][4] = view.findViewById(R.id.q5_c5);

        choices[5][0] = view.findViewById(R.id.q6_c1);
        choices[5][1] = view.findViewById(R.id.q6_c2);
        choices[5][2] = view.findViewById(R.id.q6_c3);
        choices[5][3] = view.findViewById(R.id.q6_c4);
        choices[5][4] = view.findViewById(R.id.q6_c5);

        choices[6][0] = view.findViewById(R.id.q7_c1);
        choices[6][1] = view.findViewById(R.id.q7_c2);
        choices[6][2] = view.findViewById(R.id.q7_c3);
        choices[6][3] = view.findViewById(R.id.q7_c4);
        choices[6][4] = view.findViewById(R.id.q7_c5);

        choices[7][0] = view.findViewById(R.id.q8_c1);
        choices[7][1] = view.findViewById(R.id.q8_c2);
        choices[7][2] = view.findViewById(R.id.q8_c3);
        choices[7][3] = view.findViewById(R.id.q8_c4);
        choices[7][4] = view.findViewById(R.id.q8_c5);

        choices[8][0] = view.findViewById(R.id.q9_c1);
        choices[8][1] = view.findViewById(R.id.q9_c2);
        choices[8][2] = view.findViewById(R.id.q9_c3);
        choices[8][3] = view.findViewById(R.id.q9_c4);
        choices[8][4] = view.findViewById(R.id.q9_c5);

        choices[9][0] = view.findViewById(R.id.q10_c1);
        choices[9][1] = view.findViewById(R.id.q10_c2);
        choices[9][2] = view.findViewById(R.id.q10_c3);
        choices[9][3] = view.findViewById(R.id.q10_c4);
        choices[9][4] = view.findViewById(R.id.q10_c5);

        choices[10][0] = view.findViewById(R.id.q11_c1);
        choices[10][1] = view.findViewById(R.id.q11_c2);
        choices[10][2] = view.findViewById(R.id.q11_c3);
        choices[10][3] = view.findViewById(R.id.q11_c4);
        choices[10][4] = view.findViewById(R.id.q11_c5);

        choices[11][0] = view.findViewById(R.id.q12_c1);
        choices[11][1] = view.findViewById(R.id.q12_c2);
        choices[11][2] = view.findViewById(R.id.q12_c3);
        choices[11][3] = view.findViewById(R.id.q12_c4);
        choices[11][4] = view.findViewById(R.id.q12_c5);

        choices[12][0] = view.findViewById(R.id.q13_c1);
        choices[12][1] = view.findViewById(R.id.q13_c2);
        choices[12][2] = view.findViewById(R.id.q13_c3);
        choices[12][3] = view.findViewById(R.id.q13_c4);
        choices[12][4] = view.findViewById(R.id.q13_c5);

        choices[13][0] = view.findViewById(R.id.q14_c1);
        choices[13][1] = view.findViewById(R.id.q14_c2);
        choices[13][2] = view.findViewById(R.id.q14_c3);
        choices[13][3] = view.findViewById(R.id.q14_c4);
        choices[13][4] = view.findViewById(R.id.q14_c5);

        choices[14][0] = view.findViewById(R.id.q15_c1);
        choices[14][1] = view.findViewById(R.id.q15_c2);
        choices[14][2] = view.findViewById(R.id.q15_c3);
        choices[14][3] = view.findViewById(R.id.q15_c4);
        choices[14][4] = view.findViewById(R.id.q15_c5);

        final EditText a16 = view.findViewById(R.id.answer_16);
        final EditText a17 = view.findViewById(R.id.answer_17);
        final EditText a18 = view.findViewById(R.id.answer_18);
        final EditText a19 = view.findViewById(R.id.answer_19);
        final EditText a20 = view.findViewById(R.id.answer_20);
        final EditText a21 = view.findViewById(R.id.answer_21);
        /*RadioGroup g1 = view.findViewById(R.id.choice_group_1);
        RadioGroup g2 = view.findViewById(R.id.choice_group_2);
        RadioGroup g3 = view.findViewById(R.id.choice_group_3);
        RadioGroup g4 = view.findViewById(R.id.choice_group_4);
        RadioGroup g5 = view.findViewById(R.id.choice_group_5);
        RadioGroup g6 = view.findViewById(R.id.choice_group_6);
        RadioGroup g7 = view.findViewById(R.id.choice_group_7);
        RadioGroup g8 = view.findViewById(R.id.choice_group_8);
        RadioGroup g9 = view.findViewById(R.id.choice_group_9);
        RadioGroup g10 = view.findViewById(R.id.choice_group_10);
        RadioGroup g11 = view.findViewById(R.id.choice_group_11);
        RadioGroup g12 = view.findViewById(R.id.choice_group_12);
        RadioGroup g13 = view.findViewById(R.id.choice_group_13);
        RadioGroup g14 = view.findViewById(R.id.choice_group_14);
        RadioGroup g15 = view.findViewById(R.id.choice_group_15);
        if( !String.valueOf(a16.getText()).equals("") &&
            !String.valueOf(a17.getText()).equals("") &&
            !String.valueOf(a18.getText()).equals("") &&
            !String.valueOf(a19.getText()).equals("") &&
            !String.valueOf(a20.getText()).equals("") &&
            String.valueOf(a21.getText()).length() > 0 &&
            /*g1.getCheckedRadioButtonId() != -1 &&
            g2.getCheckedRadioButtonId() != -1 &&
            g3.getCheckedRadioButtonId() != -1 &&
            g4.getCheckedRadioButtonId() != -1 &&
            g5.getCheckedRadioButtonId() != -1 &&
            g6.getCheckedRadioButtonId() != -1 &&
            g7.getCheckedRadioButtonId() != -1 &&
            g8.getCheckedRadioButtonId() != -1 &&
            g9.getCheckedRadioButtonId() != -1 &&
            g10.getCheckedRadioButtonId() != -1 &&
            g11.getCheckedRadioButtonId() != -1 &&
            g12.getCheckedRadioButtonId() != -1 &&
            g13.getCheckedRadioButtonId() != -1 &&
            g14.getCheckedRadioButtonId() != -1 &&
            g15.getCheckedRadioButtonId() != -1     ) {
            //submit.setClickable(true);
            }
*/
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Test test = new Test(1);

                    for (int i = 0; i < 15; i++) {
                        if (choices[i][0].isChecked()) {
                            test.setAnswerChoices(i, 1);
                        } else if (choices[i][1].isChecked()) {
                            test.setAnswerChoices(i, 2);
                        } else if (choices[i][2].isChecked()) {
                            test.setAnswerChoices(i, 3);
                        } else if (choices[i][3].isChecked()) {
                            test.setAnswerChoices(i, 4);
                        } else if (choices[i][4].isChecked()) {
                            test.setAnswerChoices(i, 5);
                        }
                    }

                    test.setAnswerBlank(15, String.valueOf(a16.getText()));
                    test.setAnswerBlank(16, String.valueOf(a17.getText()));
                    test.setAnswerBlank(17, String.valueOf(a18.getText()));
                    test.setAnswerBlank(18, String.valueOf(a19.getText()));
                    test.setAnswerBlank(19, String.valueOf(a20.getText()));
                    test.setAnswerBlank(20, String.valueOf(a21.getText()));

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String date = sdf.format(new Date());
                    test.date = date;
                    user.addWeeklyTests(test);
                    user.setWeekCounter(user.getWeekCounter() + 1);
                    String index = (user.getWeekCounter() - 1) + "";
                    mDatabase.child("users").child(mAuth.getUid()).child("weekCounter").setValue(user.getWeekCounter());
                    mDatabase.child("users").child(mAuth.getUid()).child("weeklyTests").child(index).setValue(test);
                    //mDatabase.child("wtests").child(mAuth.getUid() + "-W" + user.getWeekCounter()).setValue(test);
                    submit.setClickable(false);

                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    activity.getSupportActionBar().setTitle("My Profile");
                    ProfileFragment profileFragment = new ProfileFragment();
                    FragmentTransaction fragmentTransaction = activity.getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.your_placeholder, profileFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ListViewHolder(View itemView) {
            super(itemView);
        }

        public void bindView(int position) {

        }

        public void onClick(View view) {

        }
    }
}

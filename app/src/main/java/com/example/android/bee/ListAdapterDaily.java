package com.example.android.bee;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ListAdapterDaily extends RecyclerView.Adapter {
    View view;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    User user = User.getInstance();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_daily_questions, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);
        final Button submit = view.findViewById(R.id.submit_button_daily);
        final EditText a1 = view.findViewById(R.id.daily_answer_1);
        final EditText a2 = view.findViewById(R.id.daily_answer_2);
        final EditText a3 = view.findViewById(R.id.daily_answer_3);

        submit.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Test test = new Test(0);
                                          test.setDailyAnswer(0, String.valueOf(a1.getText()));
                                          test.setDailyAnswer(1, String.valueOf(a2.getText()));
                                          test.setDailyAnswer(2, String.valueOf(a3.getText()));
                                          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                          String date = sdf.format(new Date());
                                          test.date = date;

                                          user.setTestCounter(user.getTestCounter() + 1);
                                          mDatabase.child("users").child(mAuth.getUid()).child("testCounter").setValue(user.getTestCounter());
                                          mDatabase.child("dtests").child(mAuth.getUid() + "-D" + user.getTestCounter()).setValue(test);
                                          //submit.setClickable(false); TODO:
                                      }
                                  }
        );
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

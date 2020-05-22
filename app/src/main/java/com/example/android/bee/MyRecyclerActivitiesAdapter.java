package com.example.android.bee;

import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyRecyclerActivitiesAdapter extends RecyclerView.Adapter {
    View view;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    User user = User.getInstance();

    private int[] food_dopamine = {150, 150, 50, 200, 200, 200, 150, 200, 150, 50, 100, 200, 150, 50, 200, 200, 150, 200};
    private int[] food_serotonin = {250, 250, 150, 150, 200, 250, 150, 200, 250, 100, 250, 250, 250, 30, 250, 250, 200, 250};
    private int[] food_oxytocin = {200, 250, 150, 250, 200, 200, 100, 250, 200, 50, 100, 250, 200, 50, 250, 250, 200, 200};
    private int[] food_endorphins = {150, 100, 50, 50, 100, 200, 50, 100, 150, 50, 50, 100, 150, 50, 100, 100, 250, 250};

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_of_activities, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);
        final Button activities_submit = view.findViewById(R.id.submit_button_activities);
        final CheckBox cb1 = view.findViewById(R.id.activities_1);
        final CheckBox cb2 = view.findViewById(R.id.activities_2);
        final CheckBox cb3 = view.findViewById(R.id.activities_3);
        final CheckBox cb4 = view.findViewById(R.id.activities_4);
        final CheckBox cb5 = view.findViewById(R.id.activities_5);
        final CheckBox cb6 = view.findViewById(R.id.activities_6);
        final CheckBox cb7 = view.findViewById(R.id.activities_7);
        final CheckBox cb8 = view.findViewById(R.id.activities_8);
        final CheckBox cb9 = view.findViewById(R.id.activities_9);
        final CheckBox cb10 = view.findViewById(R.id.activities_10);
        final CheckBox cb11 = view.findViewById(R.id.activities_11);
        final CheckBox cb12 = view.findViewById(R.id.activities_12);
        final CheckBox cb13 = view.findViewById(R.id.activities_13);
        final CheckBox cb14 = view.findViewById(R.id.activities_14);
        final CheckBox cb15 = view.findViewById(R.id.activities_15);
        final CheckBox cb16 = view.findViewById(R.id.activities_16);
        final CheckBox cb17 = view.findViewById(R.id.activities_17);
        final CheckBox cb18 = view.findViewById(R.id.activities_18);

        final CheckBox[] checkBox = {cb1, cb2, cb3, cb4, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15, cb16, cb17, cb18};

        activities_submit.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     for (int i = 0; i < 18; i++) {
                                                         if (checkBox[i].isChecked()) {
                                                             user.setDopamine(user.getDopamine() + food_dopamine[i]);
                                                             mDatabase.child("users").child(mAuth.getUid()).child("dopamine").setValue(user.getDopamine());
                                                             user.setSerotonin(user.getSerotonin() + food_serotonin[i]);
                                                             mDatabase.child("users").child(mAuth.getUid()).child("serotonin").setValue(user.getSerotonin());
                                                             user.setOxytocin(user.getOxytocin() + food_oxytocin[i]);
                                                             mDatabase.child("users").child(mAuth.getUid()).child("oxytocin").setValue(user.getOxytocin());
                                                             user.setEndorphins(user.getEndorphins() + food_endorphins[i]);
                                                             mDatabase.child("users").child(mAuth.getUid()).child("endorphins").setValue(user.getEndorphins());
                                                         }
                                                     }


                                                     AppCompatActivity activity = (AppCompatActivity) view.getContext();
                                                     activity.getSupportActionBar().setTitle("My Profile");
                                                     ProfileFragment profileFragment = new ProfileFragment();
                                                     FragmentTransaction fragmentTransaction = activity.getFragmentManager().beginTransaction();
                                                     fragmentTransaction.replace(R.id.your_placeholder, profileFragment);
                                                     fragmentTransaction.addToBackStack(null);
                                                     fragmentTransaction.commit();
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

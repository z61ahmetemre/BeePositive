package com.example.android.bee;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyRecyclerFoodAdapter extends RecyclerView.Adapter {
    android.view.View view;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    User user = User.getInstance();

    private int[] food_Dopamine = {170, 170, 170, 50, 150, 170, 200, 50, 170, 170, 170, 200, 120, 50, 170, 50, 50, 170, 200};
    private int[] food_Serotonin = {250, 220, 220, 70, 100, 220, 250, 100, 220, 200, 220, 300, 200, 50, 220, 70, 70, 220, 300};
    private int[] food_Oxytocin = {25, 25, 25, 20, 100, 20, 25, 50, 25, 50, 25, 150, 15, 15, 25, 20, 20, 25, 130};
    private int[] food_Endorphine = {10, 15, 10, 15, 15, 5, 10, 15, 10, 20, 10, 20, 10, 5, 10, 15, 15, 10, 20};

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_of_foods, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);
        final Button food_submit = view.findViewById(R.id.submit_button_food);
        final CheckBox c1 = view.findViewById(R.id.food_1);
        final CheckBox c2 = view.findViewById(R.id.food_2);
        final CheckBox c3 = view.findViewById(R.id.food_3);
        final CheckBox c4 = view.findViewById(R.id.food_4);
        final CheckBox c5 = view.findViewById(R.id.food_5);
        final CheckBox c6 = view.findViewById(R.id.food_6);
        final CheckBox c7 = view.findViewById(R.id.food_7);
        final CheckBox c8 = view.findViewById(R.id.food_8);
        final CheckBox c9 = view.findViewById(R.id.food_9);
        final CheckBox c10 = view.findViewById(R.id.food_10);
        final CheckBox c11 = view.findViewById(R.id.food_11);
        final CheckBox c12 = view.findViewById(R.id.food_12);
        final CheckBox c13 = view.findViewById(R.id.food_13);
        final CheckBox c14 = view.findViewById(R.id.food_14);
        final CheckBox c15 = view.findViewById(R.id.food_15);
        final CheckBox c16 = view.findViewById(R.id.food_16);
        final CheckBox c17 = view.findViewById(R.id.food_17);
        final CheckBox c18 = view.findViewById(R.id.food_18);
        final CheckBox c19 = view.findViewById(R.id.food_19);

        final CheckBox[] checkBoxes = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19};

        food_submit.setOnClickListener(new View.OnClickListener() {
                                           @SuppressLint("ResourceType")
                                           @Override
                                           public void onClick(View view) {

                                               for (int i = 0; i < 19; i++) {
                                                   if (checkBoxes[i].isChecked()) {
                                                       user.getDopamine().add(user.getDayCounter(), food_Dopamine[i]);
                                                       mDatabase.child("users").child(mAuth.getUid()).child("dopamine").setValue(user.getDopamine());
                                                       user.getSerotonin().add(user.getDayCounter(), food_Serotonin[i]);
                                                       mDatabase.child("users").child(mAuth.getUid()).child("serotonin").setValue(user.getSerotonin());
                                                       user.getOxytocin().add(user.getDayCounter(), food_Oxytocin[i]);
                                                       mDatabase.child("users").child(mAuth.getUid()).child("oxytocin").setValue(user.getOxytocin());
                                                       user.getEndorphins().add(user.getDayCounter(), food_Endorphine[i]);
                                                       mDatabase.child("users").child(mAuth.getUid()).child("endorphins").setValue(user.getEndorphins());
                                                   }
                                               }

                                               AppCompatActivity activity = (AppCompatActivity) view.getContext();
                                               activity.getSupportActionBar().setTitle("My Profile");
                                               ProfileFragment profileFragment = new ProfileFragment();
                                               FragmentTransaction fragmentTransaction = activity.getFragmentManager().beginTransaction();
                                               fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
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


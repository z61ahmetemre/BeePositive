// MomentCreatorAdapter.java

package com.example.android.bee;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MomentCreatorAdapter extends RecyclerView.Adapter{
    View view;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    User user = User.getInstance();
//    ViewPager viewPager;
//    TabLayout tabLayout;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.moment_creator, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);

        SeekBar seekBar = view.findViewById(R.id.seekBar);
        final ImageView image = view.findViewById(R.id.emoji);
        final TextView text = view.findViewById(R.id.emoji_text);

        final TextView e_question = view.findViewById(R.id.emoji_question);
        final TextView  a_que    = view.findViewById(R.id.ac_question);

        final String selected_emoji[] = new String[1];
        selected_emoji[0] = "completely okay";


        // TODO: saate göre evening morning diyecek hale gelecek
//        String currentTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
//        currentTime = currentTime.substring(6);
//        if(currentTime.equals("AM"))
//            e_question.setText("Hey " + user.getName() + ", How are you this fine morning?");
//        else if(currentTime.equals("PM"))
//            e_question.setText("Hey " + user.getName() + ", How are you this fine evening?");

        e_question.setText("Hey " + user.getName() + ", How are you this fine moment?");
        a_que.setText("Great! What's making your moment completely okay?");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (i) {

                    case 0:
                        image.setImageResource(R.drawable.really_terrible_1);
                        text.setText("really terrible");
                        selected_emoji[0] = "really terrible";
                        a_que.setText("Okay... What's making your moment really terrible?");
                        break;

                    case 1:
                        image.setImageResource(R.drawable.somewhat_bad_2);
                        text.setText("somewhat bad");
                        selected_emoji[0] = "somewhat bad";
                        a_que.setText("Alright. What's making your moment somewhat bad?");
                        break;

                    case 2:
                        image.setImageResource(R.drawable.completely_okay_3);
                        text.setText("completely okay");
                        selected_emoji[0] = "completely okay";
                        a_que.setText("Great! What's making your moment completely okay?");
                        break;

                    case 3:
                        image.setImageResource(R.drawable.pretty_good_4);
                        text.setText("pretty good");
                        selected_emoji[0] = "pretty good";
                        a_que.setText("Nice! What's making your moment pretty good?");
                        break;
                    case 4:
                        image.setImageResource(R.drawable.super_awesome_5);
                        text.setText("super awesome");
                        selected_emoji[0] = "super awesome";
                        a_que.setText("Cool! What's making your moment super awesome?");
                        break;

                }
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        //********************ACTIVITIES***************************

        final ImageView work     = view.findViewById(R.id.ac_work);
        final ImageView family   = view.findViewById(R.id.ac_family);
        final ImageView friends  = view.findViewById(R.id.ac_friends);
        final ImageView hobbies  = view.findViewById(R.id.ac_hobbies);
        final ImageView school   = view.findViewById(R.id.ac_school);
        final ImageView relation = view.findViewById(R.id.ac_relationship);
        final ImageView travel   = view.findViewById(R.id.ac_travelling);
        final ImageView sleep    = view.findViewById(R.id.ac_sleep);
        final ImageView food     = view.findViewById(R.id.ac_food);
        final ImageView exercise = view.findViewById(R.id.ac_exercise);
        final ImageView health   = view.findViewById(R.id.ac_health);
        final ImageView music    = view.findViewById(R.id.ac_music);



//        if(selected_emoji[0].equals("really terrible")) {
//            a_que.setText("Okay... What's making your moment really terrible?");  //  TODO:
//        } else if(selected_emoji[0].equals("somewhat bad")) {
//            a_que.setText("Alright. What's making your moment somewhat bad?");
//        } else if(selected_emoji[0].equals("completely okay")) {
//            a_que.setText("Great! What's making your moment completely okay?");
//        } else if(selected_emoji[0].equals("pretty good")) {
//            a_que.setText("Nice! What's making your moment pretty good?");
//        } else if(selected_emoji[0].equals("super awesome")) {
//            a_que.setText("Cool! What's making your moment super awesome?");
//        }
//
//        final CardView c_work     = view.findViewById(R.id.acd_work);
//        final CardView c_family   = view.findViewById(R.id.acd_family);
//        final CardView c_friends  = view.findViewById(R.id.acd_friends);
//        final CardView c_hobbies  = view.findViewById(R.id.acd_hobbies);
//        final CardView c_school   = view.findViewById(R.id.acd_school);
//        final CardView c_relation = view.findViewById(R.id.acd_relationship);
//        final CardView c_travel   = view.findViewById(R.id.acd_travelling);
//        final CardView c_sleep    = view.findViewById(R.id.acd_sleep);
//        final CardView c_food     = view.findViewById(R.id.acd_food);
//        final CardView c_exercise = view.findViewById(R.id.acd_exercise);
//        final CardView c_health   = view.findViewById(R.id.acd_health);
//        final CardView c_music    = view.findViewById(R.id.acd_music);

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (work.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_work).getConstantState()) {
                    work.setImageResource(R.drawable.a_work_clicked);
                } else if(work.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_work_clicked).getConstantState()){
                    work.setImageResource(R.drawable.a_work);
                }
            }
        });

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (family.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_family).getConstantState()) {
                    family.setImageResource(R.drawable.a_family_clicked);
                } else if(family.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_family_clicked).getConstantState()){
                    family.setImageResource(R.drawable.a_family);
                }
            }
        });

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (friends.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_friends).getConstantState()) {
                    friends.setImageResource(R.drawable.a_friends_clicked);
                } else if(friends.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_friends_clicked).getConstantState()){
                    friends.setImageResource(R.drawable.a_friends);
                }
            }
        });

        hobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hobbies.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_hobbies).getConstantState()) {
                    hobbies.setImageResource(R.drawable.a_hobbies_clicked);
                } else if(hobbies.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_hobbies_clicked).getConstantState()){
                    hobbies.setImageResource(R.drawable.a_hobbies);
                }
            }
        });

        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (school.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_school).getConstantState()) {
                    school.setImageResource(R.drawable.a_school_clicked);
                } else if(school.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_school_clicked).getConstantState()){
                    school.setImageResource(R.drawable.a_school);
                }
            }
        });

        relation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (relation.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_relationships).getConstantState()) {
                    relation.setImageResource(R.drawable.a_relationships_clicked);
                } else if(relation.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_relationships_clicked).getConstantState()){
                    relation.setImageResource(R.drawable.a_relationships);
                }
            }
        });

        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (travel.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_travelling).getConstantState()) {
                    travel.setImageResource(R.drawable.a_travelling_clicked);
                } else if(travel.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_travelling_clicked).getConstantState()){
                    travel.setImageResource(R.drawable.a_travelling);
                }
            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sleep.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_sleep).getConstantState()) {
                    sleep.setImageResource(R.drawable.a_sleep_clicked);
                } else if(sleep.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_sleep_clicked).getConstantState()){
                    sleep.setImageResource(R.drawable.a_sleep);
                }
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (food.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_food).getConstantState()) {
                    food.setImageResource(R.drawable.a_food_clicked);
                } else if(food.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_food_clicked).getConstantState()){
                    food.setImageResource(R.drawable.a_food);
                }
            }
        });

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (exercise.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_exercise).getConstantState()) {
                    exercise.setImageResource(R.drawable.a_exercise_clicked);
                } else if(exercise.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_exercise_clicked).getConstantState()){
                    exercise.setImageResource(R.drawable.a_exercise);
                }
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (health.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_health).getConstantState()) {
                    health.setImageResource(R.drawable.a_health_clicked);
                } else if(health.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_health_clicked).getConstantState()){
                    health.setImageResource(R.drawable.a_health);
                }
            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (music.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_music).getConstantState()) {
                    music.setImageResource(R.drawable.a_music_clicked);
                } else if(music.getDrawable().getConstantState() == view.getResources().getDrawable(R.drawable.a_music_clicked).getConstantState()){
                    music.setImageResource(R.drawable.a_music);
                }
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

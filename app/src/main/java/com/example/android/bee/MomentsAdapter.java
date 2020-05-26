package com.example.android.bee;

import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MomentsAdapter extends RecyclerView.Adapter {
    //View view;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    User user = User.getInstance();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.moments_content, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);

    }

    @Override
    public int getItemCount() {
        return user.getMomentCounter();
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        int[] picturePath = {
            R.drawable.really_terrible_1,
            R.drawable.somewhat_bad_2,
            R.drawable.completely_okay_3,
            R.drawable.pretty_good_4,
            R.drawable.super_awesome_5
        };

        private ImageView emoji = new ImageView(App.getContext());
        private ImageView[] activities = new ImageView[12];
        private TextView textView;

        public ListViewHolder(View itemView) {
            super(itemView);
            for (int k = 0; k < 12; k++)
                activities[k] = new ImageView(App.getContext());
            emoji = itemView.findViewById(R.id.m_emojiImage);
            activities[0] = itemView.findViewById(R.id.m_work);
            activities[1] = itemView.findViewById(R.id.m_family);
            activities[2] = itemView.findViewById(R.id.m_friends);
            activities[3] = itemView.findViewById(R.id.m_hobbies);
            activities[4] = itemView.findViewById(R.id.m_school);
            activities[5] = itemView.findViewById(R.id.m_relationship);
            activities[6] = itemView.findViewById(R.id.m_travelling);
            activities[7] = itemView.findViewById(R.id.m_sleep);
            activities[8] = itemView.findViewById(R.id.m_food);
            activities[9] = itemView.findViewById(R.id.m_exercise);
            activities[10] = itemView.findViewById(R.id.m_health);
            activities[11] = itemView.findViewById(R.id.m_music);
            textView = itemView.findViewById(R.id.m_text);

        }

        int theMoment = -1;

        public void bindView(int position) {
            String str = user.getMoments().get(position).getEmoji();
            if (str.equals("really terrible"))
                emoji.setImageResource(picturePath[0]);
            else if (str.equals("somewhat bad"))
                emoji.setImageResource(picturePath[1]);
            else if (str.equals("completely okay"))
                emoji.setImageResource(picturePath[2]);
            else if (str.equals("pretty good"))
                emoji.setImageResource(picturePath[3]);
            else if (str.equals("super awesome"))
                emoji.setImageResource(picturePath[4]);
            for (int i = 0; i < 12; i++) {
                if (user.getMoments().get(position).getActivities().get(i) == false)
                    activities[i].setVisibility(View.GONE);
            }
            textView.setText(user.getMoments().get(position).getTheMoment());
            Button delete = itemView.findViewById(R.id.delete_moment);
            delete.setOnClickListener(this);
            theMoment = position;
        }

        public void onClick(View view) {
            if (user.getMomentCounter() > 1) {
                user.getMoments().remove(theMoment);
                user.setMomentCounter(user.getMomentCounter() - 1);
                mDatabase.child("users").child(mAuth.getUid()).child("momentCounter").setValue(user.getMomentCounter());
                mDatabase.child("users").child(mAuth.getUid()).child("moments").setValue(user.getMoments());
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportActionBar().setTitle("Moments");
                MomentsFragment fragment = new MomentsFragment();
                FragmentTransaction fragmentTransaction = activity.getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.your_placeholder, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            } else if (user.getMomentCounter() == 1) {
                user.getMoments().set(0, new Moment());
                user.setMomentCounter(user.getMomentCounter() - 1);
                mDatabase.child("users").child(mAuth.getUid()).child("momentCounter").setValue(user.getMomentCounter());
                mDatabase.child("users").child(mAuth.getUid()).child("moments").setValue(user.getMoments());
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportActionBar().setTitle("Moments");
                MomentsFragment fragment = new MomentsFragment();
                FragmentTransaction fragmentTransaction = activity.getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.your_placeholder, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        }
    }
}

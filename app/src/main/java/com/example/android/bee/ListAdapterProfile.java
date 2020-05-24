package com.example.android.bee;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ListAdapterProfile extends RecyclerView.Adapter {
    View view;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    User user = User.getInstance();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_page_content, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);
        TextView name   = view.findViewById(R.id.p_user_name);
        TextView age    = view.findViewById(R.id.p_user_age);
        TextView gender = view.findViewById(R.id.p_user_gender);
        TextView mail   = view.findViewById(R.id.p_user_id);
        TextView point  = view.findViewById(R.id.p_user_hap_point);
        TextView date   = view.findViewById(R.id.p_user_reg_date);

        name.setText(user.getName());
        age.setText(user.getAge() + "");
        if( user.getSex() == -1) {
            gender.setText("Other");
        } else if( user.getSex() == 0) {
            gender.setText("Female");
        } else if(user.getSex() == 1) {
            gender.setText("Male");
        }
        mail.setText(user.getUserID());
        date.setText(user.getRegisrationDate());

        user.getHappinessHistory().set(user.getDayCounter()-1, user.calculateHappinessPoint());
        mDatabase.child("users").child(mAuth.getUid()).child("happinessHistory").setValue(user.getHappinessHistory());
        if(user.getHappinessHistory().get(user.getDayCounter()-1) > 100)
            point.setText(user.getHappinessHistory().get(user.getDayCounter()-1) + "+ %");
        else
            point.setText(user.getHappinessHistory().get(user.getDayCounter()-1) + " %");
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


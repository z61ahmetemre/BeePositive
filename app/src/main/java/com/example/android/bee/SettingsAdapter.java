package com.example.android.bee;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.android.bee.GraphsActivity;
import com.example.android.bee.R;
import com.example.android.bee.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class SettingsAdapter extends RecyclerView.Adapter {
    View view;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    User user = User.getInstance();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.settings_content, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);

        final EditText name = view.findViewById(R.id.s_user_name);
        final EditText age  = view.findViewById(R.id.s_user_age);
        final RadioButton male = view.findViewById(R.id.s_male);
        final RadioButton female = view.findViewById(R.id.s_female);
        final RadioButton other = view.findViewById(R.id.s_other);

        Button s_name = view.findViewById(R.id.sb_user_name);
        Button s_age  = view.findViewById(R.id.sb_user_age);

        int sex = user.getSex();

        name.setHint(user.getName());
        age.setHint(user.getAge() + "");

        if(sex == 1)
            male.setChecked(true);
        else if( sex == 0)
            female.setChecked(true);
        else if(sex == -1)
            other.setChecked(true);

        s_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setName(String.valueOf(name.getText()));
                mDatabase.child("users").child(mAuth.getUid()).child("name").setValue(String.valueOf(name.getText()));
            }
        });

        s_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setName(String.valueOf(age.getText()));
                mDatabase.child("users").child(mAuth.getUid()).child("age").setValue(Integer.parseInt(String.valueOf(age.getText())));
            }
        });

        RadioGroup rg = view.findViewById(R.id.s_sexes);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.s_male:
                        user.setSex(1);
                        mDatabase.child("users").child(mAuth.getUid()).child("sex").setValue(1);
                        break;
                    case R.id.s_female:
                        user.setSex(0);
                        mDatabase.child("users").child(mAuth.getUid()).child("sex").setValue(0);
                        break;
                    case R.id.s_other:
                        user.setSex(-1);
                        mDatabase.child("users").child(mAuth.getUid()).child("sex").setValue(-1);
                        break;
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

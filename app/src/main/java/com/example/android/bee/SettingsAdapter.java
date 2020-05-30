package com.example.android.bee;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static android.support.constraint.Constraints.TAG;

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

        final Button s_name = view.findViewById(R.id.sb_user_name);
        final Button s_age  = view.findViewById(R.id.sb_user_age);

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
                if(String.valueOf(name.getText()).length()>0) {
                    user.setName(String.valueOf(name.getText()));
                    mDatabase.child("users").child(mAuth.getUid()).child("name").setValue(String.valueOf(name.getText()));
                    name.setText("");
                    name.setHint(user.getName());
                }
            }
        });

        s_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(String.valueOf(age.getText()).length()>0) {
                    user.setAge(Integer.parseInt(String.valueOf(age.getText())));
                    mDatabase.child("users").child(mAuth.getUid()).child("age").setValue(Integer.parseInt(String.valueOf(age.getText())));
                    age.setText("");
                    age.setHint(user.getAge() + "");
                }
            }
        });

        final EditText pass = view.findViewById(R.id.s_user_password);
        pass.setHint("New Password");

        Button savePass = view.findViewById(R.id.sb_user_password);
        savePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                FirebaseUser firebaseUser = mAuth.getInstance().getCurrentUser();
                firebaseUser.updatePassword(String.valueOf(pass.getText()))
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                user.setPassword(String.valueOf(pass.getText()));
                                mDatabase.child("users").child(mAuth.getUid()).child("password").setValue(String.valueOf(pass.getText()));
                                Log.d(TAG, "User password updated.");
                                pass.setText("");
                                Toast.makeText(view.getContext(), "Password is changed.",
                                    Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
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

        Button delete = view.findViewById(R.id.delete_data_button);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = inflater.inflate(R.layout.popup_delete_warning, null);
                TextView t = popupView.findViewById(R.id.popup_warning);
                t.setText("Deleting account is permanent and you cannot get it back! Are you sure?");
                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, false);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                Button yes = popupView.findViewById(R.id.yes_delete);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteUser();
                        ((Activity)view.getContext()).finish();
                        Intent intent = new Intent(view.getContext(), LoginActivity.class);
                        ((Activity)view.getContext()).startActivityForResult(intent, 0);
                        return;
                    }
                });
                Button no = popupView.findViewById(R.id.no_delete);
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                        return;
                    }
                });
                // dismiss the popup window when touched
//                popupView.setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//
//                        return true;
//                    }
//                });
            }
        });


    }

    public void deleteUser() {
        FirebaseUser firebaseUser = mAuth.getInstance().getCurrentUser();
        final String uid = mAuth.getUid();
        firebaseUser.delete()
            .addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        mDatabase.child("users").child(uid).setValue(null);
                        mAuth.signOut();
                        user = null;
                        Log.d("USER DELETED:", "User account deleted.");
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

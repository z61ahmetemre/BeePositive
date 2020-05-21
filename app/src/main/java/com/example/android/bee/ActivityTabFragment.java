package com.example.android.bee;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityTabFragment extends Fragment {

    View view;

    public ActivityTabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_tab_layout, container, false);
        TextView question       = view.findViewById(R.id.ac_question);
        final CardView work     = view.findViewById(R.id.ac_work);
        final CardView family   = view.findViewById(R.id.ac_family);
        final CardView friends  = view.findViewById(R.id.ac_friends);
        final CardView hobbies  = view.findViewById(R.id.ac_hobbies);
        final CardView school   = view.findViewById(R.id.ac_school);
        final CardView relation = view.findViewById(R.id.ac_relationship);
        final CardView travel   = view.findViewById(R.id.ac_travelling);
        final CardView sleep    = view.findViewById(R.id.ac_sleep);
        final CardView food     = view.findViewById(R.id.ac_food);
        final CardView exercise = view.findViewById(R.id.ac_exercise);
        final CardView health   = view.findViewById(R.id.ac_health);
        final CardView music    = view.findViewById(R.id.ac_music);

        final ImageView workButton = view.findViewById(R.id.work_button);


//        if( !image.getDrawable().equals(getResources().getDrawable(R.drawable.a_exercise)) ){
//            System.out.println("YESSSSSSs");
//        }


        workButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if( workButton.getDrawable().equals(getResources().getDrawable(R.drawable.a_work)))  {
//                    System.out.println("if");
//                    workButton.setImageResource(R.drawable.a_work_clicked);
//                } else if (workButton.getDrawable().equals(getResources().getDrawable(R.drawable.a_work_clicked))) {
//                    System.out.println("else if");
//                    workButton.setImageResource(R.drawable.a_work);
//                }
            }
        });

        return view;
    }

}

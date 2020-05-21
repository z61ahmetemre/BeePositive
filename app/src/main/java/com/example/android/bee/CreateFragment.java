package com.example.android.bee;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CreateFragment extends Fragment {

    View view;
    User user = User.getInstance();

    public CreateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.create_layout, container, false);

        SeekBar seekBar = view.findViewById(R.id.seekBar);
        final ImageView image = view.findViewById(R.id.emoji);
        final TextView text = view.findViewById(R.id.emoji_text);
        final TextView question = view.findViewById(R.id.emoji_question);

        String currentTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
        currentTime = currentTime.substring(6);
        if(currentTime.equals("AM"))
            question.setText("Hey " + user.getName() + ", How are you this fine morning?");
        else if(currentTime.equals("PM"))
            question.setText("Hey " + user.getName() + ", How are you this fine evening?");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (i) {

                    case 0:
                        image.setImageResource(R.drawable.really_terrible_1);
                        text.setText("really terrıble");
                        break;

                    case 1:
                        image.setImageResource(R.drawable.somewhat_bad_2);
                        text.setText("somewhat bad");
                        break;

                    case 2:
                        image.setImageResource(R.drawable.completely_okay_3);
                        text.setText("completely okay");
                        break;

                    case 3:
                        image.setImageResource(R.drawable.pretty_good_4);
                        text.setText("pretty good");
                        break;
                    case 4:
                        image.setImageResource(R.drawable.super_awesome_5);
                        text.setText("super awesome");
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

        return view;
    }

}

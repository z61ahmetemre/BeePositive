package com.example.android.bee;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class ListAdapterProgress extends RecyclerView.Adapter {
    View view;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    User user = User.getInstance();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.progress_content, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);
        final Button showGraphs = view.findViewById(R.id.show_graphics);
        TextView title  = view.findViewById(R.id.pr_title);
        TextView dopa   = view.findViewById(R.id.pr_d);
        TextView sero   = view.findViewById(R.id.pr_s);
        TextView endo   = view.findViewById(R.id.pr_e);
        TextView oxyt   = view.findViewById(R.id.pr_o);
        TextView point  = view.findViewById(R.id.pr_point);

        double doPoint, sePoint, enPoint, oxPoint, haPoint;

        title.setText("Hey " + user.getName() + ", these percentages are achieved today. If you want to see points you earned in detail click the show button. ");
        /*
        ACTIVITIES		FOODS		TOTAL		NEED		                RATIO-TO-100

        Dopamine	    2750			2650		5400		    1500		0.0667
        Endorphin 	    2050			240	      2290(2150)		600		    0.16667
        Serotonin	    3680			3500		7180		    2000		0.05
        Oxytocin 	    3350			790	      4140(3900)		1083		0.09234
*/
        if((user.getDopamine().get(user.getDayCounter()-1))*(0.0667)>=100 ) {

            dopa.setText("100+ %");
            doPoint = 100;
        } else if ((user.getDopamine().get(user.getDayCounter()-1))*(0.0667)<=0){
            doPoint = 0;
            dopa.setText(doPoint + " %");
        } else {
            doPoint = (user.getDopamine().get(user.getDayCounter()-1))*(0.0667);
            Double truncatedDoPoint = BigDecimal.valueOf(doPoint).setScale(2, RoundingMode.HALF_UP).doubleValue();
            dopa.setText(truncatedDoPoint + " %");
        }


        if((user.getEndorphins().get(user.getDayCounter()-1))*(0.16667)>=100 ) {
            endo.setText("100+ %");
            enPoint = 100;
        } else if ((user.getEndorphins().get(user.getDayCounter()-1))*(0.16667)<=0){
            enPoint = 0;
            endo.setText(enPoint + " %");
        } else {
            enPoint = (user.getEndorphins().get(user.getDayCounter()-1))*(0.16667);
            Double truncatedEnPoint = BigDecimal.valueOf(enPoint).setScale(2, RoundingMode.HALF_UP).doubleValue();
            endo.setText(truncatedEnPoint + " %");
        }

        if((user.getSerotonin().get(user.getDayCounter()-1))*(0.05)>=100 ) {
            sero.setText("100+ %");
            sePoint = 100;
        } else if ((user.getSerotonin().get(user.getDayCounter()-1))*(0.05)<=0){
            sePoint = 0;
            sero.setText(sePoint + " %");
        } else {
            sePoint = (user.getSerotonin().get(user.getDayCounter()-1))*(0.05);
            Double truncatedSePoint = BigDecimal.valueOf(sePoint).setScale(2, RoundingMode.HALF_UP).doubleValue();
            sero.setText(truncatedSePoint + " %");
        }

        if((user.getOxytocin().get(user.getDayCounter()-1))*(0.09234)>=100 ) {
            oxyt.setText("100+ %");
            oxPoint = 100;
        } else if ((user.getOxytocin().get(user.getDayCounter()-1))*(0.09234)<=0){
            oxPoint = 0;
            oxyt.setText(oxPoint + " %");
        } else {
            oxPoint = (user.getOxytocin().get(user.getDayCounter()-1))*(0.09234);
            Double truncatedOxPoint = BigDecimal.valueOf(oxPoint).setScale(2, RoundingMode.HALF_UP).doubleValue();
            oxyt.setText(truncatedOxPoint + " %");
        }
        haPoint = (doPoint/4) + (sePoint/4) + (enPoint/4) + (oxPoint/4);
        Double truncatedHaPoint = BigDecimal.valueOf(haPoint).setScale(2, RoundingMode.HALF_UP).doubleValue();
        if (haPoint<=0) {
            haPoint = 0;
            point.setText(haPoint + "%");
        }
        else
            point.setText(truncatedHaPoint +" %");
        // point.setText(user.getHappinessHistory().get(user.getDayCounter())+" points");

        showGraphs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), GraphsActivity.class);
                ((Activity)view.getContext()).startActivityForResult(intent, 0);
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

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

        title.setText("Hey " + user.getName() + ", these points are today achieved. If you want to see past day points and your progress in detail click the show button. ");
        dopa.setText(user.getDopamine().get(user.getDayCounter()-1)+" points");
        sero.setText(user.getSerotonin().get(user.getDayCounter()-1)+" points");
        endo.setText(user.getEndorphins().get(user.getDayCounter()-1)+" points");
        oxyt.setText(user.getOxytocin().get(user.getDayCounter()-1)+" points");
        point.setText(user.getHappinessHistory().get(user.getDayCounter())+" points");

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

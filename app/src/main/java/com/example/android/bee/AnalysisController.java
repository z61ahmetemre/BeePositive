package com.example.android.bee;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Handler;
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

public class AnalysisController extends RecyclerView.Adapter {
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    User user = User.getInstance();
    ServerManager sm = ServerManager.getInstance();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.analysis_content, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);

    }

    @Override
    public int getItemCount() {
        return user.getWeekCounter();
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ListViewHolder(View itemView) {
            super(itemView);
        }

        public void bindView(int position) {
            if(user.getWeeklyTests().get(position).getNlpResultsChoices().get(0) == -1) {
                sm.sendNLPDataToDatabase(position);
            }

            TextView title = itemView.findViewById(R.id.analysis_title);
            title.setText("Analysis of Weekly Test " + ( position+1));
            double choices = 0;
            for(int i = 0; i < 15; i++)
                choices += user.getWeeklyTests().get(position).getNlpResultsChoices().get(i);
            String analysis = "Choices questions: " + String.format("%1.2f",choices);

            double a16 = user.getWeeklyTests().get(position).getNlpResultsPositive().get(0)*100;
            double a17 = user.getWeeklyTests().get(position).getNlpResultsPositive().get(1)*100;
            double a18 = user.getWeeklyTests().get(position).getNlpResultsPositive().get(2)*100;
            double a19 = user.getWeeklyTests().get(position).getNlpResultsPositive().get(3)*100;
            double a20 = user.getWeeklyTests().get(position).getNlpResultsPositive().get(4)*100;
            double a21 = user.getWeeklyTests().get(position).getNlpResultsPositive().get(5)*100;
            String analysis16;
            String analysis17;
            String analysis18;
            String analysis19;
            String analysis20;
            String analysis21;
            if(a16 > 0) {
                analysis16 = "16. + positive: " + String.format("%1.4f", user.getWeeklyTests().get(position).getNlpResultsPositive().get(0)*100) + " % \n"
                    + "       - negative: " + String.format("%1.4f", user.getWeeklyTests().get(position).getNlpResultsNegative().get(0) * 100) + " % ";
            } else
                analysis16 = "16.               NOT ANSWERED!               ";

            if(a17 > 0) {
                analysis17 = "17. + positive: " + String.format("%1.4f", user.getWeeklyTests().get(position).getNlpResultsPositive().get(1) * 100) + " % \n"
                    + "       - negative: " + String.format("%1.4f", user.getWeeklyTests().get(position).getNlpResultsNegative().get(1) * 100) + " % ";
            } else
                analysis17 = "17.               NOT ANSWERED!               ";

            if(a18 > 0) {
                analysis18 = "18. + positive: " + String.format("%1.4f", user.getWeeklyTests().get(position).getNlpResultsPositive().get(2) * 100) + " % \n"
                    + "       - negative: " + String.format("%1.4f", user.getWeeklyTests().get(position).getNlpResultsNegative().get(2) * 100) + " % ";
            } else
                analysis18 = "18.               NOT ANSWERED!               ";

            if(a19 > 0) {
                analysis19 = "19. + positive: " + String.format("%1.4f", user.getWeeklyTests().get(position).getNlpResultsPositive().get(3) * 100) + " % \n"
                    + "       - negative: " + String.format("%1.4f", user.getWeeklyTests().get(position).getNlpResultsNegative().get(3) * 100) + " % ";
            } else
                analysis19 = "19.               NOT ANSWERED!               ";

            if(a20 > 0) {
                analysis20 = "20. + positive: " + String.format("%1.4f", user.getWeeklyTests().get(position).getNlpResultsPositive().get(4) * 100) + " % \n"
                    + "       - negative: " + String.format("%1.4f", user.getWeeklyTests().get(position).getNlpResultsNegative().get(4) * 100) + " % ";
            } else
                analysis20 = "20.               NOT ANSWERED!               ";

            if (a21 > 0) {
                analysis21 = "21. + positive: " + String.format("%1.4f", user.getWeeklyTests().get(position).getNlpResultsPositive().get(5) * 100) + " % \n"
                    + "       - negative: " + String.format("%1.4f", user.getWeeklyTests().get(position).getNlpResultsNegative().get(5) * 100) + " % ";
            } else
                analysis21 = "21.               NOT ANSWERED!               ";
            TextView textView = itemView.findViewById(R.id.analysis_c);
            TextView textView16 = itemView.findViewById(R.id.analysis16);
            TextView textView17 = itemView.findViewById(R.id.analysis17);
            TextView textView18 = itemView.findViewById(R.id.analysis18);
            TextView textView19 = itemView.findViewById(R.id.analysis19);
            TextView textView20 = itemView.findViewById(R.id.analysis20);
            TextView textView21 = itemView.findViewById(R.id.analysis21);
            textView.setText(analysis);
            textView16.setText(analysis16);
            textView17.setText(analysis17);
            textView18.setText(analysis18);
            textView19.setText(analysis19);
            textView20.setText(analysis20);
            textView21.setText(analysis21);
        }
        @Override
        public void onClick(View view) {

        }
    }
}

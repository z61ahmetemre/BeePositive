package com.example.android.bee;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ListAdapter2 extends RecyclerView.Adapter {
  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_blank, viewGroup, false);
    return new ListViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    ((ListViewHolder) viewHolder).bindView(i);
  }

  @Override
  public int getItemCount() {
    return 6;
  }

  private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mTextView;

    public ListViewHolder(View itemView) {
      super(itemView);
      mTextView = (TextView) itemView.findViewById(R.id.question_blank);
      itemView.setOnClickListener(this);
    }

    public void bindView(int position) {
      Context context = App.getContext();
      String str = "";
      if(position == 0) {
        str = context.getString(R.string.question_16);
      } else if( position == 1) {
        str = context.getString(R.string.question_17);
      } else if( position == 2) {
        str = context.getString(R.string.question_18);
      } else if( position == 3) {
        str = context.getString(R.string.question_19);
      } else if( position == 4) {
        str = context.getString(R.string.question_20);
      } else if( position == 5) {
        str = context.getString(R.string.question_21);
      }
      mTextView.setText(str);
    }

    public void onClick(View view) { }
  }
}

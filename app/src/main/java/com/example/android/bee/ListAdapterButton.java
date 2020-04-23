package com.example.android.bee;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ListAdapterButton extends RecyclerView.Adapter {
  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_submit, viewGroup, false);
    return new ListViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    ((ListViewHolder) viewHolder).bindView(i);
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

    public void onClick(View view) { }
  }
}

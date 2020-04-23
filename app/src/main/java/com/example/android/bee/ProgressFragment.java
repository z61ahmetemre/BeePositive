package com.example.android.bee;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.mvdw.recyclerviewmergeadapter.adapter.RecyclerViewMergeAdapter;

public class ProgressFragment extends Fragment {
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.progress_fragment, container, false);

    /*RecyclerView recyclerView = view.findViewById(R.id.questions_list);

    RecyclerViewMergeAdapter mergeAdapter = new RecyclerViewMergeAdapter();

    ListAdapter listAdapter = new ListAdapter();
    //ListAdapter2 listAdapter2 = new ListAdapter2();
    //ListAdapterButton listAdapterButton = new ListAdapterButton();

    mergeAdapter.addAdapter(listAdapter);
    //mergeAdapter.addAdapter(listAdapter2);
    //mergeAdapter.addAdapter(listAdapterButton);

    recyclerView.setAdapter(mergeAdapter);

    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);

  */
    return view;
  }

  @Override
  public void onDestroy() {
    super.onDestroy();

  }
}
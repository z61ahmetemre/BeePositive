package com.example.android.bee;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.Bundle;

import me.mvdw.recyclerviewmergeadapter.adapter.RecyclerViewMergeAdapter;

public class FoodFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.food_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_foods);
        RecyclerViewMergeAdapter mergeAdapter = new RecyclerViewMergeAdapter();
        MyRecyclerFoodAdapter foodAdapter = new MyRecyclerFoodAdapter();
        mergeAdapter.addAdapter(foodAdapter);
        recyclerView.setAdapter(mergeAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

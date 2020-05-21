package com.example.android.bee;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;

public class TabAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public TabAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CreateFragment fragment = new CreateFragment();
                return fragment;
            case 1:
                ActivityTabFragment fragment1 = new ActivityTabFragment();
                return fragment1;
            case 2:
                FeelingsFragment fragment2 = new FeelingsFragment();
                return fragment2;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}

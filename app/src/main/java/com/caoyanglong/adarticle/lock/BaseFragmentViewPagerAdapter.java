package com.caoyanglong.adarticle.lock;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class BaseFragmentViewPagerAdapter extends FragmentPagerAdapter {
    public BaseFragmentViewPagerAdapter(FragmentManager fm, List<Fragment> dataSourceList) {
        super(fm);
        this.dataSourceList = dataSourceList;
    }

    private List<Fragment> dataSourceList = new ArrayList<Fragment>();

    @Override
    public Fragment getItem(int arg0) {
        return dataSourceList.get(arg0);
    }

    @Override
    public int getCount() {
        return dataSourceList.size();
    }
} 
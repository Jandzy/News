package com.jandzy.news.adapter.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jandzy.news.fragment.HomeFragment;

/**
 * Created by jrazy on 2016/11/1.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {

    String[] tabs;


    public MyViewPagerAdapter(FragmentManager fm,String[] tabs) {
        super(fm);
        this.tabs  = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("typeid",position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}

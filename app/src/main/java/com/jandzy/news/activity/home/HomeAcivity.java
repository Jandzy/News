package com.jandzy.news.activity.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.jandzy.news.R;
import com.jandzy.news.adapter.home.MyViewPagerAdapter;
import com.jandzy.news.utils.DateUtils;

/**
 * 主页
 */
public class HomeAcivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TabLayout tablayout = (TabLayout) findViewById(R.id.tablayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        for (String tab : DateUtils.tabs) {
            tablayout.addTab(tablayout.newTab().setText(tab));
        }

        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(),DateUtils.tabs));
        viewPager.setOffscreenPageLimit(2);

        tablayout.setupWithViewPager(viewPager);

        for (int i=0;i<DateUtils.tabs.length;i++) {
            tablayout.getTabAt(i).setText(DateUtils.tabs[i]);
        }

    }
}

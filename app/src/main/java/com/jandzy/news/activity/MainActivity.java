package com.jandzy.news.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.jandzy.news.R;
import com.jandzy.news.activity.about.AboutActivity;
import com.jandzy.news.activity.blogs.BlogActivity;
import com.jandzy.news.activity.home.HomeAcivity;
import com.jandzy.news.activity.jokes.JokeActivity;

public class MainActivity  extends TabActivity implements TabHost.OnTabChangeListener {

    private TabHost mTabHost;
    private TabWidget tabWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabHost = getTabHost();
        tabWidget = mTabHost.getTabWidget();

        mTabHost.addTab(mTabHost.newTabSpec("news" ).setIndicator("首页").setContent(new Intent(this, HomeAcivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("jokes").setIndicator("欢乐").setContent(new Intent(this, JokeActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("blogs").setIndicator("博客").setContent(new Intent(this, BlogActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("about").setIndicator("关于").setContent(new Intent(this, AboutActivity.class)));

        for (int i = 0; i < tabWidget.getChildCount(); i++) {
            /**
             * 此方法是为了去掉系统默认的色白的底角
             */
            mTabHost.setPadding(mTabHost.getPaddingLeft(), mTabHost.getPaddingTop(), mTabHost.getPaddingRight(), mTabHost.getPaddingBottom() - 2);
        }

        mTabHost.setCurrentTab(0);

        updateColor(mTabHost);
        mTabHost.setOnTabChangedListener(this);
    }

    private void updateColor(TabHost tabHost) {
        for(int i=0;i<tabWidget.getTabCount();i++){
            TextView textView = (TextView) tabWidget.getChildAt(i).findViewById(android.R.id.title);

            if(tabHost.getCurrentTab()==i){//选中
                textView.setTextColor(this.getResources().getColorStateList(R.color.red));
            }else{
                textView.setTextColor(this.getResources().getColorStateList(R.color.blank));
            }
        }
    }

    @Override
    public void onTabChanged(String tabId) {
        mTabHost.setCurrentTabByTag(tabId);
        updateColor(mTabHost);
    }
}

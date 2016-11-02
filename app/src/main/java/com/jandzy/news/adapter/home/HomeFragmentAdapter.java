package com.jandzy.news.adapter.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jandzy.news.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jrazy on 2016/11/2.
 */
public class HomeFragmentAdapter extends BaseAdapter {

    private List<NewsModel.ResultEntity.DataEntity> models;
    private Context context;

    public HomeFragmentAdapter(Context context, List<NewsModel.ResultEntity.DataEntity> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public NewsModel.ResultEntity.DataEntity getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

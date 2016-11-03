package com.jandzy.news.adapter.joke;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jandzy.news.R;
import com.jandzy.news.model.JokesModel;

import java.util.List;

/**
 * Created by jrazy on 2016/11/3.
 */
public class JokeAdapter extends BaseAdapter {

    private List<JokesModel.ResultEntity.DataEntity> list;
    private Context context;

    public JokeAdapter(Context context,List<JokesModel.ResultEntity.DataEntity> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public JokesModel.ResultEntity.DataEntity getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_joke,null);
            viewHolder.textContent = (TextView) convertView.findViewById(R.id.text_content);
            viewHolder.imgShare = (ImageView) convertView.findViewById(R.id.img_share);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textContent.setText(getItem(position).getContent());

        return convertView;
    }

    static class ViewHolder{
        TextView textContent;
        ImageView imgShare;
    }
}

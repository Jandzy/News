package com.jandzy.news.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jandzy.news.R;
import com.jandzy.news.model.NewsModel;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jrazy on 2016/11/2.
 */
public class HomeFragmentAdapter extends BaseAdapter {

    private List<NewsModel.ResultEntity.DataEntity> models;
    private Context context;
    private ImageLoaderConfiguration config;

    public HomeFragmentAdapter(Context context, List<NewsModel.ResultEntity.DataEntity> models) {
        this.context = context;
        this.models = models;
        config = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .build();
        ImageLoader.getInstance().init(config);
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

        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_home_fragment,null);
            viewHolder.textTitle = (TextView) convertView.findViewById(R.id.text_title);
            viewHolder.textAuthor = (TextView) convertView.findViewById(R.id.text_author);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_img);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textTitle.setText(getItem(position).getTitle());
        viewHolder.textAuthor.setText(getItem(position).getAuthor_name()+"    "+getItem(position).getDate());
        viewHolder.imageView.setTag(getItem(position).getThumbnail_pic_s());
        ImageLoader.getInstance().displayImage(getItem(position).getThumbnail_pic_s(),viewHolder.imageView);

        return convertView;
    }

    static class ViewHolder{
        TextView textTitle,textAuthor;
        ImageView imageView;
    }
}

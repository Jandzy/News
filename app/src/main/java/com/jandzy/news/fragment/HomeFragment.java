package com.jandzy.news.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.jandzy.news.R;
import com.jandzy.news.activity.home.NewsDetailActivity;
import com.jandzy.news.adapter.home.HomeFragmentAdapter;
import com.jandzy.news.http.NewsService;
import com.jandzy.news.model.NewsModel;
import com.jandzy.news.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jrazy on 2016/11/2.
 */
public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener,
        AbsListView.OnScrollListener{

    private int typeid;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView lvContent;
    private List<NewsModel.ResultEntity.DataEntity> models = new ArrayList<>();
    private HomeFragmentAdapter homeFragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        savedInstanceState = getArguments();
        typeid = savedInstanceState.getInt("typeid");
        View view  = inflater.inflate(R.layout.fragment_home,null);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe);
        lvContent = (ListView)view.findViewById(R.id.lv_content);

        homeFragmentAdapter = new HomeFragmentAdapter(this.getActivity(),models);
        lvContent.setAdapter(homeFragmentAdapter);

        swipeRefreshLayout.setOnRefreshListener(this);
        lvContent.setOnScrollListener(this);

        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                intent.putExtra("url",models.get(i).getUrl());
                startActivity(intent);
            }
        });

        refresh();
    }

    @Override
    public void onRefresh() {
        refresh();
    }

    private void refresh() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DateUtils.BASE_UI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsService newsService = retrofit.create(NewsService.class);

        Call<NewsModel> call = newsService.getNewsList("467765e3bd3c2e78f1c601216a66a831",DateUtils.TABS_EN[typeid]);
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                swipeRefreshLayout.setRefreshing(false);

                if(response.isSuccessful()&&response.body().getError_code()==0){
                    models.clear();
                    models.addAll(response.body().getResult().getData());
                    homeFragmentAdapter.notifyDataSetChanged();
                    Log.e("error",response.body().getReason()+"");
                }else{
                    Log.e("error",response.body().getError_code()+"");
                }
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                Log.e("error",t.getMessage());
            }
        });
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}

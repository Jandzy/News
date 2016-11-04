package com.jandzy.news.activity.jokes;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.jandzy.news.R;
import com.jandzy.news.adapter.joke.JokeAdapter;
import com.jandzy.news.http.NewsService;
import com.jandzy.news.model.JokesModel;
import com.jandzy.news.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jrazy on 2016/11/1.
 */
public class JokeActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener,AbsListView.OnScrollListener
                                ,Toolbar.OnMenuItemClickListener{

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView lvContent;
    private int page;
    private int pagesize;
    private List<JokesModel.ResultEntity.DataEntity> jokesModels = new ArrayList<>();
    private JokeAdapter mJokeAdapter;
    private int getLastVisiblePosition=0,lastVisiblePositionY=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setTitle("欢乐");
        setSupportActionBar(toolbar);
//        toolbar.setOnMenuItemClickListener(this);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        lvContent = (ListView) findViewById(R.id.lv_content);

        page = 1;
        pagesize = 6;

        mJokeAdapter = new JokeAdapter(this,jokesModels);
        lvContent.setAdapter(mJokeAdapter);

        swipeRefreshLayout.setOnRefreshListener(this);
        lvContent.setOnScrollListener(this);

        refresh(false);
    }


    @Override
    public void onRefresh() {
        refresh(false);
    }

    private void refresh(final boolean isload) {
        if(isload){
            page++;
        }else{
            page = 1;
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DateUtils.BASE_JOKES)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsService newsService = retrofit.create(NewsService.class);

        Call<JokesModel> call = newsService.getJokesList(DateUtils.JOKE_KEY,page,pagesize);
        call.enqueue(new Callback<JokesModel>() {
            @Override
            public void onResponse(Call<JokesModel> call, Response<JokesModel> response) {
                swipeRefreshLayout.setRefreshing(false);
                if(response.isSuccessful()){
                    if(response.body().getError_code()==0){
                        if(!isload){
                            jokesModels.clear();
                        }
                        jokesModels.addAll(response.body().getResult().getData());
                        mJokeAdapter.notifyDataSetChanged();
                    }else{
                        Toast.makeText(JokeActivity.this, response.body().getReason(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<JokesModel> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(JokeActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState){
            case SCROLL_STATE_IDLE:
//                isStop = true;

                if (view.getLastVisiblePosition() == (view.getCount() - 1)) {
                    View v=(View) view.getChildAt(view.getChildCount()-1);
                    int[] location = new  int[2] ;
                    v.getLocationOnScreen(location);//获取在整个屏幕内的绝对坐标
                    int y=location [1];
                    Log.e("x"+location[0],"y"+location[1]);
                    if (view.getLastVisiblePosition()!=getLastVisiblePosition
                            && lastVisiblePositionY!=y)//第一次拖至底部
                    {
                        Toast.makeText(view.getContext(), "再次拖至底部，即可翻页",Toast.LENGTH_SHORT).show();
                        getLastVisiblePosition=view.getLastVisiblePosition();
                        lastVisiblePositionY=y;
                        return;
                    }
                    else if (view.getLastVisiblePosition()==getLastVisiblePosition
                            && lastVisiblePositionY==y)//第二次拖至底部
                    {
                        refresh(true);
                    }
                }
                //未滚动到底部，第二次拖至底部都初始化
                getLastVisiblePosition=0;
                lastVisiblePositionY=0;
                break;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_joke,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String s = "";
        switch (item.getItemId()) {
            case R.id.itme1:
                s = "itme1";
                break;
            case R.id.itme2:
                s= "item2";
                break;
            case R.id.itme3:
                s= "itme3";
                break;
        }
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
       /* String s = "";
        switch (item.getItemId()) {
            case R.id.itme1:
                s = "itme1";
                break;
            case R.id.itme2:
                s= "item2";
                break;
            case R.id.itme3:
                s= "itme3";
                break;
        }
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();*/
        return false;
    }
}

package com.chenliuliu.swiptoload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnRefreshListener, OnLoadMoreListener {
    private SwipeToLoadLayout swipeToLoadLayout;
    private ListView listView;
    private TestAdapter mAdapter;
    private ArrayList<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new TestAdapter(this);
        swipeToLoadLayout = (SwipeToLoadLayout) findViewById(R.id.swipeToLoadLayout);
        listView = (ListView) findViewById(R.id.swipe_target);
        mAdapter.setList(mList);
        listView.setAdapter(mAdapter);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
    }


    @Override
    public void onLoadMore() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mList.clear();
                mList.add("33424");
                mList.add("23424");
                mAdapter.setList(mList);
                swipeToLoadLayout.setLoadingMore(false);
            }
        }, 1000);
    }

    @Override
    public void onRefresh() {
        swipeToLoadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mList.add("33424");
                mList.add("23424");
                mAdapter.setList(mList);

                swipeToLoadLayout.setRefreshing(false);
            }
        }, 1000);

    }
}

package com.printfstudio.current.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.printfstudio.current.R;
import com.printfstudio.current.views.BaseActivity;
import com.printfstudio.current.views.TimelineAdapter;
import com.printfstudio.current.views.Timeline_ItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DTLuc on 2015/7/17.
 */
public class Timeline extends BaseActivity {


    private RecyclerView recyclerView;
    private List<Timeline_ItemBean> itemBeanList;
    private TimelineAdapter timelineAdapter;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.timeline_recyclerview);
        this.initViews();
        this.setStatusBarColor(R.color.translucent);
        initViews();
        initDatas();
        recyclerView.setAdapter(timelineAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initViews(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }

    private void initDatas(){
        itemBeanList = new ArrayList<>();
        for(int i = 0;i < 20;i++){
            itemBeanList.add(new Timeline_ItemBean("Time"+i,R.drawable.ic_launcher,R.drawable.ic_launcher,"Contents"+i));
        }
        timelineAdapter = new TimelineAdapter(this,itemBeanList);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
    }

}
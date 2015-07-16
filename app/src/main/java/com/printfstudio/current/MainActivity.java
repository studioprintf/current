package com.printfstudio.current;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.printfstudio.current.views.BaseActivity;
import com.printfstudio.current.views.FreeDiaryLayout;
import com.printfstudio.current.views.TimelineAdapter;
import com.printfstudio.current.views.Timeline_ItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 不用这个Activity，用来测试功能什么的都行，提交的时候最好不要勾选这个文件
 * test
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Timeline_ItemBean> itemBeanList;
    private TimelineAdapter timelineAdapter;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_recyclerview);
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
            itemBeanList.add(new Timeline_ItemBean("Time"+i,R.drawable.ic_launcher,R.drawable.ic_launcher,"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+i));
        }
        timelineAdapter = new TimelineAdapter(this,itemBeanList);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
    }

}
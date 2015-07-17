package com.printfstudio.current.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.printfstudio.current.R;
import com.printfstudio.current.views.FreeDiaryLayout;


public class CreateDiaryActivity extends BaseActivity {
    private FreeDiaryLayout freeDiaryLayout;
    private EditText etTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_create_diary);
        this.initActivity();
        this.setStatusBarColor(R.color.translucent);
        initViews();
        initData();
    }

    private void initViews() {
        freeDiaryLayout = (FreeDiaryLayout) findViewById(R.id.freeDiary);
        etTitle = (EditText) findViewById(R.id.edit_title);
    }

    private void initData() {
    }

}

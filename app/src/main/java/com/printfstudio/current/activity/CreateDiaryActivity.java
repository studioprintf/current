package com.printfstudio.current.activity;

import android.os.Bundle;

import com.printfstudio.current.R;
import com.printfstudio.current.views.BaseActivity;


public class CreateDiaryActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_create_diary);
        this.initActivity();
        this.setStatusBarColor(R.color.translucent);
    }
}

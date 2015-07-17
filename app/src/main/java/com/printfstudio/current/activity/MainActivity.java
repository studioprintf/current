package com.printfstudio.current.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import com.printfstudio.current.R;
import com.printfstudio.current.views.BaseActivity;

/**
 * 程序的入口activity
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.initActivity();
        initViews();
        initData();
    }


    private void initViews() {
        navigationView = (NavigationView) this.findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initData() {
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.nav_myPage:
                break;
            case R.id.nav_home:
                break;
            case R.id.nav_newDiary:
                startActivity(new Intent(MainActivity.this, CreateDiaryActivity.class));
                break;
        }
        return true;
    }
}






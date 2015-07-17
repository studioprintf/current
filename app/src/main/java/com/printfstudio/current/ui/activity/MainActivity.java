package com.printfstudio.current.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.printfstudio.current.R;
import com.printfstudio.current.ui.fragment.MyPageFragment;

/**
 * 程序的入口Activity
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private MyPageFragment myPageFragment = new MyPageFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.initActivity();
        initViews();
        initData();
        changeToMyPage();
    }


    private void initViews() {
        drawerLayout = (DrawerLayout) this.findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) this.findViewById(R.id.navigation);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initData() {
    }

    private void changeToMyPage() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_frame, myPageFragment);
        transaction.commit();
    }

    private void changeToHallPage() {

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_myPage:
                changeToMyPage();
                item.setChecked(true);
                break;
            case R.id.nav_home:
                changeToHallPage();
                item.setChecked(true);
                break;
            case R.id.nav_newDiary:
                startActivity(new Intent(MainActivity.this, CreateDiaryActivity.class));
                break;
        }
        drawerLayout.closeDrawers();
        return false;
    }
}






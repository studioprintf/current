package com.printfstudio.current.ui.activity;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.printfstudio.current.R;
import com.printfstudio.current.tools.Tools;

/**
 * 此Activity应用作本工程的主Activity
 * 此Activity做了三件事
 * 1.隐藏默认的SupportActionbar
 * 2.设置StatusBar颜色
 * 你可以调用setStatusBarColor(int id);来随时设置StatusBar颜色
 */
public class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setStatusBarColor(R.color.colorPrimaryDark);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setStatusBarColor(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(id));
        }
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
        this.setSupportActionBar(toolbar);
    }

}

package com.printfstudio.current.views;


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
 * 2.添加xml中的toolbar
 * 3.设置StatusBar底层View的颜色和高度
 * 注意
 * 使用本Activity时
 * 设置的xml布局文件应include @Layout/base_activity_component_top
 * 并在setContentView();后调用initActivity();
 */
public class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private View topView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void initActivity() {
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            topView = findViewById(R.id.top);
            topView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Tools.getStatusBarHeight(this)));
            topView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    public void setStatusBarColor(int id) {
        topView.setBackgroundColor(getResources().getColor(id));
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public View getTopView() {
        return topView;
    }

    public void setTopView(View topView) {
        this.topView = topView;
    }
}

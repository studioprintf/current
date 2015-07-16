package com.printfstudio.current;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.printfstudio.current.views.BaseActivity;
import com.printfstudio.current.views.FreeDiaryLayout;

/**
 * 不用这个Activity，用来测试功能什么的都行，提交的时候最好不要勾选这个文件
 */
public class MainActivity extends BaseActivity {
    FreeDiaryLayout freeDiaryLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        freeDiaryLayout = (FreeDiaryLayout) findViewById(R.id.test_free);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add_img) {
            freeDiaryLayout.addImageArea();
        } else if (id == R.id.action_add_diary) {
            Toast.makeText(getApplicationContext(), freeDiaryLayout.makeDiary().getContent(), Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}

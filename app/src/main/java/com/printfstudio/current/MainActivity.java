package com.printfstudio.current;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.printfstudio.current.views.FreeDiaryLayout;
import com.printfstudio.current.views.FreeDiaryView;

/**
 * 不用这个Activity，用来测试功能什么的都行，提交的时候最好不要勾选这个文件
 */
public class MainActivity extends AppCompatActivity {
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
        if (id == R.id.action_add_text) {
            freeDiaryLayout.addTextArea();
            Toast.makeText(getApplicationContext(), freeDiaryLayout.getActiveEditText().getText(), Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_add_img) {
            freeDiaryLayout.addImageArea();
        }
        return super.onOptionsItemSelected(item);
    }
}

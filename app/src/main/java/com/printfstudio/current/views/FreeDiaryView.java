package com.printfstudio.current.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * 实现自由布局的日记视图
 * 可实现的功能
 * 1.动态在任何位置添加功能模块视图（文字，图片，声音）
 * 2.按照模块顺序生成Diary实例
 */
public class FreeDiaryView extends RecyclerView {


    public FreeDiaryView(Context context) {
        super(context);
    }

    public FreeDiaryView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FreeDiaryView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}

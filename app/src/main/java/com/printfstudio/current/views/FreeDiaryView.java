package com.printfstudio.current.views;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.printfstudio.current.R;
import com.printfstudio.current.bean.Diary;
import com.printfstudio.current.common.Finals;
import com.printfstudio.current.tools.DiaryData;

import java.util.ArrayList;
import java.util.List;

/**
 * 此类已经弃用
 * 实现自由布局的日记视图
 * 可实现的功能
 * 1.动态在任何位置添加功能模块视图（文字，图片，声音）
 * 2.按照模块顺序生成Diary实例
 */
public class FreeDiaryView extends RecyclerView {
    private List<DiaryData> datas;

    private Diary diary;

    private FreeDiaryAdapter editAdapter;

    public FreeDiaryView(Context context) {
        super(context);
        init();
    }

    public FreeDiaryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FreeDiaryView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    private void init() {
        this.setLayoutManager(new LinearLayoutManager(getContext(), VERTICAL, false));
    }

    public Diary makeDiary() {
        /**
         * 编辑模式下
         * 生成Diary实例的函数
         */

        return null;
    }

    public void initEditMode() {
        datas = new ArrayList<>();
        datas.add(new DiaryData(Finals.DIARY_COMPONENT_TYPE_TEXT, "测试1"));
        datas.add(new DiaryData(Finals.DIARY_COMPONENT_TYPE_TEXT, "测试2"));
        datas.add(new DiaryData(Finals.DIARY_COMPONENT_TYPE_TEXT, "测试3"));
        datas.add(new DiaryData(Finals.DIARY_COMPONENT_TYPE_TEXT, "测试4"));
        datas.add(new DiaryData(Finals.DIARY_COMPONENT_TYPE_TEXT, "测试5"));
        datas.add(new DiaryData(Finals.DIARY_COMPONENT_TYPE_TEXT, "测试6"));
        datas.add(new DiaryData(Finals.DIARY_COMPONENT_TYPE_TEXT, "测试7"));
        datas.add(new DiaryData(Finals.DIARY_COMPONENT_TYPE_TEXT, "测试8"));
        datas.add(new DiaryData(Finals.DIARY_COMPONENT_TYPE_IMAGE, "测试9"));
        datas.add(new DiaryData(Finals.DIARY_COMPONENT_TYPE_TEXT, "测试0"));
        editAdapter = new FreeDiaryAdapter();
        this.setAdapter(editAdapter);
    }


    public class FreeDiaryAdapter extends RecyclerView.Adapter<FreeViewHolder> {


        @Override
        public int getItemViewType(int position) {
            return datas.get(position).getType();
        }

        @Override
        public FreeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = null;
            switch (viewType) {
                case Finals.DIARY_COMPONENT_TYPE_TEXT:
                    itemView = LayoutInflater.from(getContext()).inflate(R.layout.component_free_text_edit, parent, false);
                    break;
                case Finals.DIARY_COMPONENT_TYPE_IMAGE:
                    itemView = LayoutInflater.from(getContext()).inflate(R.layout.component_free_image_edit, parent, false);
                    break;
                case Finals.DIARY_COMPONENT_TYPE_VOICE:
                    break;
            }
            return new FreeViewHolder(itemView, viewType);
        }

        @Override
        public void onBindViewHolder(FreeViewHolder holder, int position) {
            switch (getItemViewType(position)) {
                case Finals.DIARY_COMPONENT_TYPE_TEXT:
                    holder.editText.setText(datas.get(position).getContent());
                    break;
                case Finals.DIARY_COMPONENT_TYPE_IMAGE:
                    holder.imageView.setImageResource(R.mipmap.ic_launcher);
                    break;
                case Finals.DIARY_COMPONENT_TYPE_VOICE:
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }
    }


    public class FreeViewHolder extends ViewHolder {

        private int type = Finals.DIARY_COMPONENT_TYPE_TEXT;

        private View itemView;
        private EditText editText;
        private ImageView imageView;

        public FreeViewHolder(View itemView, int type) {
            super(itemView);
            this.type = type;
            this.itemView = itemView;
            initViews();
        }

        private void initViews() {
            switch (type) {
                case Finals.DIARY_COMPONENT_TYPE_TEXT:
                    editText = (EditText) itemView.findViewById(R.id.diary_edit_text);
                    break;
                case Finals.DIARY_COMPONENT_TYPE_IMAGE:
                    imageView = (ImageView) itemView.findViewById(R.id.diary_edit_image);

                    break;
                case Finals.DIARY_COMPONENT_TYPE_VOICE:
                    break;
            }
        }
    }
}



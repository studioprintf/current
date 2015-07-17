package com.printfstudio.current.views;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.printfstudio.current.R;
import com.printfstudio.current.bean.Diary;
import com.printfstudio.current.common.Finals;

import java.util.ArrayList;
import java.util.List;

/**
 * 此类实现了编辑日记和显示日记的自由内容布局
 * 支持文字（编辑/显示），图片（编辑/显示），声音（录制/显示）控件的自由添加
 */

public class FreeDiaryLayout extends LinearLayout {


    private List<EditViewHolder> holders = new ArrayList<>();
    private EditViewHolder activeHolder;
    private final OnTouchListener changeFocusListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            activeHolder = (EditViewHolder) v.getTag();
            return false;
        }
    };

    public FreeDiaryLayout(Context context) {
        super(context);
        init();
    }

    public FreeDiaryLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FreeDiaryLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FreeDiaryLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        activeHolder = addTextArea();
        activeHolder.editText.setHint(R.string.hint_content);
    }

    public Diary makeDiary() {
        Diary diary = new Diary();
        String content = "";
        for (int i = 0; i < holders.size(); i++) {
            EditViewHolder holder = holders.get(i);
            switch (holder.getType()) {
                case Finals.DIARY_COMPONENT_TYPE_TEXT:
                    content = content + holder.editText.getText().toString();
                    break;
                case Finals.DIARY_COMPONENT_TYPE_IMAGE:
                    content = content + Finals.DIARY_COMPONENT_IMAGE_SYMBOL;
                    break;
                case Finals.DIARY_COMPONENT_TYPE_VOICE:
                    content = content + Finals.DIARY_COMPONENT_VOICE_SYMBOL;
                    break;
            }
        }
        diary.setContent(content);
        return diary;
    }

    public EditViewHolder addTextArea() {
        View textArea = LayoutInflater.from(getContext()).inflate(R.layout.component_free_text_edit, this, false);
        EditViewHolder holder = new EditViewHolder(textArea, Finals.DIARY_COMPONENT_TYPE_TEXT);
        holders.add(holder);
        holder.editText.setTag(holder);
        holder.editText.setOnTouchListener(changeFocusListener);
        refreshView();
        return holder;
    }

    public EditViewHolder addTextArea(int position) {
        View textArea = LayoutInflater.from(getContext()).inflate(R.layout.component_free_text_edit, this, false);
        EditViewHolder holder = new EditViewHolder(textArea, Finals.DIARY_COMPONENT_TYPE_TEXT);
        holders.add(position, holder);
        holder.editText.setTag(holder);
        holder.editText.setOnTouchListener(changeFocusListener);
        refreshView();
        return holder;
    }

    public void addImageArea() {
        int focusIndex = holders.indexOf(activeHolder);
        EditText focusEditText = activeHolder.editText;
        int location = focusEditText.getSelectionStart();
        String origin = focusEditText.getText().toString();
        focusEditText.setText(origin.substring(0, location));
        addImageArea(focusIndex + 1);
        addTextArea(focusIndex + 2).editText.setText(origin.substring(location));
    }

    public void addImageArea(int position) {
        View imageArea = LayoutInflater.from(getContext()).inflate(R.layout.component_free_image_edit, this, false);
        EditViewHolder holder = new EditViewHolder(imageArea, Finals.DIARY_COMPONENT_TYPE_IMAGE);
        holders.add(position, holder);
        holder.imageView.setImageResource(R.mipmap.ic_launcher);
        refreshView();
    }

    public void refreshView() {
        this.removeAllViews();
        for (int i = 0; i < holders.size(); i++) {
            this.addView(holders.get(i).itemView);
        }
    }

    public EditViewHolder getActiveHolder() {
        return activeHolder;
    }

    public void setActiveHolder(EditViewHolder activeHolder) {
        this.activeHolder = activeHolder;
    }

    public List<EditViewHolder> getHolders() {
        return holders;
    }

    public void setHolders(List<EditViewHolder> holders) {
        this.holders = holders;
    }

    public class EditViewHolder {
        private View itemView;
        private int type = Finals.DIARY_COMPONENT_TYPE_TEXT;

        private EditText editText;
        private ImageView imageView;

        public EditViewHolder(View itemView, int type) {
            this.itemView = itemView;
            this.type = type;
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }


    }

}

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
import com.printfstudio.current.common.Finals;

import java.util.ArrayList;
import java.util.List;

public class FreeDiaryLayout extends LinearLayout {
    private List<EditViewHolder> holders = new ArrayList<>();
    private EditText activeEditText;
    private final OnTouchListener changeFocusListener = new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            activeEditText = (EditText) v;
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
        addTextArea(0);
        activeEditText = holders.get(0).editText;
    }

    public void addTextArea() {
        View textArea = LayoutInflater.from(getContext()).inflate(R.layout.component_free_text_edit, this, false);
        EditViewHolder holder = new EditViewHolder(textArea, Finals.DIARY_COMPONENT_TYPE_TEXT);
        holders.add(holder);
        holder.editText.setOnTouchListener(changeFocusListener);
        refreshView();
    }

    public void addTextArea(int position) {
        View textArea = LayoutInflater.from(getContext()).inflate(R.layout.component_free_text_edit, this, false);
        EditViewHolder holder = new EditViewHolder(textArea, Finals.DIARY_COMPONENT_TYPE_TEXT);
        holders.add(position, holder);
        holder.editText.setOnTouchListener(changeFocusListener);
        refreshView();
    }

    public void addImageArea() {
        View imageArea = LayoutInflater.from(getContext()).inflate(R.layout.component_free_image_edit, this, false);
        EditViewHolder holder = new EditViewHolder(imageArea, Finals.DIARY_COMPONENT_TYPE_IMAGE);
        holders.add(holder);
        holder.imageView.setImageResource(R.mipmap.ic_launcher);
        refreshView();
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

    public EditText getActiveEditText() {
        return activeEditText;
    }

    public void setActiveEditText(EditText activeEditText) {
        this.activeEditText = activeEditText;
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
    }

}

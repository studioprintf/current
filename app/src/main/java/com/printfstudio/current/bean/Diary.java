package com.printfstudio.current.bean;

import com.printfstudio.current.server.Obj;

/**
 * 封装日记的信息类
 * 待完善
 */
public class Diary extends Obj {

    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

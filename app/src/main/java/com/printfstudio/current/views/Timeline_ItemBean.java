package com.printfstudio.current.views;

/**
 * Created by DTLuc on 2015/7/16.
 * 时间轴数据
 * v0.1
 */
public class Timeline_ItemBean {
    private String time;
    private int StyleResid;
    private int ImageResid;
    private String Contents;

    public Timeline_ItemBean(String time, int styleResid, int imageResid, String contents) {
        this.time = time;
        StyleResid = styleResid;
        ImageResid = imageResid;
        Contents = contents;
    }

    public String getTime() {
        return time;
    }

    public int getStyleResid() {
        return StyleResid;
    }

    public int getImageResid() {
        return ImageResid;
    }

    public String getContents() {
        return Contents;
    }
}
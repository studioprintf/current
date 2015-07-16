package com.printfstudio.current.tools;

import android.app.Activity;
import android.content.Context;

import java.lang.reflect.Field;

public class Tools {
    /**
     * 用这个函数来进行单位换算
     *
     * @param context 当前的上下文文件
     * @param dpValue 需要转换的dp单位
     * @return 转换后的px单位
     */
    public static int Dp2Px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 用这个函数来得到顶栏高度
     *
     * @param activity 当前Activity上下文
     * @return 顶栏高度
     */
    private static int getStatusBarHeight(Activity activity) {
        Class<?> c;
        Object obj;
        Field field;
        int x;
        int statusBarHeight;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = activity.getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            statusBarHeight = -1;
        }
        return statusBarHeight;
    }
}

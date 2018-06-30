package com.goume.xuanfu.emoji;


public class CommonUtil {

    public static int dip2px(float dpValue) {
        float scale = APP.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

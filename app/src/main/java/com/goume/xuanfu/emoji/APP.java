package com.goume.xuanfu.emoji;

import android.app.Application;
import android.content.Context;

/**
 * @author luo
 * @package com.goume.xuanfu.emoji
 * @fileName APP
 * @data on 2018/6/30 8:45
 * @describe TODO
 */
public class APP extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        EmojiManager.init(context);
    }

    public static Context getContext() {
        return context;
    }
}

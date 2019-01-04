package com.green.hand;

import android.app.Application;
import android.content.Context;

import com.green.hand.library.EmojiManager;

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EmojiManager.init(this);
    }
}

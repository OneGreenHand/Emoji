package com.green.hand.library;

import android.content.res.Resources;

/**
 * @author OneGreenHand
 * @package com.green.hand.library
 * @fileName EmojiUtil
 * @data on 2019/1/3 17:17
 * @describe
 */
public class EmojiUtil {
    public static final int ROW = 3;
    public static final int COLUMN = 7;

    public static int getPageSize() {//得到总共需要有多少页
        return (int) Math.ceil((double) EmojiManager.getSize() / (ROW * COLUMN - 1));
    }

    public static int getOnePageSize() {//得到每一页要显示的数量
        return EmojiUtil.ROW * EmojiUtil.COLUMN - 1;
    }

    /**
     * Value of dp to value of px.
     *
     * @param dpValue The value of dp.
     * @return value of px
     */
    public static int dp2px(final float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * Value of px to value of dp.
     *
     * @param pxValue The value of px.
     * @return value of dp
     */
    public static int px2dp(final float pxValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

}

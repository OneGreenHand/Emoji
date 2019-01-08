package com.green.hand.library;

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
}

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
    public static int getPageSize() {
        return EmojiManager.getSize() / (ROW * COLUMN - 1);
    }
}

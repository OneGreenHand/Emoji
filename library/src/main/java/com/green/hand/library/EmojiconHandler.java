package com.green.hand.library;

import android.content.Context;
import android.text.Spannable;
import android.util.SparseIntArray;

public class EmojiconHandler {
    private EmojiconHandler() {
    }

    private static final SparseIntArray sEmojisMap = new SparseIntArray(1029);

    static {
        sEmojisMap.put(0x1f603, R.mipmap.u1f603);
        sEmojisMap.put(0x1f600, R.mipmap.u1f600);
        sEmojisMap.put(0x1f60a, R.mipmap.u1f60a);
        sEmojisMap.put(0x263a, R.mipmap.u263a);
        sEmojisMap.put(0x1f609, R.mipmap.u1f609);
        sEmojisMap.put(0x1f60d, R.mipmap.u1f60d);
        sEmojisMap.put(0x1f618, R.mipmap.u1f618);
        sEmojisMap.put(0x1f61a, R.mipmap.u1f61a);
        sEmojisMap.put(0x1f61c, R.mipmap.u1f61c);
        sEmojisMap.put(0x1f61d, R.mipmap.u1f61d);
        sEmojisMap.put(0x1f633, R.mipmap.u1f633);
        sEmojisMap.put(0x1f601, R.mipmap.u1f601);
        sEmojisMap.put(0x1f614, R.mipmap.u1f614);
        sEmojisMap.put(0x1f60c, R.mipmap.u1f60c);
        sEmojisMap.put(0x1ff12, R.mipmap.u1f12);
        sEmojisMap.put(0x1f61f, R.mipmap.u1f61f);
        sEmojisMap.put(0x1f61e, R.mipmap.u1f61e);
        sEmojisMap.put(0x1f623, R.mipmap.u1f623);
        sEmojisMap.put(0x1f622, R.mipmap.u1f622);
        sEmojisMap.put(0x1f602, R.mipmap.u1f602);
        sEmojisMap.put(0x1f62d, R.mipmap.u1f62d);
        sEmojisMap.put(0x1f62a, R.mipmap.u1f62a);
        sEmojisMap.put(0x1f630, R.mipmap.u1f630);
        sEmojisMap.put(0x1f605, R.mipmap.u1f605);
        sEmojisMap.put(0x1f613, R.mipmap.u1f613);
        sEmojisMap.put(0x1f62b, R.mipmap.u1f62b);
        sEmojisMap.put(0x1f629, R.mipmap.u1f629);
        sEmojisMap.put(0x1f628, R.mipmap.u1f628);
        sEmojisMap.put(0x1f631, R.mipmap.u1f631);
        sEmojisMap.put(0x1f621, R.mipmap.u1f621);
        sEmojisMap.put(0x1f624, R.mipmap.u1f624);
        sEmojisMap.put(0x1f616, R.mipmap.u1f616);
        sEmojisMap.put(0x1f606, R.mipmap.u1f606);
        sEmojisMap.put(0x1f60b, R.mipmap.u1f60b);
        sEmojisMap.put(0x1f637, R.mipmap.u1f637);
        sEmojisMap.put(0x1f60e, R.mipmap.u1f60e);
        sEmojisMap.put(0x1f634, R.mipmap.u1f634);
        sEmojisMap.put(0x1f632, R.mipmap.u1f632);
        sEmojisMap.put(0x1f62e, R.mipmap.u1f62e);
        sEmojisMap.put(0x1f608, R.mipmap.u1f608);
        sEmojisMap.put(0x1f47f, R.mipmap.u1f47f);
        sEmojisMap.put(0x1f62f, R.mipmap.u1f62f);
        sEmojisMap.put(0x1f62c, R.mipmap.u1f62c);
        sEmojisMap.put(0x1f615, R.mipmap.u1f615);
        sEmojisMap.put(0x1f635, R.mipmap.u1f635);
        sEmojisMap.put(0x1f636, R.mipmap.u1f636);
        sEmojisMap.put(0x1f607, R.mipmap.u1f607);
        sEmojisMap.put(0x1f60f, R.mipmap.u1f60f);
        sEmojisMap.put(0x1f611, R.mipmap.u1f611);
        sEmojisMap.put(0x1f648, R.mipmap.u1f648);
        sEmojisMap.put(0x1f649, R.mipmap.u1f649);
        sEmojisMap.put(0x1f64a, R.mipmap.u1f64a);
        sEmojisMap.put(0x1f47d, R.mipmap.u1f47d);
        sEmojisMap.put(0x1f4a9, R.mipmap.u1f4a9);
        sEmojisMap.put(0x2764, R.mipmap.u2764);
        sEmojisMap.put(0x1f494, R.mipmap.u1f494);
        sEmojisMap.put(0x1f525, R.mipmap.u1f525);
        sEmojisMap.put(0x1f4a2, R.mipmap.u1f4a2);
        sEmojisMap.put(0x1f4a4, R.mipmap.u1f4a4);
        sEmojisMap.put(0x1f6ab, R.mipmap.u1f6ab);
        sEmojisMap.put(0x2b50, R.mipmap.u2b50);
        sEmojisMap.put(0x26a1, R.mipmap.u26a1);
        sEmojisMap.put(0x1f319, R.mipmap.u1f319);
        sEmojisMap.put(0x2600, R.mipmap.u2600);
        sEmojisMap.put(0x26c5, R.mipmap.u26c5);
        sEmojisMap.put(0x2601, R.mipmap.u2601);
        sEmojisMap.put(0x2744, R.mipmap.u2744);
        sEmojisMap.put(0x2614, R.mipmap.u2614);
        sEmojisMap.put(0x26c4, R.mipmap.u26c4);
        sEmojisMap.put(0x1f44d, R.mipmap.u1f44d);
        sEmojisMap.put(0x1f44e, R.mipmap.u1f44e);
        sEmojisMap.put(0x1f44c, R.mipmap.u1f44c);
        sEmojisMap.put(0x1f44a, R.mipmap.u1f44a);
        sEmojisMap.put(0x270a, R.mipmap.u270a);
        sEmojisMap.put(0x270c, R.mipmap.u270c);
        sEmojisMap.put(0x270b, R.mipmap.u270b);
        sEmojisMap.put(0x1f64f, R.mipmap.u1f64f);
        sEmojisMap.put(0x261d, R.mipmap.u261d);
        sEmojisMap.put(0x1f44f, R.mipmap.u1f44f);
        sEmojisMap.put(0x1f91d, R.mipmap.u1f91d);
        sEmojisMap.put(0x1f4aa, R.mipmap.u1f4aa);
        sEmojisMap.put(0x1f46a, R.mipmap.u1f46a);
        sEmojisMap.put(0x1f46b, R.mipmap.u1f46b);
        sEmojisMap.put(0x1f47c, R.mipmap.u1f47c);
        sEmojisMap.put(0x1f434, R.mipmap.u1f434);
        sEmojisMap.put(0x1f436, R.mipmap.u1f436);
        sEmojisMap.put(0x1f437, R.mipmap.u1f437);
        sEmojisMap.put(0x1f47b, R.mipmap.u1f47b);
        sEmojisMap.put(0x1f339, R.mipmap.u1f339);
        sEmojisMap.put(0x1f33b, R.mipmap.u1f33b);
        sEmojisMap.put(0x1f332, R.mipmap.u1f332);
        sEmojisMap.put(0x1f384, R.mipmap.u1f384);
        sEmojisMap.put(0x1f381, R.mipmap.u1f381);
        sEmojisMap.put(0x1f389, R.mipmap.u1f389);
        sEmojisMap.put(0x1f4b0, R.mipmap.u1f4b0);
        sEmojisMap.put(0x1f382, R.mipmap.u1f382);
        sEmojisMap.put(0x1f356, R.mipmap.u1f356);
        sEmojisMap.put(0x1f35a, R.mipmap.u1f35a);
        sEmojisMap.put(0x1f366, R.mipmap.u1f366);
        sEmojisMap.put(0x1f36b, R.mipmap.u1f36b);
        sEmojisMap.put(0x1f349, R.mipmap.u1f349);
        sEmojisMap.put(0x1f377, R.mipmap.u1f377);
        sEmojisMap.put(0x1f37b, R.mipmap.u1f37b);
        sEmojisMap.put(0x2615, R.mipmap.u2615);
        sEmojisMap.put(0x1f3c0, R.mipmap.u1f3c0);
        sEmojisMap.put(0x26bd, R.mipmap.u26bd);
        sEmojisMap.put(0x1f3c2, R.mipmap.u1f3c2);
        sEmojisMap.put(0x1f6b2, R.mipmap.u1f6b2);
        sEmojisMap.put(0x1f3a4, R.mipmap.u1f3a4);
        sEmojisMap.put(0x1f3b5, R.mipmap.u1f3b5);
        sEmojisMap.put(0x1f3b2, R.mipmap.u1f3b2);
        sEmojisMap.put(0x1f004, R.mipmap.u1f004);
        sEmojisMap.put(0x1f451, R.mipmap.u1f451);
        sEmojisMap.put(0x1f484, R.mipmap.u1f484);
        sEmojisMap.put(0x1f48b, R.mipmap.u1f48b);
        sEmojisMap.put(0x1f48d, R.mipmap.u1f48d);
        sEmojisMap.put(0x1f4da, R.mipmap.u1f4da);
        sEmojisMap.put(0x1f393, R.mipmap.u1f393);
        sEmojisMap.put(0x270f, R.mipmap.u270f);
        sEmojisMap.put(0x1f3e1, R.mipmap.u1f3e1);
        sEmojisMap.put(0x1f6bf, R.mipmap.u1f6bf);
        sEmojisMap.put(0x1f4a1, R.mipmap.u1f4a1);
        sEmojisMap.put(0x1f4de, R.mipmap.u1f4de);
        sEmojisMap.put(0x1f4e2, R.mipmap.u1f4e2);
        sEmojisMap.put(0x1f556, R.mipmap.u1f556);
        sEmojisMap.put(0x23f0, R.mipmap.u23f0);
        sEmojisMap.put(0x23f3, R.mipmap.u23f3);
        sEmojisMap.put(0x1f4a3, R.mipmap.u1f4a3);
        sEmojisMap.put(0x1f52b, R.mipmap.u1f52b);
        sEmojisMap.put(0x1f48a, R.mipmap.u1f48a);
        sEmojisMap.put(0x1f680, R.mipmap.u1f680);
        sEmojisMap.put(0x1f30f, R.mipmap.u1f30f);
    }

    public static void addEmojis(Context context, Spannable text, int emojiSize, int emojiAlignment, int textSize, boolean useSystemDefault) {
        addEmojis(context, text, emojiSize, emojiAlignment, textSize, 0, -1, useSystemDefault);
    }

    public static void addEmojis(Context context, Spannable text, int emojiSize, int emojiAlignment, int textSize, int index, int length, boolean useSystemDefault) {
        if (useSystemDefault || text == null) {
            return;
        }
        int textLength = text.length();
        int textLengthToProcessMax = textLength - index;
        int textLengthToProcess = length < 0 || length >= textLengthToProcessMax ? textLength : (length + index);
        EmojiconSpan[] oldSpans = text.getSpans(0, textLength, EmojiconSpan.class);
        for (int i = 0; i < oldSpans.length; i++) {
            text.removeSpan(oldSpans[i]);
        }
        int skip;
        for (int i = index; i < textLengthToProcess; i += skip) {
            int icon = 0;
            int unicode = Character.codePointAt(text, i);
            skip = Character.charCount(unicode);
            if (unicode > 0xff) {
                icon = sEmojisMap.get(unicode);
            }
            if (icon > 0) {
                text.setSpan(new EmojiconSpan(context, icon, emojiSize, emojiAlignment, textSize), i, i + skip, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }
}

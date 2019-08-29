package com.green.hand.library;

import android.content.Context;
import android.text.Spannable;
import android.util.SparseIntArray;

public class EmojiconHandler {
    private EmojiconHandler() {
    }

    private static final SparseIntArray sEmojisMap = new SparseIntArray(1029);

    static {
        sEmojisMap.put(0x1f603, R.drawable.u1f603);
        sEmojisMap.put(0x1f600, R.drawable.u1f600);
        sEmojisMap.put(0x1f60a, R.drawable.u1f60a);
        sEmojisMap.put(0x263a, R.drawable.u263a);
        sEmojisMap.put(0x1f609, R.drawable.u1f609);
        sEmojisMap.put(0x1f60d, R.drawable.u1f60d);
        sEmojisMap.put(0x1f618, R.drawable.u1f618);
        sEmojisMap.put(0x1f61a, R.drawable.u1f61a);
        sEmojisMap.put(0x1f61c, R.drawable.u1f61c);
        sEmojisMap.put(0x1f61d, R.drawable.u1f61d);
        sEmojisMap.put(0x1f633, R.drawable.u1f633);
        sEmojisMap.put(0x1f601, R.drawable.u1f601);
        sEmojisMap.put(0x1f614, R.drawable.u1f614);
        sEmojisMap.put(0x1f60c, R.drawable.u1f60c);
        sEmojisMap.put(0x1ff12, R.drawable.u1f12);
        sEmojisMap.put(0x1f61f, R.drawable.u1f61f);
        sEmojisMap.put(0x1f61e, R.drawable.u1f61e);
        sEmojisMap.put(0x1f623, R.drawable.u1f623);
        sEmojisMap.put(0x1f622, R.drawable.u1f622);
        sEmojisMap.put(0x1f602, R.drawable.u1f602);
        sEmojisMap.put(0x1f62d, R.drawable.u1f62d);
        sEmojisMap.put(0x1f62a, R.drawable.u1f62a);
        sEmojisMap.put(0x1f630, R.drawable.u1f630);
        sEmojisMap.put(0x1f605, R.drawable.u1f605);
        sEmojisMap.put(0x1f613, R.drawable.u1f613);
        sEmojisMap.put(0x1f62b, R.drawable.u1f62b);
        sEmojisMap.put(0x1f629, R.drawable.u1f629);
        sEmojisMap.put(0x1f628, R.drawable.u1f628);
        sEmojisMap.put(0x1f631, R.drawable.u1f631);
        sEmojisMap.put(0x1f621, R.drawable.u1f621);
        sEmojisMap.put(0x1f624, R.drawable.u1f624);
        sEmojisMap.put(0x1f616, R.drawable.u1f616);
        sEmojisMap.put(0x1f606, R.drawable.u1f606);
        sEmojisMap.put(0x1f60b, R.drawable.u1f60b);
        sEmojisMap.put(0x1f637, R.drawable.u1f637);
        sEmojisMap.put(0x1f60e, R.drawable.u1f60e);
        sEmojisMap.put(0x1f634, R.drawable.u1f634);
        sEmojisMap.put(0x1f632, R.drawable.u1f632);
        sEmojisMap.put(0x1f62e, R.drawable.u1f62e);
        sEmojisMap.put(0x1f608, R.drawable.u1f608);
        sEmojisMap.put(0x1f47f, R.drawable.u1f47f);
        sEmojisMap.put(0x1f62f, R.drawable.u1f62f);
        sEmojisMap.put(0x1f62c, R.drawable.u1f62c);
        sEmojisMap.put(0x1f615, R.drawable.u1f615);
        sEmojisMap.put(0x1f635, R.drawable.u1f635);
        sEmojisMap.put(0x1f636, R.drawable.u1f636);
        sEmojisMap.put(0x1f607, R.drawable.u1f607);
        sEmojisMap.put(0x1f60f, R.drawable.u1f60f);
        sEmojisMap.put(0x1f611, R.drawable.u1f611);
        sEmojisMap.put(0x1f648, R.drawable.u1f648);
        sEmojisMap.put(0x1f649, R.drawable.u1f649);
        sEmojisMap.put(0x1f64a, R.drawable.u1f64a);
        sEmojisMap.put(0x1f47d, R.drawable.u1f47d);
        sEmojisMap.put(0x1f4a9, R.drawable.u1f4a9);
        sEmojisMap.put(0x2764, R.drawable.u2764);
        sEmojisMap.put(0x1f494, R.drawable.u1f494);
        sEmojisMap.put(0x1f525, R.drawable.u1f525);
        sEmojisMap.put(0x1f4a2, R.drawable.u1f4a2);
        sEmojisMap.put(0x1f4a4, R.drawable.u1f4a4);
        sEmojisMap.put(0x1f6ab, R.drawable.u1f6ab);
        sEmojisMap.put(0x2b50, R.drawable.u2b50);
        sEmojisMap.put(0x26a1, R.drawable.u26a1);
        sEmojisMap.put(0x1f319, R.drawable.u1f319);
        sEmojisMap.put(0x2600, R.drawable.u2600);
        sEmojisMap.put(0x26c5, R.drawable.u26c5);
        sEmojisMap.put(0x2601, R.drawable.u2601);
        sEmojisMap.put(0x2744, R.drawable.u2744);
        sEmojisMap.put(0x2614, R.drawable.u2614);
        sEmojisMap.put(0x26c4, R.drawable.u26c4);
        sEmojisMap.put(0x1f44d, R.drawable.u1f44d);
        sEmojisMap.put(0x1f44e, R.drawable.u1f44e);
        sEmojisMap.put(0x1f44c, R.drawable.u1f44c);
        sEmojisMap.put(0x1f44a, R.drawable.u1f44a);
        sEmojisMap.put(0x270a, R.drawable.u270a);
        sEmojisMap.put(0x270c, R.drawable.u270c);
        sEmojisMap.put(0x270b, R.drawable.u270b);
        sEmojisMap.put(0x1f64f, R.drawable.u1f64f);
        sEmojisMap.put(0x261d, R.drawable.u261d);
        sEmojisMap.put(0x1f44f, R.drawable.u1f44f);
        sEmojisMap.put(0x1f91d, R.drawable.u1f91d);
        sEmojisMap.put(0x1f4aa, R.drawable.u1f4aa);
        sEmojisMap.put(0x1f46a, R.drawable.u1f46a);
        sEmojisMap.put(0x1f46b, R.drawable.u1f46b);
        sEmojisMap.put(0x1f47c, R.drawable.u1f47c);
        sEmojisMap.put(0x1f434, R.drawable.u1f434);
        sEmojisMap.put(0x1f436, R.drawable.u1f436);
        sEmojisMap.put(0x1f437, R.drawable.u1f437);
        sEmojisMap.put(0x1f47b, R.drawable.u1f47b);
        sEmojisMap.put(0x1f339, R.drawable.u1f339);
        sEmojisMap.put(0x1f33b, R.drawable.u1f33b);
        sEmojisMap.put(0x1f332, R.drawable.u1f332);
        sEmojisMap.put(0x1f384, R.drawable.u1f384);
        sEmojisMap.put(0x1f381, R.drawable.u1f381);
        sEmojisMap.put(0x1f389, R.drawable.u1f389);
        sEmojisMap.put(0x1f4b0, R.drawable.u1f4b0);
        sEmojisMap.put(0x1f382, R.drawable.u1f382);
        sEmojisMap.put(0x1f356, R.drawable.u1f356);
        sEmojisMap.put(0x1f35a, R.drawable.u1f35a);
        sEmojisMap.put(0x1f366, R.drawable.u1f366);
        sEmojisMap.put(0x1f36b, R.drawable.u1f36b);
        sEmojisMap.put(0x1f349, R.drawable.u1f349);
        sEmojisMap.put(0x1f377, R.drawable.u1f377);
        sEmojisMap.put(0x1f37b, R.drawable.u1f37b);
        sEmojisMap.put(0x2615, R.drawable.u2615);
        sEmojisMap.put(0x1f3c0, R.drawable.u1f3c0);
        sEmojisMap.put(0x26bd, R.drawable.u26bd);
        sEmojisMap.put(0x1f3c2, R.drawable.u1f3c2);
        sEmojisMap.put(0x1f6b2, R.drawable.u1f6b2);
        sEmojisMap.put(0x1f3a4, R.drawable.u1f3a4);
        sEmojisMap.put(0x1f3b5, R.drawable.u1f3b5);
        sEmojisMap.put(0x1f3b2, R.drawable.u1f3b2);
        sEmojisMap.put(0x1f004, R.drawable.u1f004);
        sEmojisMap.put(0x1f451, R.drawable.u1f451);
        sEmojisMap.put(0x1f484, R.drawable.u1f484);
        sEmojisMap.put(0x1f48b, R.drawable.u1f48b);
        sEmojisMap.put(0x1f48d, R.drawable.u1f48d);
        sEmojisMap.put(0x1f4da, R.drawable.u1f4da);
        sEmojisMap.put(0x1f393, R.drawable.u1f393);
        sEmojisMap.put(0x270f, R.drawable.u270f);
        sEmojisMap.put(0x1f3e1, R.drawable.u1f3e1);
        sEmojisMap.put(0x1f6bf, R.drawable.u1f6bf);
        sEmojisMap.put(0x1f4a1, R.drawable.u1f4a1);
        sEmojisMap.put(0x1f4de, R.drawable.u1f4de);
        sEmojisMap.put(0x1f4e2, R.drawable.u1f4e2);
        sEmojisMap.put(0x1f556, R.drawable.u1f556);
        sEmojisMap.put(0x23f0, R.drawable.u23f0);
        sEmojisMap.put(0x23f3, R.drawable.u23f3);
        sEmojisMap.put(0x1f4a3, R.drawable.u1f4a3);
        sEmojisMap.put(0x1f52b, R.drawable.u1f52b);
        sEmojisMap.put(0x1f48a, R.drawable.u1f48a);
        sEmojisMap.put(0x1f680, R.drawable.u1f680);
        sEmojisMap.put(0x1f30f, R.drawable.u1f30f);
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

package com.green.hand.library.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.DynamicDrawableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.green.hand.library.EmojiManager;
import com.green.hand.library.EmojiconHandler;
import com.green.hand.library.R;

public class EmojiEdittext extends EditText {
    private View view = null;
    private int mEmojiconSize;
    private int mEmojiconAlignment;
    private int mEmojiconTextSize;
    private boolean mUseSystemDefault = false;

    public EmojiEdittext(Context context) {
        super(context);
        initView(null);
    }

    public EmojiEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public EmojiEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        mEmojiconSize = (int) getTextSize();
        mEmojiconTextSize = (int) getTextSize();
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.Emojicon);
            mEmojiconSize = (int) a.getDimension(R.styleable.Emojicon_emojiconSize, getTextSize());
            mEmojiconAlignment = a.getInt(R.styleable.Emojicon_emojiconAlignment, DynamicDrawableSpan.ALIGN_BASELINE);
            mUseSystemDefault = a.getBoolean(R.styleable.Emojicon_emojiconUseSystemDefault, false);
            a.recycle();
        }
        setText(getText());
        addTextChangedListener(textWatcher);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (view != null)
                view.setEnabled(!editable.toString().isEmpty());//输入完不为空内容才可以点击
            int start = getSelectionStart();
            int end = getSelectionEnd();
            removeTextChangedListener(this);//取消监听
            updateText();
            CharSequence cs = EmojiManager.parse(editable.toString(), getTextSize());
            setText(cs, TextView.BufferType.SPANNABLE);
            setSelection(start, end);
            addTextChangedListener(this);
        }
    };

    public void setEmojiconSize(int pixels) {
        mEmojiconSize = pixels;
        updateText();
    }

    private void updateText() {
        EmojiconHandler.addEmojis(getContext(), getText(), mEmojiconSize, mEmojiconAlignment, mEmojiconTextSize, mUseSystemDefault);
    }

    public void setUseSystemDefault(boolean useSystemDefault) {
        mUseSystemDefault = useSystemDefault;
    }

    /**
     * 未输入的时候让其他控件不能点击
     */
    public void isEnable(View view) {
        this.view = view;
    }
}

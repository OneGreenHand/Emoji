package com.green.hand.library;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author OneGreenHand
 * @package com.green.hand.library
 * @fileName EmoniEdittext
 * @data on 2019/1/3 15:51
 * @describe
 */
public class EmoniEdittext extends EditText {
    private Context context;
    private View view = null;

    public EmoniEdittext(Context context) {
        super(context);
        this.context = context;
        initView(context);
    }

    public EmoniEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context);
    }

    public EmoniEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(context);
    }

    public EmoniEdittext(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        initView(context);
    }

    private void initView(Context context) {
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
            CharSequence cs = EmojiManager.parse(editable.toString(), getTextSize());
            setText(cs, TextView.BufferType.SPANNABLE);
            setSelection(start, end);
            addTextChangedListener(this);
        }
    };

    /**
     * 未输入的时候让其他控件不能点击
     */
    public void isEnable(View view) {
        this.view = view;
    }
}

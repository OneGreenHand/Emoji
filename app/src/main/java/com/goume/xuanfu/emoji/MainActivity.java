package com.goume.xuanfu.emoji;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.input_editor)
    EditText textEditor;
    @Bind(R.id.input_emoji_btn)
    ImageView emojiBtn;
    @Bind(R.id.input_send)
    TextView sendBtn;
    @Bind(R.id.input_emoji_board)
    EmojiBoard emojiBoard;
    @Bind(R.id.message_content)
    TextView messageContent;
    private String messages = "";//显示内容

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        textEditor.addTextChangedListener(textWatcher);
        emojiBoard.setItemClickListener(new EmojiBoard.OnEmojiItemClickListener() {//emoji点击事件
            @Override
            public void onClick(String code) {
                if (code.equals("/DEL")) {//点击了删除图标
                    textEditor.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                } else {
                    textEditor.getText().insert(textEditor.getSelectionStart(), code);
                }
            }
        });
    }

    /**
     * 输入监听事件
     */
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            sendBtn.setEnabled(!editable.toString().isEmpty());//输入完不为空内容才可以点击
            int start = textEditor.getSelectionStart();
            int end = textEditor.getSelectionEnd();
            textEditor.removeTextChangedListener(this);
            CharSequence cs = EmojiManager.parse(editable.toString(), textEditor.getTextSize());
            textEditor.setText(cs, TextView.BufferType.SPANNABLE);
            textEditor.setSelection(start, end);
            textEditor.addTextChangedListener(this);
        }
    };

    /**
     * back键或者空白区域点击事件处理
     *
     * @return 已处理true, 否则false
     */
    public boolean onBackAction() {
        if (emojiBoard.getVisibility() == VISIBLE) {
            emojiBoard.setVisibility(GONE);
            emojiBtn.setSelected(false);
            return true;
        }
        return false;
    }

    @OnClick({R.id.input_emoji_btn, R.id.input_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.input_emoji_btn:
                emojiBtn.setSelected(emojiBoard.getVisibility() == VISIBLE);
                emojiBoard.setVisibility(emojiBoard.getVisibility() == VISIBLE ? GONE : VISIBLE);
                emojiBtn.setSelected(emojiBoard.getVisibility() == VISIBLE);
                break;
            case R.id.input_send:
                messages = messages + textEditor.getText().toString();
                messageContent.setText(messages);
                textEditor.getText().clear();
                break;
        }
    }
}

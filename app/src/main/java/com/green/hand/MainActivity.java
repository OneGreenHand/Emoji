package com.green.hand;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.green.hand.emoji.R;
import com.green.hand.library.EmojiBoard;
import com.green.hand.library.EmoniEdittext;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.input_editor)
    EmoniEdittext textEditor;
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
        textEditor.isEnable(sendBtn);//这里是为了让未输入内容的时候不让点击
        emojiBoard.setItemClickListener(new EmojiBoard.OnEmojiItemClickListener() {//表情框点击事件
            @Override
            public void onClick(String code) {
                if (code.equals("/DEL")) {//点击了删除图标
                    textEditor.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                } else {//插入表情
                    textEditor.getText().insert(textEditor.getSelectionStart(), code);
                }
            }
        });
    }


    @Override
    public void onBackPressed() {//监听返回键，如果表情框已显示就隐藏
        if (emojiBoard.getVisibility() == VISIBLE) {
            showEmojiBoard();
        }
    }

    @OnClick({R.id.input_emoji_btn, R.id.input_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.input_emoji_btn://表情按钮
                showEmojiBoard();
                break;
            case R.id.input_send://发送按钮
                messages = messages + textEditor.getText().toString();
                messageContent.setText(messages);
                textEditor.getText().clear();
                break;
        }
    }

    public void showEmojiBoard() {
        emojiBtn.setSelected(emojiBoard.getVisibility() == GONE);//设置图片选中效果
        emojiBoard.showBoard();//是否显示表情框
    }
}

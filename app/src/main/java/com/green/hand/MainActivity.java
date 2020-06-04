package com.green.hand;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.green.hand.emoji.R;
import com.green.hand.library.widget.EmojiBoard;
import com.green.hand.library.widget.EmojiEdittext;
import com.green.hand.library.widget.EmojiTextview;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private EmojiEdittext textEditor;
    private ImageView emojiBtn;
    private TextView sendBtn;
    private EmojiBoard emojiBoard;
    private EmojiTextview messageContent;
    private String messages = "";//显示内容

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        finID();
        textEditor.isEnable(sendBtn);//这里是为了让未输入内容的时候不让点击
        emojiBoard.setItemClickListener(new EmojiBoard.OnEmojiItemClickListener() {//表情框点击事件
            @Override
            public void onClick(String code) {
                if (code.equals("/DEL")) {//删除图标
                    textEditor.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                } else {//插入表情
                    textEditor.getText().insert(textEditor.getSelectionStart(), code);
                }
            }
        });
    }

    /**
     * findViewById
     */
    private void finID() {
        textEditor = findViewById(R.id.input_editor);
        emojiBtn = findViewById(R.id.input_emoji_btn);
        sendBtn = findViewById(R.id.input_send);
        emojiBoard = findViewById(R.id.input_emoji_board);
        messageContent = findViewById(R.id.message_content);
        emojiBtn.setOnClickListener(this);
        sendBtn.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {//监听返回键，如果表情框已显示就隐藏
        if (emojiBoard.getVisibility() == VISIBLE) {
            showEmojiBoard();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 展开or隐藏表情框
     */
    public void showEmojiBoard() {
        emojiBtn.setSelected(emojiBoard.getVisibility() == GONE);//设置图片选中效果
        emojiBoard.showBoard();//是否显示表情框
    }

    @Override
    public void onClick(View view) {
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
}

# 效果图
![效果图](https://github.com/OneGreenHand/Emoji/blob/master/img/emoji.gif?raw=true.gif)  
## 如何使用
dependencies {  
　`implementation 'com.github.OneGreenHand:Emoji:v1.1'`   
}  
**1、初始化**  
在Application中进行初始化  
`EmojiManager.init(this)`  
**2、在布局中应用**  

    <com.green.hand.library.EmojiBoard
      android:layout_width="match_parent"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      app:deleteIcon="@mipmap/ic_launcher"//可选
      app:emojiIndicator="@mipmap/ic_launcher"//可选
      app:emojiIndicatorHover="@mipmap/ic_launcher"//可选
    /> 
//可选，如果不用此控件，需自行监听实现，具体参考[EmoniEdittext](https://github.com/OneGreenHand/Emoji/blob/master/library/src/main/java/com/green/hand/library/EmoniEdittext.java)。

    <com.green.hand.library.EmoniEdittext
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
    />
**3、在页面中使用**
实现表情框Item单击事件（emojiBoard为[EmojiBoard](https://github.com/OneGreenHand/Emoji/blob/master/library/src/main/java/com/green/hand/library/EmojiBoard.java)控件，textEditor为Edittext控件）

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

**4、其他方法**  
EmojiBoard　--->　showBoard()　//显示隐藏表情框  
EmoniEdittext　--->　isEnable(view)　//用于未输入文字时，其他按钮不可点击
### 属性说明  
deleteIcon：删除icon  
emojiIndicator：底部未选中icon   
emojiIndicatorHover：底部选中icon  

已知问题:部分机型显示还是为安卓样式，介意者慎用！
#### **欢迎Start或提issues！**
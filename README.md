# 效果图
![效果图](https://github.com/OneGreenHand/Emoji/blob/master/img/emoji.gif?raw=true.gif)  
## 如何使用
```java
dependencies {  
   　implementation 'com.github.OneGreenHand:Emoji:v1.2.2'
}
```

**1、初始化**  
在Application中进行初始化  
```java 
EmojiManager.init(this)  
```

**2、在布局中应用**  
```java
  <com.green.hand.library.widget.EmojiBoard
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      app:deleteIcon="@mipmap/ic_launcher"//可选
      app:emojiIndicator="@mipmap/ic_launcher"//可选
      app:emojiIndicatorHover="@mipmap/ic_launcher"//可选
    /> 
```

*可选，如果不用此控件，需自行监听实现，具体参考[EmoniEdittext](https://github.com/OneGreenHand/Emoji/blob/master/library/src/main/java/com/green/hand/library/widget/EmojiEdittext.java)。
```java
   <com.green.hand.library.widget.EmojiEdittext
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
    />
```

//兼容emoji显示的textview
```java
     <com.green.hand.library.widget.EmojiTextview
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
      />
```

**3、在页面中使用**
实现表情框Item单击事件（emojiBoard为[EmojiBoard](https://github.com/OneGreenHand/Emoji/blob/master/library/src/main/java/com/green/hand/library/widget/EmojiBoard.java)控件，textEditor为Edittext控件）
```java
emojiBoard.setItemClickListener(new EmojiBoard.OnEmojiItemClickListener() {//表情框点击事件
     @Override
     public void onClick(String code) {
        if (code.equals("/DEL")) {//点击了删除图标
          textEditor.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_DEL));
        } else {//插入表情
         textEditor.getText().insert(textEditor.getSelectionStart(), code);
     }
     }
    });
```

**4、其他方法**  
EmojiBoard　--->　showBoard()　//显示隐藏表情框  
EmoniEdittext　--->　isEnable(view)　//用于未输入文字时，其他按钮不可点击  
EmojiTextview　--->　setUseSystemDefault(boolean)　//是否使用系统默认表情
### 属性说明  
deleteIcon：删除icon  
emojiIndicator：底部未选中icon   
emojiIndicatorHover：底部选中icon  

### **补充说明** 
如果仍然出现显示为☐或者乱码情况，可尝试使用官方的 [EmojiCompat](https://www.jianshu.com/p/2a26502db899) 支持库或使用[emojicon](https://github.com/rockerhieu/emojicon)三方库
### 版本日志
 + v1.2.2
    - 新增、替换表情、去除ButterKnife依赖
 + v1.2.1
    - 新增、去除重复表情
    - 修复部分手机无法显示问题
    - 加入兼容Emoji显示的控件

### 其他
 有任何问题，可以在[issues](https://github.com/OneGreenHand/Emoji/issues)给我留言反馈。</br>
package com.green.hand.library;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class EmojiGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Integer> resList = new ArrayList<>();
    private EmojiClick emojiClick;

    public void setOnEmojiClick(EmojiClick emojiClick) {
        this.emojiClick = emojiClick;
    }

    public interface EmojiClick {
        void onClick(int position);
    }

    public void setResList(List<Integer> list) {
        resList.clear();
        resList.addAll(list);
    }

    //创建ViewHolder并返回，后续item布局里控件都是从ViewHolder中取出
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(new ImageView(parent.getContext()));
    }

    //通过方法提供的ViewHolder，将数据绑定到ViewHolder中
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int position) {
        ImageView img = (ImageView) viewHolder.itemView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, EmojiUtil.dp2px(23));
        layoutParams.topMargin = EmojiUtil.dp2px(10);
        img.setLayoutParams(layoutParams);
        img.setImageResource(resList.get(position));
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emojiClick != null)
                    emojiClick.onClick(position);
            }
        });
    }

    //获取数据源总的条数
    @Override
    public int getItemCount() {
        return resList.size();
    }

    /**
     * 自定义的ViewHolder
     */
    class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(ImageView img) {
            super(img);
        }
    }
}
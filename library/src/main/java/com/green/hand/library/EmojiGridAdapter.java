package com.green.hand.library;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class EmojiGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<Integer> resList = null;
    private EmojiClick emojiClick;

    public void setOnEmojiClick(EmojiClick emojiClick) {
        this.emojiClick = emojiClick;
    }

    public interface EmojiClick {
        void onClick(int position);
    }

    public EmojiGridAdapter(Context context) {
        this.context = context;
    }

    public void setResList(List<Integer> list) {
        resList = list;
    }

    //创建ViewHolder并返回，后续item布局里控件都是从ViewHolder中取出
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView img = new ImageView(context);
        RecyclerView.ViewHolder holder = new MyHolder(img);
        return holder;
    }

    //通过方法提供的ViewHolder，将数据绑定到ViewHolder中
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int position) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.topMargin = (int) (10 * context.getResources().getDisplayMetrics().density + 0.5f);
        ((MyHolder) viewHolder).img.setLayoutParams(layoutParams);
        ((MyHolder) viewHolder).img.setPadding(10, 10, 10, 10);
        ((MyHolder) viewHolder).img.setImageResource(resList.get(position));
        ((MyHolder) viewHolder).img.setOnClickListener(new View.OnClickListener() {
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
        ImageView img;

        public MyHolder(ImageView itemView) {
            super(itemView);
            img = itemView;
        }
    }
}
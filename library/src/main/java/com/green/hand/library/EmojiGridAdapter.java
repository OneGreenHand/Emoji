package com.green.hand.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class EmojiGridAdapter extends BaseAdapter {
    private Context context;
    List<Integer> resList;

    public EmojiGridAdapter(Context context) {
        this.context = context;
    }

    public void setResList(List<Integer> list) {
        resList = list;
    }

    @Override
    public int getCount() {
        return resList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewGroup view;
        if (convertView == null) {
            view = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.input_emoji_griditem, null);
            view.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (40 * context.getResources().getDisplayMetrics().density + 0.5f)));
        } else {
            view = (ViewGroup) convertView;
        }
        ImageView image = (ImageView) view.findViewById(R.id.image);
        image.setImageResource(resList.get(position));
        return view;
    }
}

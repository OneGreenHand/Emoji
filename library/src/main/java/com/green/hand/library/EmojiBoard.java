package com.green.hand.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class EmojiBoard extends LinearLayout {

    private ViewPager viewPager;
    private Indicator indicator;
    private OnEmojiItemClickListener listener;
    private int deleteIcon = -1;//删除按钮
    private int emojiIndicator = -1;//选中小圆点图片
    private int emojiIndicatorHover = -1;//未选中小圆点图片
    private Context context;

    public interface OnEmojiItemClickListener {
        void onClick(String code);
    }

    public EmojiBoard(Context context) {
        super(context);
        this.context = context;
        initView(null);
    }

    public EmojiBoard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(attrs);
    }

    public EmojiBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(attrs);
        LayoutInflater.from(getContext()).inflate(R.layout.input_emoji_board, this);
        viewPager = findViewById(R.id.view_pager);
        indicator = new Indicator((ViewGroup) findViewById(R.id.indicator));
        viewPager.setAdapter(new EmojiPageAdapter());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                indicator.setSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initView(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.EmojiBoard);
            deleteIcon = array.getResourceId(R.styleable.EmojiBoard_deleteIcon, -1);
            emojiIndicator = array.getResourceId(R.styleable.EmojiBoard_emojiIndicator, -1);
            emojiIndicatorHover = array.getResourceId(R.styleable.EmojiBoard_emojiIndicatorHover, -1);
            array.recycle();
        }
    }

    public void setItemClickListener(OnEmojiItemClickListener listener) {
        this.listener = listener;
    }

    private class EmojiPageAdapter extends PagerAdapter {

        private ArrayList<View> viewContainer = new ArrayList<>();

        public EmojiPageAdapter() {
            int pageSize = EmojiUtil.getPageSize();
            for (int i = 0; i < pageSize; i++) {
                GridView gridView = (GridView) LayoutInflater.from(getContext()).inflate(R.layout.input_emoji_gridview, null);
                EmojiGridAdapter adapter = new EmojiGridAdapter(context);
                int start = i * (EmojiUtil.ROW * EmojiUtil.COLUMN - 1);
                int count;
                if (i < pageSize) {
                    count = (EmojiUtil.ROW * EmojiUtil.COLUMN - 1);
                } else {
                    count = EmojiManager.getSize() - start;
                }
                if (isInEditMode()) {
                    return;
                }
                final List<Integer> list = EmojiManager.getResourceList(start, count);
                if (deleteIcon == -1)
                    list.add(R.drawable.input_emoji_delete);
                else
                    list.add(deleteIcon);
                adapter.setResList(list);
                gridView.setAdapter(adapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (listener != null) {
                            String code = "";
                            if (position == EmojiUtil.ROW * EmojiUtil.COLUMN - 1) {
                                code = "/DEL";
                            } else {
                                int pos = viewPager.getCurrentItem() * (EmojiUtil.ROW * EmojiUtil.COLUMN - 1) + position;
                                char[] chars = Character.toChars(EmojiManager.getCode(pos));
                                for (int i = 0; i < chars.length; i++) {
                                    code += Character.toString(chars[i]);
                                }
                            }
                            listener.onClick(code);
                        }
                    }
                });
                viewContainer.add(gridView);
            }
        }

        @Override
        public int getCount() {
            return viewContainer.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewContainer.get(position));
            return viewContainer.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

    private class Indicator {
        private ViewGroup rootView;
        private ArrayList<ImageView> imageList = new ArrayList<>();

        public Indicator(ViewGroup root) {
            rootView = root;
            int pageSize = EmojiUtil.getPageSize();
            for (int i = 0; i < pageSize; i++) {
                ImageView imageView = new ImageView(getContext());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                int px = (int) (4 * context.getResources().getDisplayMetrics().density + 0.5f);
                params.setMargins(px, 0, px, 0);
                imageView.setLayoutParams(params);
                if (i == 0) {
                    if (emojiIndicatorHover == -1)
                        imageView.setImageResource(R.drawable.input_emoji_indicator_hover);
                    else
                        imageView.setImageResource(emojiIndicatorHover);
                } else {
                    if (emojiIndicator == -1)
                        imageView.setImageResource(R.drawable.input_emoji_indicator);
                    else
                        imageView.setImageResource(emojiIndicator);
                }
                imageList.add(imageView);
                rootView.addView(imageView);
            }
        }

        public void setSelected(int position) {
            for (int i = 0; i < imageList.size(); i++) {
                if (i != position) {
                    if (emojiIndicator == -1)
                        imageList.get(i).setImageResource(R.drawable.input_emoji_indicator);
                    else
                        imageList.get(i).setImageResource(emojiIndicator);
                } else {
                    if (emojiIndicatorHover == -1)
                        imageList.get(i).setImageResource(R.drawable.input_emoji_indicator_hover);
                    else
                        imageList.get(i).setImageResource(emojiIndicatorHover);
                }
            }
        }
    }

    /**
     * 是否显示表情框
     */
    public void showBoard() {
        setVisibility(getVisibility() == VISIBLE ? GONE : VISIBLE);
    }
}

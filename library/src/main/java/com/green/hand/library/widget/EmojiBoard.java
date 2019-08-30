package com.green.hand.library.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.green.hand.library.EmojiGridAdapter;
import com.green.hand.library.EmojiManager;
import com.green.hand.library.EmojiUtil;
import com.green.hand.library.R;

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
                RecyclerView recyclerView = new RecyclerView(context);
                recyclerView.setLayoutManager(new GridLayoutManager(context, 7));
                final EmojiGridAdapter adapter = new EmojiGridAdapter(context);
                int start = i * (EmojiUtil.getOnePageSize());
                int endIndex = (i + 1) * (EmojiUtil.getOnePageSize());
                if (EmojiManager.getSize() < endIndex)//最后一页数量不够填充一页
                    endIndex = EmojiManager.getSize();
                if (isInEditMode()) {
                    return;
                }
                final List<Integer> list = EmojiManager.getResourceList(start, endIndex);//获取每一页的数据量
                if (deleteIcon == -1)//每页数据后面添加一个删除按钮
                    list.add(R.drawable.input_emoji_delete);
                else
                    list.add(deleteIcon);
                adapter.setResList(list);
                recyclerView.setAdapter(adapter);
                adapter.setOnEmojiClick(new EmojiGridAdapter.EmojiClick() {
                    @Override
                    public void onClick(int position) {
                        if (listener != null) {
                            String code = "";
                            if (position == adapter.getItemCount() - 1) {//点击的为每页最后一个数据，即为删除按钮
                                code = "/DEL";
                            } else {
                                int pos = viewPager.getCurrentItem() * (EmojiUtil.getOnePageSize()) + position;
                                char[] chars = Character.toChars(EmojiManager.getCode(pos));
                                for (int i = 0; i < chars.length; i++) {
                                    code += Character.toString(chars[i]);
                                }
                            }
                            listener.onClick(code);
                        }
                    }
                });
                viewContainer.add(recyclerView);
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

    /**
     * 底部小圆点
     */
    private class Indicator {
        private ViewGroup rootView;
        private ArrayList<ImageView> imageList = new ArrayList<>();

        public Indicator(ViewGroup root) {
            rootView = root;
            int pageSize = EmojiUtil.getPageSize();
            for (int i = 0; i < pageSize; i++) {//多少页数据就有多少个小圆点
                ImageView imageView = new ImageView(getContext());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                int px = (int) (4 * context.getResources().getDisplayMetrics().density + 0.5f);//设置间距
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

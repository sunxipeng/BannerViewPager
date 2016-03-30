package com.sunxipeng.bannerviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/29.
 */
public class HomeBannerAdapter extends PagerAdapter {
    private ArrayList<ImageView> mViews;
    private Context mContext;


    public HomeBannerAdapter(Context context) {
        this.mContext = context;

        mViews = new ArrayList<ImageView>();

        ImageView iv0 = new ImageView(mContext);
        iv0.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.a));
        iv0.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mViews.add(iv0);

        ImageView iv1 = new ImageView(mContext);
        iv1.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.b));
        iv1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mViews.add(iv1);

        ImageView iv2 = new ImageView(mContext);
        iv2.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.c));
        iv2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mViews.add(iv2);

        ImageView iv3 = new ImageView(mContext);
        iv3.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.d));
        iv3.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mViews.add(iv3);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {


        container.addView(mViews.get(position));

        return mViews.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);//删除页卡
    }
}

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
    private ImageView iv;

    public HomeBannerAdapter(Context context) {
        this.mContext = context;

//        mViews = new ArrayList<ImageView>();
//        for (int i=0; i<mUrls.size(); i++) {
//            iv = new ImageView(mContext);
//            iv.setLayoutParams(new ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT));
//            mViews.add(iv);
//        }
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container,final int position) {
        ImageView iv = new ImageView(mContext);
        iv.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));


        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);//删除页卡
    }
}

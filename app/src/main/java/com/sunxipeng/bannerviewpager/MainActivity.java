package com.sunxipeng.bannerviewpager;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends Activity implements ViewPager.OnPageChangeListener {

    private ViewPager vp_banner;
    private LinearLayout ll_dot_container;
    private ArrayList<ImageView> iv_dots;
    private ImageView iv;

    private Runnable runnable = new Runnable( ) {

        public void run ( ) {

            vp_banner.setCurrentItem(vp_banner.getCurrentItem() + 1);
            startScroll();

        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_dots = new ArrayList<ImageView>();

        vp_banner = (ViewPager) findViewById(R.id.vp_banner);
        vp_banner.addOnPageChangeListener(this);
        ll_dot_container = (LinearLayout) findViewById(R.id.ll_dot_container);
        ll_dot_container.removeAllViews();
        for (int i = 0; i < 4; i++) {
            iv = new ImageView(this, null);
            iv.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            if (i == 0) {
                iv.setImageResource(R.drawable.dot_viewpager_on);
            } else {
                iv.setImageResource(R.drawable.dot_viewpager_gray);
            }
            iv_dots.add(iv);
            ll_dot_container.addView(iv);
        }

        HomeBannerAdapter adapter = new HomeBannerAdapter(this);
        vp_banner.setAdapter(adapter);

        int n = Integer.MAX_VALUE / 2 % 4;
        int itemPosition = Integer.MAX_VALUE / 2 - n;

        vp_banner.setCurrentItem(itemPosition);
        stopScroll();
        startScroll();
        
    }
    private Handler handler = new Handler( );
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    private void startScroll() {
        handler.postDelayed(runnable, 4000); // 开始Timer
    }

    private void stopScroll() {
        handler.removeCallbacks(runnable); //停止Timer
    }
    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < 4; i++) {
            if ((position % 4) == i) {
                iv_dots.get(i).setImageResource(R.drawable.dot_viewpager_on);
            } else {
                iv_dots.get(i).setImageResource(R.drawable.dot_viewpager_gray);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == 2) {
            stopScroll();
            startScroll();
        }
    }



}

package com.lanou3g.chanyoujidemo.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.main.util.ScreenUtils;

/**
 * Created by ${jl} on 16/5/13.
 */
public class SlidingAdView extends HorizontalScrollView{
    public boolean twoView;
    private SlidingListener slidingListener;
    private int adSlidingWidth;
    private Context context;
    private float  xDistance,yDistance,xLast,yLast;

    public void setSlidingListener(SlidingListener slidingListener ,Context context) {
        this.slidingListener = slidingListener;
        this.context = context;


//        //使广告轮播
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                try {
//                    Thread.sleep(5000);
//
//                    if (twoView){
//                        smoothScrollTo(0,0);
//                        twoView = false;
//                    }else {
//                        smoothScrollTo(adSlidingWidth,0);
//                        twoView = true;
//
//                    }
//
//
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }}
//        }).start();

    }

    public SlidingAdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        twoView = false;
    }
    public void returnView(){
        smoothScrollTo(0,0);
        twoView = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){
            case MotionEvent.ACTION_MOVE:
                slidingListener.onMove(this);
                break;
            case MotionEvent.ACTION_UP:

                changeScroll();
                return true;


        }


        return super.onTouchEvent(ev);
    }

    private void changeScroll() {
        if (getScrollX()>adSlidingWidth/2){
            smoothScrollTo(adSlidingWidth,0);

            twoView = true;
            slidingListener.onTwoView(this);
        }else {
            returnView();
            twoView = false;

        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        ImageView imageView = (ImageView) findViewById(R.id.item_travel_ad_head_frist_iv);
        adSlidingWidth = imageView.getWidth();




    }

    public interface SlidingListener{
        void onMove(SlidingAdView slidingAdView);
        void onTwoView(SlidingAdView slidingMenuView);

    }

//    @Override
//    public boolean canScrollHorizontally(int direction) {
//
//        return !twoView;
//    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                final float curY = ev.getY();

                xDistance += Math.abs(curX - xLast);
                yDistance += Math.abs(curY - yLast);
                xLast = curX;
                yLast = curY;

                /**
                 * X轴滑动距离大于Y轴滑动距离，也就是用户横向滑动时，返回false，ScrollView不处理这次事件，
                 * 让子控件中的TouchEvent去处理，所以横向滑动的事件交由ViewPager处理，
                 * ScrollView只处理纵向滑动事件
                 */
                if (xDistance > yDistance) {
                    return false;
                }else
                    return true;
        }

        return super.onInterceptTouchEvent(ev);
    }


}

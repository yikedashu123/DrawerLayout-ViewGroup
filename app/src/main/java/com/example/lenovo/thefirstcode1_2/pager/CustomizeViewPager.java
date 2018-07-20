package com.example.lenovo.thefirstcode1_2.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomizeViewPager extends LazyViewPager {
    public CustomizeViewPager(Context context) {
        super(context);
    }

    public CustomizeViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}

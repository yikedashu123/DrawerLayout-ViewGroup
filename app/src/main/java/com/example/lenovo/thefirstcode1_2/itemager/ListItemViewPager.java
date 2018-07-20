package com.example.lenovo.thefirstcode1_2.itemager;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class ListItemViewPager extends BaseViewPager{
    private TextView mTiew;
    public ListItemViewPager(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        mTiew=new TextView(mContext);
        mTiew.setTextColor(Color.RED);
        mTiew.setTextSize(24);
        mTiew.setGravity(Gravity.CENTER);

        return mTiew;
    }

    @Override
    public void initListDate(String s) {
        mTiew.setText(s);
        Log.i("ListItemViewPager", "initListDate: "+s);
    }
}

package com.example.lenovo.thefirstcode1_2.itemager;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.thefirstcode1_2.R;

public class BaseViewPager {
    public Context mContext;
    private TextView mText;
    private View mView;
    //TODO 数据测试
    private String str;
    public BaseViewPager(Context context)
    {
        this.mContext=context;
        mView=initView();
    }

    /**
     *
     * @return 显示的页面
     */
    protected View initView() {
        View view=View.inflate(mContext, R.layout.item_pager_layout,null);
        mText=view.findViewById(R.id.tv_pagerText);
        mText.setText(str);
        Log.i("ListItemViewPager", "initListDate: "+mText.getText().toString());
        return view;
    }
    public void initDate(int s)
    {
        switch (s)
        {
            case 0:
               str="主页";
                break;
            case 1:
                str="好友";
                break;
            case 2:
                str="动态";
                break;
        }
        Log.i("ListItemViewPager", "initListDate: "+str);
    }
    public void initListDate(String s)
    {
        Log.i("ListItemViewPager", "initListDate: "+s);
    }

    public View getRootView()
    {
        return mView;
    }
}

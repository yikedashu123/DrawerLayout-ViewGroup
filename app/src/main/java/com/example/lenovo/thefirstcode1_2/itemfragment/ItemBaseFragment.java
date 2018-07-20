package com.example.lenovo.thefirstcode1_2.itemfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.thefirstcode1_2.R;

public class ItemBaseFragment extends Fragment{
    private TextView tv;
    public String str;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item_base_layout, container, false);
        tv=view.findViewById(R.id.tv_text);
        tv.setText(str);
        return view;
    }
    public void setString(String s)
    {
        str=s;
    }
}
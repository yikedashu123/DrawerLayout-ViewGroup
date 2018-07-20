package com.example.lenovo.thefirstcode1_2;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.thefirstcode1_2.itemager.BaseViewPager;
import com.example.lenovo.thefirstcode1_2.pager.CustomizeViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private int mNumber;
    private Toolbar toolbar;
    private List<String> list;
    private RadioGroup mGroup;
    private ListView mListView;
    private DrawerLayout layout;
    private FloatingActionButton mBtn;
    private CustomizeViewPager mPager;
    private List<BaseViewPager> mListPager;
    //private List<BaseViewPager> mListItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        listener();

    }

    private void initData() {
        toolbar=findViewById(R.id.t_bar);
        setSupportActionBar(toolbar);
        layout=findViewById(R.id.dl_layout);
        mBtn=findViewById(R.id.fab_smart);
        mGroup=findViewById(R.id.rg_group);
        mListView=findViewById(R.id.lv_list);
        mPager=findViewById(R.id.vp_pager);
        mNumber=0;
        mListView.setDividerHeight(0);
        mListView.setPadding(0,40,0,0);
        list=new ArrayList<>();
        mListPager=new ArrayList<>();
        //mListItem =new ArrayList<>();
        //将子页面放入list
        mListPager.add(new BaseViewPager(this));
        mListPager.add(new BaseViewPager(this));
        mListPager.add(new BaseViewPager(this));
        //给listView添加数据
        for (int i=0;i<5;i++)
        {
            list.add("这是第"+(i+1)+"项");
            mListPager.add(new BaseViewPager(this));
           // mListItem.add(new ListItemViewPager(this));
        }
        mListView.setAdapter(new MyAdapter());
        mPager.setAdapter(new MyPagerAdapter());
        //初始化页面
        mPager.setCurrentItem(mNumber);
    }

    //添加监听的方法
    private void listener() {
        mBtn.setOnClickListener(this);
        mListView.setOnItemClickListener(this);
        mGroup.setOnCheckedChangeListener(this);
    }


    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.back://收藏菜单事件
//                Toast.makeText(this,"点击收藏！",Toast.LENGTH_SHORT).show();
                layout.openDrawer(Gravity.LEFT);
                break;
            case R.id.share:
                break;
            case R.id.menu:
                break;
        }
        return true;
    }
    //listView的监听实现
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mPager.setCurrentItem(i+3);
        BaseViewPager baseViewPager=mListPager.get(i+3);
        Log.i("ListItemViewPager", "initListDate: "+(i+3));
        baseViewPager.initListDate(list.get(i));
        layout.closeDrawer(Gravity.LEFT);
    }
    //FloatingActionButton的监听事件
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this,"你可真狗！",Toast.LENGTH_SHORT).show();
    }
    //RadioGroup监听
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i)
        {
            case R.id.rb_main://主页
                mNumber=0;
                break;
            case R.id.rb_fri://好友
                mNumber=1;
                break;
            case R.id.rb_news://动态
                mNumber=2;
                break;
        }
        mPager.setCurrentItem(mNumber);
    }

    //ListView的Adapter
    class MyAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null)
            {
                view= LayoutInflater.from(MainActivity.this).inflate(R.layout.item_layout,viewGroup,false);
            }
            TextView tv=view.findViewById(R.id.tv_item);
            tv.setText(list.get(i));
            return view;
        }
    }
    class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return mListPager.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view==o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            BaseViewPager bvp=mListPager.get(position);
            View view=bvp.getRootView();
            container.addView(view);
            bvp.initDate(position);
            return view;
        }
    }
}

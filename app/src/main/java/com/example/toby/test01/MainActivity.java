package com.example.toby.test01;

import android.content.IntentFilter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.toby.test01.BroadcastReceiver.boty.NetworkStateReceiver;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RadioGroup radioGroup;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
        init();
        registerBroadcastReceiver();
    }
    private void registerBroadcastReceiver(){

        // (这里可以写系统的广播接收者重写onReceiver方法就可以)
        NetworkStateReceiver receiver=new NetworkStateReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        //注册receiver
        registerReceiver(receiver, filter);
    }

    private void findviews(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_tilte);
        toolbar.setTitle("");
        tv.setText("首页 1");
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        radioGroup = (RadioGroup) findViewById(R.id.mHomeRadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = 0;
                switch (checkedId) {
                    case R.id.mHomeHomeRb:
                        index = 0;
                        break;
                    case R.id.mHomeFindRb:
                        index = 1;
                        break;
                    case R.id.mHomeSearchRb:
                        index = 2;
                        break;
                    case R.id.mHomeProfileRb:
                        index = 3;
                        break;
                }
//                toolbar.setTitle("首页 "+ String.valueOf(index+1));
                TextView tv = (TextView) toolbar.findViewById(R.id.toolbar_tilte);
                tv.setText("首页 "+ String.valueOf(index+1));
                viewPager.setCurrentItem(index);

            }

        });

//        tabLayout = (TabLayout) findViewById(R.id.tablayout);

//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//              int position =  tab.getPosition();
//                toolbar.setTitle("首页 "+ String.valueOf(position+1));
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });


    }

    private void init(){
        setSupportActionBar(toolbar);
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((RadioButton)radioGroup.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        tabLayout.setupWithViewPager(viewPager);


//        for(int i=0;i<tabLayout.getTabCount();i++){
//            tabLayout.getTabAt(i).setCustomView(new TimelineTabView(MainActivity.this));
//
//        }
        //viewPager 关联  toolbar
        //viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}


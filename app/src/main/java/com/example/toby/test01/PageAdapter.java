package com.example.toby.test01;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toby on 02/01/2017.
 */

public class PageAdapter extends FragmentPagerAdapter{


    private List<Fragment> list;

    public PageAdapter(FragmentManager fm) {
        super(fm);
        list = new ArrayList<>();


        list.add(Fragment1.newInstant());
        list.add(Fragment2.newInstant());
        list.add(Fragment3.newInstant());
        list.add(Fragment4.newInstant());
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "首页";
            case 1:
                return "目的地";
            case 2:
                return "我的";
            case 3:
                return "none";
        }
        return "";
    }
}

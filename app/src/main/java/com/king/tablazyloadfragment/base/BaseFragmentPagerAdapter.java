package com.king.tablazyloadfragment.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * author lrzg on 17/3/16.
 * 描述：
 */
public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
//public class BaseFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mListData;
    public BaseFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.mListData = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public int getCount() {
        return mListData.size();
    }
}

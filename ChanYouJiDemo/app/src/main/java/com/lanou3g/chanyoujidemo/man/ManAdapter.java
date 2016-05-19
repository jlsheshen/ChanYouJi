package com.lanou3g.chanyoujidemo.man;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.volley.Response;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ${jl} on 16/5/16.
 */
public class ManAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;
    String[] title = {"登录","注册"};



    public ManAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0:fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

}
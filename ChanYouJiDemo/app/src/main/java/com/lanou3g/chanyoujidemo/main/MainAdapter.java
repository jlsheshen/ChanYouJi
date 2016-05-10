package com.lanou3g.chanyoujidemo.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ${jl} on 16/5/9.
 */
public class MainAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private Context context ;

    public void setFragments(List<Fragment> fragments) {
        this.fragmentList = fragments;
        notifyDataSetChanged();
    }


    String [] tabName = {"游记","攻略","工具箱"};
    public MainAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0: fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabName[position];
    }
}

package com.lanou3g.chanyoujidemo.main;


import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;


import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.base.BaseActivity;
import com.lanou3g.chanyoujidemo.main.strategy.StrategyFragment;
import com.lanou3g.chanyoujidemo.main.tools.ToolsFragment;
import com.lanou3g.chanyoujidemo.main.travels.TravelsFragment;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity{
    List<Fragment> fragmentList;
    TabLayout tabLayout;
    ViewPager viewPager;
    MainAdapter mainAdapter;


    @Override
    public int setLayout() {
        return R.layout.activity_main;

    }

    @Override
    protected void initView() {
        tabLayout = bindView(R.id.main_aty_tablelayout);
        viewPager = bindView(R.id.main_aty_viewpager);
    }

    @Override
    protected void initData() {
        initFragment();
        mainAdapter = new MainAdapter(getSupportFragmentManager());
        mainAdapter.setFragments(fragmentList);
        viewPager.setAdapter(mainAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new TravelsFragment());
        fragmentList.add(new StrategyFragment());
        fragmentList.add(new ToolsFragment());
    }


}

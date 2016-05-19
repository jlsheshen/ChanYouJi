package com.lanou3g.chanyoujidemo.main;


import android.content.Intent;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;


import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.base.BaseActivity;
import com.lanou3g.chanyoujidemo.main.strategy.StrategyFragment;
import com.lanou3g.chanyoujidemo.main.tools.ToolsFragment;
import com.lanou3g.chanyoujidemo.main.travels.TravelsFragment;
import com.lanou3g.chanyoujidemo.man.ManActivity;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements View.OnClickListener{
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
        tabLayout = bindView(R.id.main_aty_tablayout);
        viewPager = bindView(R.id.main_aty_viewpager);
       findViewById(R.id.main_title_login).setOnClickListener(this);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_title_login:
            Intent toManIntent = new Intent(this, ManActivity.class);
                startActivity(toManIntent);
                break;



        }
    }
}

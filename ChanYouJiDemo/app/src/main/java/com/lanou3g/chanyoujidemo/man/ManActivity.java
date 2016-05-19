package com.lanou3g.chanyoujidemo.man;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.base.BaseActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${jl} on 16/5/16.
 */
public class ManActivity extends BaseActivity implements View.OnClickListener{
    ViewPager viewPager;
    TabLayout tabLayout;
    List<Fragment> fragmentList;

    @Override
    public int setLayout() {
        return R.layout.activity_man;
    }

    @Override
    protected void initView() {
        viewPager = bindView(R.id.man_aty_viewpager);
        tabLayout = bindView(R.id.man_aty_tablayout);
        TextView textView = (TextView) findViewById(R.id.other_title_text_tv);
        textView.setText("登录与注册");
        findViewById(R.id.other_title_back_iv).setOnClickListener(this);
        findViewById(R.id.other_title_log_iv).setOnClickListener(this);


    }

    @Override
    protected void initData() {
        fragmentList = new ArrayList<>();
        initFragment();
        ManAdapter manAdapter = new ManAdapter(getSupportFragmentManager());
        manAdapter.setFragments(fragmentList);
        viewPager.setAdapter(manAdapter);
        tabLayout.setupWithViewPager(viewPager);



    }

    private void initFragment() {
        fragmentList.add(new LoginFragment());
        fragmentList.add(new RegisterFragment());
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.other_title_log_iv:
                finish();
                break;
            case  R.id.other_title_back_iv:
                finish();
                break;


        }


    }
}

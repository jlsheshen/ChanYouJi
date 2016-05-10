package com.lanou3g.chanyoujidemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ${jl} on 16/5/9.
 * activity基类
 *
 */
public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
        initData();
    }
    //绑定布局
    public abstract int setLayout();
    //加载组件
    protected abstract void initView();
    //写入数据
    protected abstract void initData();
    //findViewById方法,简化组件的绑定
    protected <T extends View>T bindView(int id){
        return (T)findViewById(id);

    }

}

package com.lanou3g.chanyoujidemo.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by ${jl} on 16/5/9.
 */
public class MyApplication extends Application {

    public static Context context;
//第一个生命周期,我们对context赋值
    @Override
    public void onCreate() {
        super.onCreate();
        //this代表当前的环境
        context = this;
    }
}

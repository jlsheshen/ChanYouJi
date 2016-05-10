package com.lanou3g.chanyoujidemo.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by ${jl} on 16/5/9.
 */
public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}

package com.lanou3g.chanyoujidemo.main.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by ${jl} on 16/5/13.
 */
public class ScreenUtils {
    public static int getScreenWidth(Context context){
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(outMetrics);
        return  outMetrics.widthPixels;
    }
}

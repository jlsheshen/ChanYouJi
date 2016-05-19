package com.lanou3g.chanyoujidemo.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by ${jl} on 16/5/19.
 */
public class RecyclerOrListImageView extends ImageView {
    public RecyclerOrListImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setImageDrawable(null);
    }
}

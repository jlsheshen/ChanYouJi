package com.lanou3g.chanyoujidemo.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lanou3g.chanyoujidemo.R;


/**
 * Created by ${jl} on 16/5/19.
 */
public class ImageAndTextView extends LinearLayout {
    ImageView imageView;
    TextView textView;


    public ImageAndTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
         LayoutInflater.from(context).inflate(R.layout.view_image_and_text_layout,this, true);
        imageView  = (ImageView) findViewById(R.id.image_and_text_view_iv);
        textView  = (TextView) findViewById(R.id.image_and_text_view_tv);
    }
    //设置图片接口
    public void setImageResource(int resId){
        imageView.setImageResource(resId);
    }
    //设置文字接口
    public void setText(String str){
        textView.setText(str);
    }
    //设置文字大小
    public void setTextSize(float size){
        textView.setTextSize(size);
    }




}

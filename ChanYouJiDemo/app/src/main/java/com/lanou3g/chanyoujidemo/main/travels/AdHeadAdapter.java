package com.lanou3g.chanyoujidemo.main.travels;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanou3g.chanyoujidemo.R;


import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${jl} on 16/5/13.
 */
public class AdHeadAdapter extends PagerAdapter {
    Context context;

    List<String> urls;


    public AdHeadAdapter(Context context) {
        this.context = context;

    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }


    @Override
    public int getCount() {
        return urls == null? 0: urls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewpager_travel_ad_head,container,false);

        ImageView imageView = (ImageView) view.findViewById(R.id.viewpager_travel_ad_head_iv);
        Log.d("AdHeadAdapter", urls.get(position));

        Picasso.with(context).load(urls.get(position)).into(imageView);
        container.addView(view);
        return view;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }



}


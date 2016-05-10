package com.lanou3g.chanyoujidemo.main.bean;

/**
 * Created by ${jl} on 16/5/9.
 * 首页内容类,是游记和广告的父类,并赋给广告和游记一个type值
 * 将在RecyclerView的适配器中以两个ViewHolder的形式出现
 *
 */
public class MainContentBean {
    public int type;
    public AdBean adBean;
    public TravelNotesBean travelNotesBean;

}

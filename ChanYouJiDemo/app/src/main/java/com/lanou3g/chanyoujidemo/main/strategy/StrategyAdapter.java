package com.lanou3g.chanyoujidemo.main.strategy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.main.bean.StrategyBean;
import com.lanou3g.chanyoujidemo.util.ScreenUtils;

import java.util.List;

/**
 * Created by ${jl} on 16/5/14.
 */
public class StrategyAdapter extends BaseAdapter {

    List<StrategyBean> strategyBeanList;
    Context context ;
    String[] area  = {"国外·亚洲" , "国外·欧洲" , "美洲、大洋洲、非洲及南极洲" ,"国内·港澳台" ,"国内·大陆"};

    public StrategyAdapter(Context context) {
        this.context = context;
    }

    public void setStrategyBeanList(List<StrategyBean> strategyBeanList) {
        this.strategyBeanList = strategyBeanList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return strategyBeanList == null? 0:strategyBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_strategy_fragment_lv,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        StrategyGridAdapter strategyGridAdapter = new StrategyGridAdapter(context);
        strategyGridAdapter.setDestinations(strategyBeanList.get(position).getDestinations());



        viewHolder.gridView.setAdapter(strategyGridAdapter);

        viewHolder.textView.setText(area[position].toString());

        return convertView;
    }

    class ViewHolder{
        GridView gridView;
        TextView textView;

        public ViewHolder(View view) {
            gridView = (GridView) view.findViewById(R.id.item_strategy_lv_gv);
            textView = (TextView) view.findViewById(R.id.item_strategy_lv_tv);
        }
    }




}

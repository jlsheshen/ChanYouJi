package com.lanou3g.chanyoujidemo.main.strategy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.main.bean.StrategyBean;
import com.lanou3g.chanyoujidemo.util.ScreenUtils;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 *
 * Created by ${jl} on 16/5/14.
 */
public class StrategyGridAdapter extends BaseAdapter {

    Context context;
    List<StrategyBean.DestinationsBean> destinations;

    public StrategyGridAdapter(Context context) {
        this.context = context;
    }

    public void setDestinations(List<StrategyBean.DestinationsBean> destinations) {
        this.destinations = destinations;
    }

    @Override
    public int getCount() {
        return destinations == null ? 0: destinations.size();
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
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_strategy_lv_gv,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.chineseTv.setText(destinations.get(position).getName_zh_cn());
        viewHolder.englishTv.setText(destinations.get(position).getName_en());
        viewHolder.countTv.setText(destinations.get(position).getPoi_count() + "旅行地");
        ScreenUtils screenUtils = new ScreenUtils();
        viewHolder.imageView.setMinimumWidth(screenUtils.getScreenWidth(context)/2);
        Picasso.with(context).load(destinations.get(position).getImage_url()).into(viewHolder.imageView);
        return convertView;
    }
    class ViewHolder{
        TextView chineseTv,englishTv,countTv;
        ImageView imageView;

        public ViewHolder(View view) {
            chineseTv = (TextView) view.findViewById(R.id.strategy_lv_gv_chinese_tv);
            englishTv = (TextView) view.findViewById(R.id.strategy_lv_gv_english_tv);
            countTv = (TextView) view.findViewById(R.id.strategy_lv_gv_count_tv);
            imageView = (ImageView) view.findViewById(R.id.strategy_lv_gv_bacground_iv);

        }
    }
}

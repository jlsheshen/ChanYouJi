package com.lanou3g.chanyoujidemo.main.travels;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.main.bean.MainContentBean;

import java.util.List;

/**
 * Created by ${jl} on 16/5/10.
 */
public class TravelsAdapter extends RecyclerView.Adapter {
    List<MainContentBean> mainContentBeanList;
    Context context;

    public TravelsAdapter(Context context) {
        this.context = context;
    }

    public void setMainContentBeanList(List<MainContentBean> mainContentBeanList) {
        this.mainContentBeanList = mainContentBeanList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 0;
    }
    class adViedHolder extends RecyclerView.ViewHolder{
        TextView nameTv,dateTv;
        ImageView backgroundIv,userIv;
        public adViedHolder(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.item_travel_rv_travelname_tv);
            dateTv = (TextView) itemView.findViewById(R.id.item_travel_rv_traveldate_tv);
            backgroundIv = (ImageView) itemView.findViewById(R.id.item_travel_rv_background_iv);
            userIv = (ImageView) itemView.findViewById(R.id.item_travel_rv_user_iv);

        }
    }



}

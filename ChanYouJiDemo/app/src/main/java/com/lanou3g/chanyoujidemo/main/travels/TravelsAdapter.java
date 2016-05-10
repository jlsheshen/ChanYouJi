package com.lanou3g.chanyoujidemo.main.travels;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.main.bean.MainContentBean;
import com.lanou3g.chanyoujidemo.main.bean.TravelNotesBean;

import java.util.List;

/**
 * Created by ${jl} on 16/5/10.
 */
public class TravelsAdapter extends RecyclerView.Adapter {
   // List<MainContentBean> mainContentBeanList;
    Context context;
    List<TravelNotesBean> travelNotesBeanList;

    public void setTravelNotesBeanList(List<TravelNotesBean> travelNotesBeanList) {
        Log.d("TravelsFragment", "-----------数据传输到adapter" );
        this.travelNotesBeanList = travelNotesBeanList;
        notifyDataSetChanged();
    }

    public TravelsAdapter(Context context) {
        this.context = context;
    }

//    public void setMainContentBeanList(List<MainContentBean> mainContentBeanList) {
//        this.mainContentBeanList = mainContentBeanList;
//        Log.d("TravelsFragment", "-----------数据传输到adapter" );
//        notifyDataSetChanged();
//    }

    @Override
    public int getItemViewType(int position) {
        Log.d("TravelsFragment", "-----------getItemViewType" );
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       RecyclerView.ViewHolder holder = null;
        Log.d("TravelsFragment", "-----------onCreateViewHolder" );
        switch (viewType){
            case 1:
                holder = new TravelViedHolder(LayoutInflater.from(context).inflate(R.layout.item_travel_fragment_rv,parent,false));
                break;
        }



        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d("TravelsFragment", "-----------onBindViewHolder" );
        int type= getItemViewType(position);
        switch (type){
            case 1:
                TravelNotesBean travelNotesBean = travelNotesBeanList.get(position);
                TravelViedHolder travelViedHolder = (TravelViedHolder) holder;
                travelViedHolder.nameTv.setText(travelNotesBean.getName());

                travelViedHolder.dateTv.setText(travelNotesBean.getStart_date() + "/" +
                 travelNotesBean.getDays() + "天," +
                travelNotesBean.getPhotos_count() + "图");
                Log.d("TravelsAdapter", travelNotesBean.getFront_cover_photo_url());
                Log.d("TravelsAdapter", travelNotesBean.getUser().getImage());

        }


    }



    @Override
    public int getItemCount() {
        Log.d("TravelsFragment", "-----------getItemCount" + travelNotesBeanList.size());
        return travelNotesBeanList == null? 0:travelNotesBeanList.size();
    }
    class TravelViedHolder extends RecyclerView.ViewHolder{
        TextView nameTv,dateTv;
        ImageView backgroundIv,userIv;
        public TravelViedHolder(View itemView) {
            super(itemView);
            Log.d("TravelsFragment", "----------ravelViedHolder" );
            nameTv = (TextView) itemView.findViewById(R.id.item_travel_rv_travelname_tv);
            dateTv = (TextView) itemView.findViewById(R.id.item_travel_rv_traveldate_tv);
            backgroundIv = (ImageView) itemView.findViewById(R.id.item_travel_rv_background_iv);
            userIv = (ImageView) itemView.findViewById(R.id.item_travel_rv_user_iv);

        }
    }



}

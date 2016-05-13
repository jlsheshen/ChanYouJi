package com.lanou3g.chanyoujidemo.main.travels;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.main.bean.AdBean;
import com.lanou3g.chanyoujidemo.main.bean.TravelNotesBean;
import com.panxw.android.imageindicator.ImageIndicatorView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${jl} on 16/5/10.
 */
public class TravelsAdapter extends RecyclerView.Adapter {
   // List<MainContentBean> mainContentBeanList;
    Context context;
    List<TravelNotesBean> travelNotesBeanList;
    List<AdBean> adBeanList;
    int adPos = 0;

    public void setTravelNotesBeanList(List<TravelNotesBean> travelNotesBeanList) {

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


    public void setAdBeanList(List<AdBean> adBeanList) {
        this.adBeanList = adBeanList;
      //  notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("TravelsAdapter", "--------------getItemViewType" + position);


        if (travelNotesBeanList.get(position ) != null){
            return 1;
        } else if (position == 0){
            return 2;
        }

        return 3;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       RecyclerView.ViewHolder holder = null;
        Log.d("TravelsAdapter", "travelNotesBeanList.get(position):  viewType = " + viewType);

        switch (viewType){
            case 1:
                holder = new TravelViewHolder(LayoutInflater.from(context).inflate(R.layout.item_travel_fragment_rv,parent,false));
                break;
            case 2:
                holder = new AdHeadViewHolder(LayoutInflater.from(context).inflate(R.layout.item_travel_adhead_fragment_rv,parent,false));

                break;
            case 3:
                holder = new AdBodyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_travel_adbody_fragment_rv,parent,false));

                break;

        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        int type= getItemViewType(position);
        Log.d("TravelsAdapter", "travelNotesBeanList.get(position):  type = " + type);
        switch (type){
            case 1:
                final TravelNotesBean travelNotesBean = travelNotesBeanList.get(position);
               // Log.d("TravelsAdapter", "travelNotesBean:" + travelNotesBean);
//                List<TravelNotesBean> travelNotesBeen = new ArrayList<>();
//                travelNotesBeen.add(travelNotesBeanList.get(position));
                final TravelViewHolder travelViedHolder = (TravelViewHolder) holder;

                travelViedHolder.nameTv.setText(travelNotesBean.getName().toString());

                travelViedHolder.dateTv.setText(travelNotesBean.getStart_date() + "/" +
                        travelNotesBean.getDays() + "天," +
                        travelNotesBean.getPhotos_count() + "图");

                getImage(travelNotesBean.getFront_cover_photo_url(),travelViedHolder.backgroundIv);
                getImage(travelNotesBean.getUser().getImage(),travelViedHolder.userIv);

                Log.d("TravelsAdapter", travelNotesBean.getFront_cover_photo_url());
                Log.d("TravelsAdapter", travelNotesBean.getUser().getImage());
                break;
            case 2:
                AdBean adBean = adBeanList.get(0);


                AdHeadViewHolder adHeadViewHolder = (AdHeadViewHolder) holder;



                getImage(adBean.getImage_url(),adHeadViewHolder.adIv);
                break;

            case 3:
                adBean = adBeanList.get(2);
                AdBodyViewHolder adBodyViewHolder = (AdBodyViewHolder) holder;
                getImage(adBean.getImage_url(),adBodyViewHolder.leftIv);
                adBean = adBeanList.get(3);
                getImage(adBean.getImage_url(),adBodyViewHolder.rightIv);
                break;
        }
    }

    @Override
    public int getItemCount() {
        Log.d("TravelsFragment", "-----------getItemCount" + travelNotesBeanList.size());
        return travelNotesBeanList == null? 0:travelNotesBeanList.size();
    }


    public void getImage(String path, final ImageView imageView){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        ImageRequest imageRequest = new ImageRequest(path, new Response.Listener<Bitmap>() {

            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, 0, 0, Bitmap.Config.ALPHA_8, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(imageRequest);

    }

    class TravelViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv,dateTv;
        ImageView backgroundIv,userIv;
        public TravelViewHolder(View itemView) {
            super(itemView);

            nameTv = (TextView) itemView.findViewById(R.id.item_travel_rv_travelname_tv);
            dateTv = (TextView) itemView.findViewById(R.id.item_travel_rv_traveldate_tv);
            backgroundIv = (ImageView) itemView.findViewById(R.id.item_travel_rv_background_iv);
            userIv = (ImageView) itemView.findViewById(R.id.item_travel_rv_user_iv);

        }
    }
    class AdHeadViewHolder extends RecyclerView.ViewHolder{
        ImageView adIv;
        public AdHeadViewHolder(View itemView) {
            super(itemView);

            adIv = (ImageView) itemView.findViewById(R.id.item_travel_rv_head_iv);

        }
    }
    class AdBodyViewHolder extends RecyclerView.ViewHolder{
        ImageView leftIv,rightIv;
        public AdBodyViewHolder(View itemView) {
            super(itemView);

            leftIv = (ImageView) itemView.findViewById(R.id.item_travel_ad_rv_left_iv);
            rightIv = (ImageView) itemView.findViewById(R.id.item_travel_ad_rv_right_iv);

        }
    }
}

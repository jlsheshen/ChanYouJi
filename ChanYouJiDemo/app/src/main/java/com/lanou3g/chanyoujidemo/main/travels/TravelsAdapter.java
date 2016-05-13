package com.lanou3g.chanyoujidemo.main.travels;

import android.content.Context;
import android.graphics.Bitmap;
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
import com.lanou3g.chanyoujidemo.main.util.ScreenUtils;
import com.lanou3g.chanyoujidemo.main.view.SlidingAdView;

import java.util.List;

/**
 * Created by ${jl} on 16/5/10.
 */
public class TravelsAdapter extends RecyclerView.Adapter implements SlidingAdView.SlidingListener{
   // List<MainContentBean> mainContentBeanList;
    Context context;
    List<TravelNotesBean> travelNotesBeanList;
    List<AdBean> adBeanList;
    private SlidingAdView slidingAdView;

    public void setTravelNotesBeanList(List<TravelNotesBean> travelNotesBeanList) {

        this.travelNotesBeanList = travelNotesBeanList;
        notifyDataSetChanged();
    }

    public TravelsAdapter(Context context) {
        this.context = context;
    }

    public void setAdBeanList(List<AdBean> adBeanList) {
        this.adBeanList = adBeanList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
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


                break;
            case 2:


                AdHeadViewHolder adHeadViewHolder = (AdHeadViewHolder) holder;

                final ViewGroup.LayoutParams layoutParams  = adHeadViewHolder.fristAdIv.getLayoutParams();

                layoutParams.width = ScreenUtils.getScreenWidth(context);
                adHeadViewHolder.fristAdIv.setLayoutParams(layoutParams);
                adHeadViewHolder.secondAdIv.setLayoutParams(layoutParams);



                getImage(adBeanList.get(0).getImage_url(),adHeadViewHolder.fristAdIv);

                getImage(adBeanList.get(1).getImage_url(),adHeadViewHolder.secondAdIv);
                break;

            case 3:
                AdBean adBean = adBeanList.get(2);
                AdBodyViewHolder adBodyViewHolder = (AdBodyViewHolder) holder;
                getImage(adBean.getImage_url(),adBodyViewHolder.leftIv);
                adBean = adBeanList.get(3);
                getImage(adBean.getImage_url(),adBodyViewHolder.rightIv);
                break;
        }
    }

    @Override
    public int getItemCount() {

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

    @Override
    public void onMove(SlidingAdView slidingAdView) {
        if (this.slidingAdView != slidingAdView){
            if (this.slidingAdView != null){

                this.slidingAdView.returnView();
            }

        }

    }

    @Override
    public void onTwoView(SlidingAdView slidingAdView) {
        this.slidingAdView = slidingAdView;

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
        ImageView fristAdIv,secondAdIv;
        public AdHeadViewHolder(View itemView) {
            super(itemView);

            fristAdIv = (ImageView) itemView.findViewById(R.id.item_travel_ad_head_frist_iv);
            secondAdIv = (ImageView) itemView.findViewById(R.id.item_travel_ad_head_second_iv);

            ((SlidingAdView)itemView).setSlidingListener(TravelsAdapter.this,context);

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

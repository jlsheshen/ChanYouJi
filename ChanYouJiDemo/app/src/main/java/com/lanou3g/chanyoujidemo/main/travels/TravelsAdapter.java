package com.lanou3g.chanyoujidemo.main.travels;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
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
import com.lanou3g.chanyoujidemo.util.OnClickTravelItemListener;


import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${jl} on 16/5/10.
 */
public class TravelsAdapter extends RecyclerView.Adapter{
   // List<MainContentBean> mainContentBeanList;
    Context context;
    List<TravelNotesBean> travelNotesBeanList;
    List<AdBean> adBeanList;
    List<String> adHeadList;
    List<AdBean> adBodyList;
    public boolean adHead;
    OnClickTravelItemListener onClickTravelItemListener;

    public void setOnClickTravelItemListene(OnClickTravelItemListener onClickTravelItemListener) {
        this.onClickTravelItemListener = onClickTravelItemListener;
    }

    public void setTravelNotesBeanList(List<TravelNotesBean> travelNotesBeanList) {

        this.travelNotesBeanList = travelNotesBeanList;
        notifyDataSetChanged();
    }

    public TravelsAdapter(Context context) {
        this.context = context;
        adHead = true;
    }

    public void setAdBeanList(List<AdBean> adBeanList) {
        this.adBeanList = adBeanList;
        adHeadList = new ArrayList<>();
        adBodyList = new ArrayList<>();
        for (AdBean adBean : adBeanList) {

            if (adBean.isRotation()){

                adHeadList.add(adBean.getImage_url());
            }else {

                adBodyList.add(adBean);
            }

        }

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
        switch (type){
            case 1:
                final TravelNotesBean travelNotesBean = travelNotesBeanList.get(position);
                final TravelViewHolder travelViedHolder = (TravelViewHolder) holder;
                travelViedHolder.nameTv.setText(travelNotesBean.getName().toString());

                travelViedHolder.dateTv.setText(travelNotesBean.getStart_date() + "/" +
                        travelNotesBean.getDays() + "天," +
                        travelNotesBean.getPhotos_count() + "图");

                Picasso.with(context).load(travelNotesBean.getFront_cover_photo_url()).into(travelViedHolder.backgroundIv);
                Picasso.with(context).load(travelNotesBean.getUser().getImage()).into(travelViedHolder.userIv);
                travelViedHolder.backgroundIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickTravelItemListener.getUrlString(travelNotesBean.getId());

                    }
                });




                break;
            case 2:

                final AdHeadViewHolder adHeadViewHolder = (AdHeadViewHolder) holder;
                AdHeadAdapter adHeadAdapter = new AdHeadAdapter(context);
                adHeadAdapter.setUrls(adHeadList);
                adHeadViewHolder.viewPager.setAdapter(adHeadAdapter);
                adHeadViewHolder.tabLayout.setupWithViewPager(adHeadViewHolder.viewPager);
                new ViewPagerTask().execute(adHeadViewHolder);

                for (int i = 0 ;i< adHeadList.size();i++) {
                    adHeadViewHolder.tabLayout.getTabAt(i).setIcon(R.drawable.travel_ad_head_selector);
                }
                break;

            case 3:

                AdBodyViewHolder adBodyViewHolder = (AdBodyViewHolder) holder;
                Picasso.with(context).load(adBodyList.get(0).getImage_url()).into(adBodyViewHolder.leftIv);
                Picasso.with(context).load(adBodyList.get(1).getImage_url()).into(adBodyViewHolder.rightIv);

                break;
        }
    }

    @Override
    public int getItemCount() {

        return travelNotesBeanList == null? 0:travelNotesBeanList.size();
    }


//    public void getImage(String path, final ImageView imageView){
//        RequestQueue requestQueue = Volley.newRequestQueue(context);
//        ImageRequest imageRequest = new ImageRequest(path, new Response.Listener<Bitmap>() {
//
//            @Override
//            public void onResponse(Bitmap response) {
//                imageView.setImageBitmap(response);
//            }
//        }, 0, 0, Bitmap.Config.ALPHA_8, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(imageRequest);
//
//    }



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
        ViewPager viewPager;
        TabLayout tabLayout;
        public AdHeadViewHolder(View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.item_travel_ad_rv_head_vp);
            tabLayout = (TabLayout) itemView.findViewById(R.id.item_travel_ad_rv_head_tab);
            viewPager.setCurrentItem(0);

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
    class ViewPagerTask extends AsyncTask<AdHeadViewHolder,Integer,Void>{
        int currentItem = 0;
        ViewPager vp;

        @Override
        protected Void doInBackground(AdHeadViewHolder... params) {
            vp = params[0].viewPager;
            while (adHead){

            try {
                Thread.sleep(5000);

                currentItem = (currentItem + 1)%adHeadList.size();
                publishProgress(currentItem);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            }return null;


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            vp.setCurrentItem(values[0]);
        }

    }
    public void setAdHeadBoolean(){
        adHead = false;
    }







}

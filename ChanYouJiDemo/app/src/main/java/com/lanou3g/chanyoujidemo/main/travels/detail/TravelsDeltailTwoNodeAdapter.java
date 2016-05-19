package com.lanou3g.chanyoujidemo.main.travels.detail;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.main.view.RecyclerOrListImageView;
import com.lanou3g.chanyoujidemo.util.ScreenUtils;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${jl} on 16/5/18.
 */
public class TravelsDeltailTwoNodeAdapter extends BaseAdapter {
    Context context;
    List<TravelsDeltailBean.TripDaysBean.NodesBean.NotesBean> data;
    String adressNmae;

    public void setAdressNmae(String adressNmae) {
        this.adressNmae = adressNmae;
    }

    public TravelsDeltailTwoNodeAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<TravelsDeltailBean.TripDaysBean.NodesBean.NotesBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data == null?0:data.size();
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
        ImageViewHolder imageViewHolder = null;
       if (convertView == null) {
           convertView = LayoutInflater.from(context).inflate(R.layout.item_travel_detail_three, parent, false);
           imageViewHolder = new ImageViewHolder(convertView);
           convertView.setTag(imageViewHolder);
       }else {
           imageViewHolder = (ImageViewHolder) convertView.getTag();
       }
        if (adressNmae!=null){

            imageViewHolder.adressBtn.setText(adressNmae);
        }else {
            imageViewHolder.adressBtn.setVisibility(View.GONE);

        }



        if (data.get(position).getDescription()!=null){
            Log.d("TravelsDeltailTwoNodeAd", data.get(position).getDescription().toString());
            imageViewHolder.descriptionTv.setText("  " + data.get(position).getDescription().toString());}

        if(data.get(position).getPhoto()!=null){
            Log.d("TravelsDeltailTwoNodeAd", "------------我要显示图片!!!!!!!!!!!!!!!");

        Picasso.with(context).load(data.get(position).getPhoto().getUrl()).resize(ScreenUtils.getScreenWidth(context)/2,
                ScreenUtils.getScreenWidth(context)/2).centerCrop().tag("888").into(imageViewHolder.imageView);
        }




        return convertView;
    }
    class ImageViewHolder{
        RecyclerOrListImageView imageView;
        TextView descriptionTv;
        Button adressBtn, likeBtn, sayBtn;


        public ImageViewHolder(View view) {
            imageView = (RecyclerOrListImageView) view.findViewById(R.id.item_travel_detail_three_iv);
            descriptionTv = (TextView) view.findViewById(R.id.item_travel_detail_three_tv);
            adressBtn = (Button) view.findViewById(R.id.item_travel_detail_three_adress_btn);
            likeBtn = (Button) view.findViewById(R.id.item_travel_detail_three_like_btn);
            sayBtn = (Button) view.findViewById(R.id.item_travel_detail_three_say_btn);

        }
    }





}

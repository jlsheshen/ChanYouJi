package com.lanou3g.chanyoujidemo.main.travels.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ${jl} on 16/5/19.
 */
public class popupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


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

    class DayViewHolder extends RecyclerView.ViewHolder{

        public DayViewHolder(View itemView) {
            super(itemView);
        }
    }
    class Addrss extends RecyclerView.ViewHolder{


        public Addrss(View itemView) {
            super(itemView);
        }
    }
}

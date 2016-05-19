package com.lanou3g.chanyoujidemo.main.travels.detail;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.main.view.MainListView;

import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${jl} on 16/5/17.
 */
public class TravelsDeltailAdapter extends BaseExpandableListAdapter {

    Context context;
    TravelsDeltailBean data;
    MainListView listView;
    TravelsDeltailTwoNodeAdapter travelsDeltailTwoNodeAdapter;
    int groupPosition;


    public void setData(TravelsDeltailBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public TravelsDeltailAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getChildrenCount(int groupPosition) {

        return data.getTrip_days().get(groupPosition).getNodes() == null?
                0:data.getTrip_days().get(groupPosition).getNodes().size();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return data.getTrip_days().get(groupPosition).getNodes().get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return data.getTrip_days().get(groupPosition).getNodes().get(childPosition).getId();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
       // String string = data.getTrip_days().get(groupPosition).getNodes().get(childPosition).toString();
       // groupPosition = this.groupPosition;
        convertView = LayoutInflater.from(context).inflate(R.layout.item_travel_detail_two,parent,false);
        listView = (MainListView) convertView.findViewById(R.id.item_travel_detail_two_lv);
         travelsDeltailTwoNodeAdapter = new TravelsDeltailTwoNodeAdapter(context);
        listView.setAdapter(travelsDeltailTwoNodeAdapter);
        travelsDeltailTwoNodeAdapter.setAdressNmae((String) data.getTrip_days().get(groupPosition).getNodes().get(childPosition).getEntry_name());
        travelsDeltailTwoNodeAdapter.setData(data.getTrip_days().get(groupPosition).getNodes().get(childPosition).getNotes());

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == ListView.OnScrollListener.SCROLL_STATE_IDLE)

                {
                    Picasso.with(context).resumeTag("888");
                }
                else
                {
                    Picasso.with(context).pauseTag("888");
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });



        return convertView;
    }



    @Override
    public Object getGroup(int groupPosition) {
        return data.getTrip_days().get(groupPosition).getDay();
    }

    @Override
    public int getGroupCount() {
        return data == null? 0:data.getTrip_days().size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return data.getTrip_days().get(groupPosition).getId();
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {


        convertView = LayoutInflater.from(context).inflate(R.layout.item_travel_detail_one,parent,false);
        TextView textView = (TextView) convertView.findViewById(R.id.item_travel_detail_one_tv);
        textView.setText("Day" + data.getTrip_days().get(groupPosition).getDay());


        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }



}




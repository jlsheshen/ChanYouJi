package com.lanou3g.chanyoujidemo.main.travels.detail;


import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.PopupWindow;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.base.BaseActivity;
import com.lanou3g.chanyoujidemo.base.SingleRequestQueue;

import java.util.List;

/**
 * Created by ${jl} on 16/5/13.
 */
public class TravelDeltailActivity extends BaseActivity implements View.OnClickListener {
    ExpandableListView expandableListView;
    TravelsDeltailBean travelsDeltailBean;
    List<TravelsDeltailBean.TripDaysBean> tripDaysBeanList;
    List<TravelsDeltailBean.TripDaysBean.NodesBean> nodesBeanList;
    List<TravelsDeltailBean.TripDaysBean.NodesBean.NotesBean> minNodesBeanList;
    TravelsDeltailAdapter travelsDeltailAdapter;
    PopupWindow popupWindow;
    String url;

    private static final String TRAVEL_DELTAIL_TAG = "travelDeltailTag";


    @Override
    public int setLayout() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initView() {
        expandableListView = (ExpandableListView) findViewById(R.id.treavel_detail_aty_ev);
        findViewById(R.id.detail_activity_popup_btn).setOnClickListener(this);
        initPopup();


    }




    @Override
    protected void initData() {


//        tripDaysBeanList = new ArrayList<>();
//        nodesBeanList = new ArrayList<>();
        getTravelsDeltailData();
//        tripDaysBeanList = travelsDeltailBean.getTrip_days();



    }

    private void getTravelsDeltailData() {
        String url = getIntent().getStringExtra("url");
        Log.d("TravelDeltailActivity", url);


        SingleRequestQueue.getInstance().addRequest(url, new Response.Listener<TravelsDeltailBean>() {

            @Override
            public void onResponse(TravelsDeltailBean response) {

                Log.d("TravelDeltailActivity", "response.getId():------------" + response.getId());

                travelsDeltailBean = response;

                Log.d("TravelDeltailActivity", "travelsDeltailBean.getTrip_days().size():" +(travelsDeltailBean == null?0:travelsDeltailBean.getTrip_days().size()));
                travelsDeltailAdapter = new TravelsDeltailAdapter(TravelDeltailActivity.this);
                travelsDeltailAdapter.setData(travelsDeltailBean);
                expandableListView.setAdapter(travelsDeltailAdapter);

                for(int i = 0; i < travelsDeltailAdapter.getGroupCount(); i++){

                    expandableListView.expandGroup(i);

                }



                //   expandableListView.expandGroup(travelsDeltailAdapter.groupPosition);

              //  new AsyncGetChannelTask().execute();



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TravelDeltailActivity","------------"  + error.toString());


            }
        },TRAVEL_DELTAIL_TAG,TravelsDeltailBean.class);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.detail_activity_popup_btn:


                break;

        }


    }

    private void initPopup() {
        popupWindow = new PopupWindow(this);
        View view = LayoutInflater.from(this).inflate(R.layout.popupwindow_travel_detail_test,null);


    }

//    private class AsyncGetChannelTask extends AsyncTask<Void, Void, Integer> {
//
//
//        @Override
//        protected Integer doInBackground(Void... params) {
//            return travelsDeltailAdapter.getGroupPosition();
//        }
//
//        @Override
//        protected void onPostExecute(Integer integer) {
//            expandableListView.expandGroup(integer);
//
//        }
//    }





}

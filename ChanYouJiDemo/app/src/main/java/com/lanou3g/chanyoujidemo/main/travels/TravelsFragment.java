package com.lanou3g.chanyoujidemo.main.travels;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.reflect.TypeToken;
import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.base.BaseFragment;
import com.lanou3g.chanyoujidemo.base.SingleRequestQueue;
import com.lanou3g.chanyoujidemo.main.MainActivity;
import com.lanou3g.chanyoujidemo.main.MyValuse.MyUrl;
import com.lanou3g.chanyoujidemo.main.bean.AdBean;

import com.lanou3g.chanyoujidemo.main.bean.TravelNotesBean;
import com.lanou3g.chanyoujidemo.main.travels.detail.TravelDeltailActivity;
import com.lanou3g.chanyoujidemo.util.OnClickTravelItemListener;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by ${jl} on 16/5/9.
 * 游记页面
 */
public class TravelsFragment extends BaseFragment implements OnClickTravelItemListener{
    RecyclerView recyclerView;
    TravelsAdapter travelsAdapter;
    public static final String TRAVELS_TAG = "travelsTag";

    @Override
    protected int initLayout() {
        return R.layout.fragment_travels;
    }

    @Override
    protected void initData() {

        travelsAdapter = new TravelsAdapter(context);
        travelsAdapter.setOnClickTravelItemListene(this);

        getTravleAD();

        getTravleContent();


    }

    @Override
    protected void initView(View view) {
        recyclerView = bindView(R.id.travels_fragment_rv);

    }

    public void getTravleContent() {

        Type type = new TypeToken<ArrayList<TravelNotesBean>>(){}.getType();
        SingleRequestQueue.getInstance().addArrayRequest(MyUrl.TRAVEL_CONTENT_URL, type,
                new Response.Listener<ArrayList<TravelNotesBean>>() {

                    @Override
                    public void onResponse(ArrayList<TravelNotesBean> response) {



                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                        response.add(0, null);
                        response.add(3, null);
                        travelsAdapter.setTravelNotesBeanList(response);
                        recyclerView.setAdapter(travelsAdapter);


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                },TRAVELS_TAG);


    }

    public void getTravleAD() {


        Type type = new TypeToken<ArrayList<AdBean>>(){}.getType();
        SingleRequestQueue.getInstance().addArrayRequest(MyUrl.TRAVEL_AD_URL, type,
                new Response.Listener<ArrayList<AdBean>>() {

                    @Override
                    public void onResponse(ArrayList<AdBean> response) {
                        travelsAdapter.setAdBeanList(response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                },TRAVELS_TAG);


    }

    @Override
    public void onStop() {
        SingleRequestQueue.getInstance().removeRequest(TRAVELS_TAG);
        super.onStop();
    }

    @Override
    public void onPause() {
        travelsAdapter.setAdHeadBoolean();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        travelsAdapter.setAdHeadBoolean();
        super.onDestroy();
    }

    @Override
    public void getUrlString(int id) {
        String url = MyUrl.TRAVEL_DETAIL_START_URL + id + MyUrl.TRAVEL_DETAIL_END_URL;

        Intent intent = new Intent();
        intent.setClass(context, TravelDeltailActivity.class);
        intent.putExtra("url",url);
        context.startActivity(intent);

    }
}

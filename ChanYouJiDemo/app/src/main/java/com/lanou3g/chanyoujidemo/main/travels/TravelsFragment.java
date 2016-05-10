package com.lanou3g.chanyoujidemo.main.travels;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.base.BaseFragment;
import com.lanou3g.chanyoujidemo.main.MyValuse.MyUrl;
import com.lanou3g.chanyoujidemo.main.bean.MainContentBean;
import com.lanou3g.chanyoujidemo.main.bean.TravelNotesBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${jl} on 16/5/9.
 * 游记页面
 */
public class TravelsFragment extends BaseFragment {
    List<MainContentBean> mainContentBeanList;
    RecyclerView recyclerView;
    TravelsAdapter travelsAdapter;
    List<TravelNotesBean> traveBeanList;

    @Override
    protected int initLayout() {
        return R.layout.fragment_travels;
    }

    @Override
    protected void initData() {


       // RequestQueue requestQueue = Volley.newRequestQueue(MyApplication.context);
        traveBeanList = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(MyUrl.TRAVEL_CONTENT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TravelsFragment", "-----------" + response);
                Gson gson = new Gson();
                traveBeanList = gson.fromJson(response,List.class);
                Log.d("TravelsFragment", "traveBeanList==null:" + traveBeanList.size());



                travelsAdapter = new TravelsAdapter(context);
                recyclerView = bindView(R.id.travels_fragment_rv);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
               // toMainBean(traveBeanList);
                travelsAdapter.setTravelNotesBeanList(traveBeanList);
                recyclerView.setAdapter(travelsAdapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TravelsFragment", "-----------" + error.toString());
            }
        });
        requestQueue.add(stringRequest);


    }




    @Override
    protected void initView(View view) {
        recyclerView = bindView(R.id.travels_fragment_rv);



    }

    public List<MainContentBean> toMainBean(List<TravelNotesBean> list){
        Log.d("TravelsFragment", "traveBeanList==null:" + (traveBeanList == null));
//        for (TravelNotesBean travelNotesBean : traveBeanList) {
//            mainContentBeanList.add(travelNotesBean);
//        }
            mainContentBeanList = new ArrayList<>();
        for(int i = 0;i<traveBeanList.size();i++){

            MainContentBean mainContentBean = new MainContentBean();
            TravelNotesBean travelNotesBean= traveBeanList.get(i);
            mainContentBean.travelNotesBean = travelNotesBean;

            mainContentBeanList.add(mainContentBean.travelNotesBean);
            Log.d("TravelsFragment", "+++++" + mainContentBeanList.get(i).travelNotesBean.getDays());
        }


        return mainContentBeanList;
    }


}

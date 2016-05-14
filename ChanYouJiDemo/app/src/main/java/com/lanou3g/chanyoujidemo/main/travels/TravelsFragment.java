package com.lanou3g.chanyoujidemo.main.travels;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.base.BaseFragment;
import com.lanou3g.chanyoujidemo.main.MyValuse.MyUrl;
import com.lanou3g.chanyoujidemo.main.bean.AdBean;

import com.lanou3g.chanyoujidemo.main.bean.TravelNotesBean;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${jl} on 16/5/9.
 * 游记页面
 */
public class TravelsFragment extends BaseFragment {
    RecyclerView recyclerView;
    TravelsAdapter travelsAdapter;
    List<TravelNotesBean> traveBeanList;
    List<AdBean> adBeanList;
    RequestQueue requestQueue;





    @Override
    protected int initLayout() {
        return R.layout.fragment_travels;
    }

    @Override
    protected void initData() {
        requestQueue = Volley.newRequestQueue(context);
        travelsAdapter = new TravelsAdapter(context);

        getTravleAD();

        getTravleContent();


    }

    @Override
    protected void initView(View view) {
        recyclerView = bindView(R.id.travels_fragment_rv);

    }

    public void getTravleContent() {
        traveBeanList = new ArrayList<>();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(MyUrl.TRAVEL_CONTENT_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Gson gson = new Gson();

                Type type = new TypeToken<ArrayList<TravelNotesBean>>() {
                }.getType();

                traveBeanList = gson.fromJson(String.valueOf(response), type);


                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                traveBeanList.add(0, null);
                traveBeanList.add(3, null);

                travelsAdapter.setTravelNotesBeanList(traveBeanList);

                recyclerView.setAdapter(travelsAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);

    }

    public void getTravleAD() {
        adBeanList = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(MyUrl.TRAVEL_AD_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Gson gson = new Gson();

                Type type = new TypeToken<ArrayList<AdBean>>() {
                }.getType();

                adBeanList = gson.fromJson(String.valueOf(response), type);

                travelsAdapter.setAdBeanList(adBeanList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onPause() {
        travelsAdapter.setAdHead();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        travelsAdapter.setAdHead();
        super.onDestroy();
    }
}

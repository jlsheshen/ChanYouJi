package com.lanou3g.chanyoujidemo.main.travels;

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
import com.lanou3g.chanyoujidemo.base.MyApplication;
import com.lanou3g.chanyoujidemo.main.MyValuse.MyUrl;
import com.lanou3g.chanyoujidemo.main.bean.AdBean;
import com.lanou3g.chanyoujidemo.main.bean.MainContentBean;
import com.lanou3g.chanyoujidemo.main.bean.TravelNotesBean;
import com.lanou3g.chanyoujidemo.main.interface_package.SetBean;
import com.lanou3g.chanyoujidemo.main.util.StringRequestUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by ${jl} on 16/5/9.
 * 游记页面
 */
public class TravelsFragment extends BaseFragment {
    List<MainContentBean> mainContentBeanList;
    RecyclerView recyclerView;
    //List<TravelNotesBean> traveBeanList;

    @Override
    protected int initLayout() {
        return R.layout.fragment_travels;
    }

    @Override
    protected void initData() {


        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(MyUrl.TRAVEL_CONTENT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                TravelNotesBean traveBean = gson.fromJson(response, TravelNotesBean.class);
                mainContentBeanList.add(traveBean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(stringRequest);
    }




    @Override
    protected void initView(View view) {
        recyclerView = bindView(R.id.travels_fragment_rv);

    }


}

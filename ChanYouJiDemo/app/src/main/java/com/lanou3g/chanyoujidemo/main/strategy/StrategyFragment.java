package com.lanou3g.chanyoujidemo.main.strategy;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;


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
import com.lanou3g.chanyoujidemo.main.bean.StrategyBean;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${jl} on 16/5/9.
 * 攻略页面
 *
 */
public class StrategyFragment extends BaseFragment {
    ListView listView;
    List<StrategyBean> strategyBeanList;
    RequestQueue requestQueue;
    StrategyAdapter steategyAdapter;
    @Override
    protected int initLayout() {
        return R.layout.fragment_strategy;
    }

    @Override
    protected void initData() {
        requestQueue = Volley.newRequestQueue(context);
        steategyAdapter  = new StrategyAdapter(context);

        getStrategyData();

        steategyAdapter.setStrategyBeanList(strategyBeanList);
        listView.setAdapter(steategyAdapter);





    }

    @Override
    protected void initView(View view) {
        listView = (ListView) view.findViewById(R.id.strategy_fragment_lv);
        LinearLayout headViewLayout  = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.strategy_lv_head,null);
        listView.addHeaderView(headViewLayout);


    }


    public void getStrategyData() {
        strategyBeanList = new ArrayList<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(MyUrl.STRATEGY_CONTENT_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<StrategyBean>>() {
                }.getType();
                strategyBeanList = gson.fromJson(String.valueOf(response),type);
                steategyAdapter.setStrategyBeanList(strategyBeanList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}

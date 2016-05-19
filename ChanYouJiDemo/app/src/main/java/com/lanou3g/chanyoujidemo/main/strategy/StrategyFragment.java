package com.lanou3g.chanyoujidemo.main.strategy;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.reflect.TypeToken;
import com.lanou3g.chanyoujidemo.R;
import com.lanou3g.chanyoujidemo.base.BaseFragment;
import com.lanou3g.chanyoujidemo.base.SingleRequestQueue;
import com.lanou3g.chanyoujidemo.main.MyValuse.MyUrl;
import com.lanou3g.chanyoujidemo.main.bean.StrategyBean;

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
    public static final String STRATEGY_TAG = "strategyTag";
    @Override
    protected int initLayout() {
        return R.layout.fragment_strategy;
    }

    @Override
    protected void initData() {
        requestQueue = Volley.newRequestQueue(context);
        steategyAdapter  = new StrategyAdapter(context);
        getStrategyData();
        listView.setAdapter(steategyAdapter);

    }

    @Override
    protected void initView(View view) {
        listView = (ListView) view.findViewById(R.id.strategy_fragment_lv);
        LinearLayout headViewLayout  = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.strategy_lv_head,null);
        listView.addHeaderView(headViewLayout);


    }

    public void getStrategyData() {

        //先创建type为ArrayList的子类,
        final Type type = new TypeToken<ArrayList<StrategyBean>>() {
        }.getType();

        SingleRequestQueue.getInstance().addArrayRequest(MyUrl.STRATEGY_CONTENT_URL, type,
                new Response.Listener<ArrayList<StrategyBean>>() {
                    @Override
                    public void onResponse(ArrayList<StrategyBean> response) {
                        //将获取下来的response未做数据,直接set进adapter中
                        steategyAdapter.setStrategyBeanList(response);
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("StrategyFragment", error.toString());

                    }
                },STRATEGY_TAG);

    }

    @Override
    public void onStop() {
        //在页面停止的时候,按照TAG将其移除
        SingleRequestQueue.getInstance().removeRequest(STRATEGY_TAG);

        super.onStop();
    }
}

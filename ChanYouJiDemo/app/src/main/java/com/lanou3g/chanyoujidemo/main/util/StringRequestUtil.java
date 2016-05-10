package com.lanou3g.chanyoujidemo.main.util;

import android.util.Log;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.lanou3g.chanyoujidemo.base.MyApplication;
import com.lanou3g.chanyoujidemo.main.interface_package.SetBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${jl} on 16/5/10.
 */
public class StringRequestUtil {

     String url;
     MyClass<Object> myClass;
    final List<MyClass<Object>> beans;


    public StringRequestUtil(final MyClass myClass , String url) {

        this.myClass = myClass;

        this.url = url;
        beans = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(MyApplication.context);
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                MyClass myClass1 = myClass;
                myClass1 = (MyClass<Object>) gson.fromJson(response, Object.class);
                beans.add(myClass1);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("StringRequestUtil", error.toString());
            }
        });
        requestQueue.add(stringRequest);

    }
    public class MyClass <Object>{


    }


}

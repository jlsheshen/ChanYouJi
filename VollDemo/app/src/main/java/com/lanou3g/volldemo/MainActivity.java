package com.lanou3g.volldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //第一个参数: 接口网址
        //第二个参数:请求成功时候的回调方法
//        //第三个参数是失败之后回调的方法
        StringRequest request = new StringRequest("http://chanyouji.com/api/trips/featured.json?page=1", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("MainActivity", response);
                Gson gson = new Gson();
                Bean bean = gson.fromJson(response, Bean.class);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("MainActivity", "----" + error);


            }
        });
        requestQueue.add(request);

//        JsonObjectRequest request2 = new JsonObjectRequest("https://chanyouji.com/api/trips/featured.json?page=1",
//                null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.d("MainActivity", "====+++++++" + response);
//            }
//        }
//                , new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("MainActivity", "===" + error);
//            }
//        });
//        requestQueue.add(request2);
    }
}

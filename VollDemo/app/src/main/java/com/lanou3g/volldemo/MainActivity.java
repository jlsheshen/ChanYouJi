package com.lanou3g.volldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;



import it.sephiroth.android.library.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // RequestQueue requestQueue = Volley.newRequestQueue(this);
        //第一个参数: 接口网址
        //第二个参数:请求成功时候的回调方法
//        //第三个参数是失败之后回调的方法
//      StringRequest request = new StringRequest("http://chanyouji.com/api/trips/featured.json?page=1", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.d("MainActivity", response);
//               // Gson gson = new Gson();
//                //Bean bean = gson.fromJson(response, Bean.class);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("MainActivity", "----" + error);
//
//
//            }
//        });
//        requestQueue.add(request);

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

//        GsonRequest<BeanNew> gsonRequest = new GsonRequest(Request.Method.GET,
//                "http://app.api.autohome.com.cn/autov4.8.8/news/shuokelist-pm1-s30-lastid0.json",
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                }
//                , new Response.Listener<BeanNew>() {
//            @Override
//            public void onResponse(BeanNew response) {
//                Log.d("MainActivity", "response.getDays():" + response.getResult().getTotal());
//
//            }
//        },BeanNew.class);
//        requestQueue.add(gsonRequest);

        ImageView imageView = (ImageView) findViewById(R.id.iv);

//        Picasso.with(this).load("http://www2.autoimg.cn/newsdfs/g16/M13/73/8C/1024x512_0_autohomecar__wKjBx1ctTwuAMmaRAAI-ReHh1jQ977.jpg")
//                .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageView);

       // Picasso.with(this).load("http://www2.autoimg.cn/newsdfs/g16/M13/73/8C/1024x512_0_autohomecar__wKjBx1ctTwuAMmaRAAI-ReHh1jQ977.jpg").into(imageView);
        //Picasso.with(this).load("http://www2.autoimg.cn/newsdfs/g16/M13/73/8C/1024x512_0_autohomecar__wKjBx1ctTwuAMmaRAAI-ReHh1jQ977.jpg").into(imageView);
        Picasso.with(this).load("http://www2.autoimg.cn/newsdfs/g16/M13/73/8C/1024x512_0_autohomecar__wKjBx1ctTwuAMmaRAAI-ReHh1jQ977.jpg").into(imageView);
    }
}

package com.lanou3g.volldemo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by ${jl} on 16/5/16.
 */
public class VolleySingle {

    private static Context context;

    private RequestQueue queue;//请求队列

    private static VolleySingle ourInstance ;

    //获取单例的对象
    public static VolleySingle getInstance() {
        if (ourInstance == null){

            synchronized (Volley.class){
                if (ourInstance == null){

                    ourInstance = new VolleySingle(context);
                }

            }

        }


        return ourInstance;
    }

    private VolleySingle(Context context) {
        //获取Application里面的context
        this.context = context.getApplicationContext();
        queue = getQueue();//初始化我的请求队列

    }
    //提供一个方法新建请求队列
    public RequestQueue getQueue(){
        if (queue == null){
            queue = Volley.newRequestQueue(context);
        }
        return queue;
    }
    public static final String TAG = "VolleySingleton";
    //添加请求
    public <T> void _addRequest(Request<T> request){

        request.setTag(TAG);//为我的请求添加标签
        queue.add(request);//将请求添加到队列中

    }
    public <T> void _addRequest (Request<T> request,Object tag){

        request.setTag(TAG);
        queue.add(request);
    }
    public void _addRequest(String url,
                           Response.Listener<String> listener, //这里为我们的成功时候的回调加上String类型的泛型
                           Response.ErrorListener errorListener,Object tag){
        //创建StringRequset 三个参数分别是 url接口网址,成功时候的回调,失败时候的回调
        StringRequest stringRequest = new StringRequest(url,listener,errorListener);
        //将请求加入到队列
        _addRequest(stringRequest,tag);

    }
    public <T>void _addRequest(String url, Class<T> mClass, Response.Listener<T> listener, Response.ErrorListener errorListener ){
        GsonRequest gsonRequest = new GsonRequest(Request.Method.GET,url,errorListener,listener,mClass);
        _addRequest(gsonRequest);
    }
    //这个方法是请求移除队列
    public void removeRequest(Object tag){
        queue.cancelAll(tag);//根据不同的tag移除队列

    }
    public static void addResquset(String url, Response.Listener<String> stringListener,
                                   Response.ErrorListener errorListener){
        //获取单例对象

        getInstance()._addRequest(url,stringListener,errorListener);
    }
    public static  <T> void addResquest(String url, Class<T> mClass, Response.Listener<T> listener, Response.ErrorListener errorListener){
        //同上方法将GsonRequest请求加入单例的队列中
        getInstance()._addRequest(url,mClass,listener,errorListener);

    }


}

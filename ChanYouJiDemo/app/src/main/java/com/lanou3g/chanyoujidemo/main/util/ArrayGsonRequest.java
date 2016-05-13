//package com.lanou3g.chanyoujidemo.main.util;
//
//import com.android.volley.NetworkResponse;
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.toolbox.HttpHeaderParser;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.lanou3g.chanyoujidemo.main.bean.TravelNotesBean;
//
//import java.io.UnsupportedEncodingException;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by ${jl} on 16/5/11.
// */
//public class ArrayGsonRequest<T> extends Request<T> {
//    private Response.Listener mLitener;
//    private Gson myGson;
//    private List<T> myList;
//
//    @Override
//    protected Response<T> parseNetworkResponse(NetworkResponse response) {
//        try {
//
//            Type type = new TypeToken<ArrayList<T>>() {
//            }.getType();
//
//            String data = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
//
//            return Response.success(myGson.fromJson(data,type),
//                            HttpHeaderParser.parseCacheHeaders(response));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    protected void deliverResponse(T response) {
//
//    }
//
//
//
//}

package com.example.pro1;


import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;

public class MyCustomRequest extends Request {
    private Response.Listener listener;

    private Gson gson;

    private TypeToken type;

    private Class responseClass;

    public MyCustomRequest(int method, String url, Class responseClass, TypeToken type, Response.Listener listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        gson = new Gson();
        this.listener = listener;
        this.responseClass = responseClass;
        this.type = type;
    }


    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        try {

            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers, "utf-8"));
            if (type == null)
                return Response.success(gson.fromJson(jsonString, responseClass), HttpHeaderParser.parseCacheHeaders(response));
            else
                return Response.success(gson.fromJson(jsonString, type.getType()), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(Object response) {
        listener.onResponse(response);
    }
}
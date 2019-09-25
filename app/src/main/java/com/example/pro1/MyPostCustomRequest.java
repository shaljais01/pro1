package com.example.pro1;


import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONObject;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;

public class MyPostCustomRequest extends StringRequest {
    private Response.Listener listener;

    private Gson gson;

    private TypeToken type;

    private Class responseClass;

    private String body;

    public MyPostCustomRequest(int method, String url, Class responseClass, TypeToken type, String body, Response.Listener listener, Response.ErrorListener errorListener) {
        super(method, url,listener ,errorListener);
        gson = new Gson();
        this.listener = listener;
        this.responseClass = responseClass;
        this.type = type;
        this.body=body;
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        try {

            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers, "utf-8"));
            if(type==null)
                return Response.success(gson.fromJson(jsonString, responseClass), HttpHeaderParser.parseCacheHeaders(response));
            else
                return Response.success(gson.fromJson(jsonString, type.getType()), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Response.error(new ParseError(e));
        }
    }

    @Override
    public String getBodyContentType() {
        return "application/json; charset=utf-8";
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        try {
            return body == null ? null : body.getBytes("utf-8");
        } catch (UnsupportedEncodingException uee) {

            return null;
        }
    }

}

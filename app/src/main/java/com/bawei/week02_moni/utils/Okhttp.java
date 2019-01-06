package com.bawei.week02_moni.utils;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Okhttp {

    private Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Log.i("Okhttp", "intercept: "+"====拦截前");
            Response response = chain.proceed(request);
            Log.i("Okhttp", "intercept: "+"====拦截后");
            return response;
        }
    };
    private final OkHttpClient okHttpClient;

    private Okhttp() {
        File file = new File(Environment.getExternalStorageDirectory(), "cachell");
        okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(3000, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(3000, TimeUnit.SECONDS)//设置连接超时时间
                .addInterceptor(interceptor)//添加拦截器
                .cache(new Cache(file, 10 * 1024))
                .build();
    }


    public static void okHttpGet(String url, Callback callback) {
        //创建okhttpclient
        OkHttpClient okHttpClient = new OkHttpClient();
        //创建request
        Request request = new Request
                .Builder().url(url)
                .method("GET", null)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public static void okHttpPost(String url, Map<String, String> parms, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();

        for (String key : parms.keySet()) {
            builder.add(key, parms.get(key));
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        client.newCall(request).enqueue(callback);

    }

}

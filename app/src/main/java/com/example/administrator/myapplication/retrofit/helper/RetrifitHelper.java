package com.example.administrator.myapplication.retrofit.helper;

import com.example.administrator.myapplication.retrofit.retrofitService.RetrofitService;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrifitHelper {
    GsonConverterFactory gsonFactory;
    OkHttpClient client;
    private static RetrifitHelper retrifitHelper = null;
    private final Retrofit.Builder retrofitBuilder;
    private static final String WAN_ANDROID_URL = "http://wanandroid.com";

    private RetrifitHelper() {
        gsonFactory = GsonConverterFactory.create(new GsonBuilder().create());
        client = new OkHttpClient();
        retrofitBuilder = new Retrofit
                .Builder()
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(gsonFactory);
    }

    public static RetrifitHelper getInstence() {
        if (retrifitHelper == null) {
            retrifitHelper = new RetrifitHelper();
        }
        return retrifitHelper;
    }

    public RetrofitService getExampleEntityService() {
        return retrofitBuilder
                .baseUrl(WAN_ANDROID_URL)
                .build()
                .create(RetrofitService.class);
    }

}

package com.example.administrator.myapplication.retrofit.retrofitService;

import com.example.administrator.myapplication.entity.ExampleEntity;

import retrofit2.http.GET;
import rx.Observable;

public interface RetrofitService {
    String EXAMPLE_ENTITY = "/tools/mockapi/7619/5566";
    @GET(EXAMPLE_ENTITY)
    Observable<ExampleEntity> getExampleEntity();
}

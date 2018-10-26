package com.example.administrator.myapplication.persenter;

import android.view.View;

import com.example.administrator.myapplication.view.IMainActivityView;
import com.example.administrator.myapplication.entity.ExampleEntity;
import com.example.administrator.myapplication.retrofit.helper.RetrifitHelper;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivityPresenter {
    IMainActivityView callBack;

    public MainActivityPresenter(IMainActivityView callBack) {
        this.callBack = callBack;
    }

    public View.OnClickListener getMainActivityOnclickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getExampleEntity();
            }
        };
    }

    public void getExampleEntity() {
        //RxJava和retrofit结合
        RetrifitHelper.getInstence().getExampleEntityService().getExampleEntity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ExampleEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        callBack.getTextView().setText("获取失败");
                    }

                    @Override
                    public void onNext(ExampleEntity exampleEntity) {
                        callBack.getTextView().setText(exampleEntity.toString());
                    }
                });
        // 常规，不结合
//        Observable.create(new Observable.OnSubscribe<ExampleEntity>() {
//            @Override
//            public void call(final Subscriber<? super ExampleEntity> subscriber) {
//                RetrofitService exampleEntityService = RetrifitHelper.getInstence().getExampleEntityService();
//                Call<ExampleEntity> call = exampleEntityService.getExampleEntity();
//                call.enqueue(new Callback<ExampleEntity>() {
//                    @Override
//                    public void onResponse(Call<ExampleEntity> call, Response<ExampleEntity> response) {
//                        subscriber.onNext(response.body());
//                    }
//
//                    @Override
//                    public void onFailure(Call<ExampleEntity> call, Throwable t) {
//                        subscriber.onError(t);
//                    }
//                });
//            }
//        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ExampleEntity>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                e.printStackTrace();
//                callBack.getTextView().setText("获取失败了");
//            }
//
//            @Override
//            public void onNext(ExampleEntity exampleEntity) {
//                callBack.getTextView().setText(exampleEntity.toString());
//            }
//        });
    }
}

package com.csj.wan_android.mvp.home.model;


import com.csj.wan_android.bean.home.JavaBean;
import com.csj.wan_android.mvp.home.HomeApiService;
import com.csj.wan_android.mvp.home.HomeCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeModel {
    public void getData(final HomeCallBack callBack) {
        new Retrofit.Builder()
                .baseUrl(HomeApiService.sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(HomeApiService.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<JavaBean>() {
                    @Override
                    public void onNext(JavaBean javaBean) {
                        callBack.onSuccess(javaBean.getData().getDatas());
                    }

                    @Override
                    public void onError(Throwable t) {
                        callBack.onFail(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

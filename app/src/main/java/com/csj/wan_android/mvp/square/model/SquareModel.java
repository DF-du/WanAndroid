package com.csj.wan_android.mvp.square.model;


import com.csj.wan_android.bean.square.SquareBean;
import com.csj.wan_android.mvp.square.SquareApiService;
import com.csj.wan_android.mvp.square.SquareCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SquareModel {
    public void getData(final SquareCallBack callBack) {
        new Retrofit.Builder()
                .baseUrl(SquareApiService.sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(SquareApiService.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<SquareBean>() {
                    @Override
                    public void onNext(SquareBean squareBean) {
                        callBack.onSuccess(squareBean.getData().getDatas());
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

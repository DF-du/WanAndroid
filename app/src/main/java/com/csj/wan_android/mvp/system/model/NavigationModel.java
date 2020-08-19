package com.csj.wan_android.mvp.system.model;

import android.content.pm.ApplicationInfo;


import com.csj.wan_android.bean.NaviBean;
import com.csj.wan_android.mvp.system.NavigationCallBack;
import com.csj.wan_android.mvp.system.NavigationService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NavigationModel {
    public void getData(final NavigationCallBack callBack) {
        new Retrofit.Builder()
                .baseUrl(NavigationService.sWanUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NavigationService.class)
                .getNavi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<NaviBean>() {
                    @Override
                    public void onNext(NaviBean naviBean) {
                        callBack.onSuccess(naviBean.getData());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}

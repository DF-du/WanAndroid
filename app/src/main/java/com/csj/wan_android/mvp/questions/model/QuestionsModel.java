package com.csj.wan_android.mvp.questions.model;


import com.csj.wan_android.bean.questions.JavaBean;
import com.csj.wan_android.mvp.questions.QApiService;
import com.csj.wan_android.mvp.questions.QNetCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionsModel {
    public void getData(final QNetCallBack callBack) {
        new Retrofit.Builder()
                .baseUrl(QApiService.sUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(QApiService.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<JavaBean>() {
                    @Override
                    public void onNext(JavaBean javaBean) {
                        callBack.onSuccess(javaBean.getResults());
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

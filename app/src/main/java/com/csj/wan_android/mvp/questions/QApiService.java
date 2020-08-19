package com.csj.wan_android.mvp.questions;


import com.csj.wan_android.bean.questions.JavaBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QApiService {
//    https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/3
    String sUrl = "https://gank.io/";
    @GET("api/data/%E7%A6%8F%E5%88%A9/20/3")
    Flowable<JavaBean> getData();
}

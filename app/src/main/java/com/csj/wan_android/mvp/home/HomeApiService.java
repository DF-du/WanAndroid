package com.csj.wan_android.mvp.home;



import com.csj.wan_android.bean.home.JavaBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface HomeApiService {
//    https://www.wanandroid.com/project/list/1/json?cid=294
    String sUrl = "https://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Flowable<JavaBean> getData();
}

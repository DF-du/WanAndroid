package com.csj.wan_android.mvp.square;



import com.csj.wan_android.bean.square.SquareBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface SquareApiService {
//    https://www.wanandroid.com/article/list/1/json
    String sUrl = "https://www.wanandroid.com/";
    @GET("article/list/1/json")
    Flowable<SquareBean> getData();
}

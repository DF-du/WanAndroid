package com.csj.wan_android.mvp.system;



import com.csj.wan_android.bean.NaviBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface NavigationService {
    String sWanUrl = "https://wanandroid.com/";

    //公众号tab
    //导航
    @GET("navi/json")
    Flowable<NaviBean> getNavi();
}

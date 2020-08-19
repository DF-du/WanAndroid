package com.csj.wan_android.mvp.home.presenter;


import com.csj.wan_android.bean.home.JavaBean;
import com.csj.wan_android.mvp.home.HomeCallBack;
import com.csj.wan_android.mvp.home.model.HomeModel;
import com.csj.wan_android.mvp.home.view.HomeView;

import java.util.List;

public class HomePresenter implements HomeCallBack {
    private final HomeModel homeModel;
    private HomeView homeView;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel();
    }

    public void getData() {
        homeModel.getData(this);
    }

    @Override
    public void onSuccess(List<JavaBean.DataBean.DatasBean> datasBeans) {
        homeView.setData(datasBeans);
    }

    @Override
    public void onFail(String str) {
        homeView.shoToast(str);
    }
}

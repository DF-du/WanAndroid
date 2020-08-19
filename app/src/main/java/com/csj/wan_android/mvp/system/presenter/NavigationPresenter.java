package com.csj.wan_android.mvp.system.presenter;


import com.csj.wan_android.bean.NaviBean;
import com.csj.wan_android.mvp.system.NavigationCallBack;
import com.csj.wan_android.mvp.system.model.NavigationModel;
import com.csj.wan_android.mvp.system.view.NavigationView;

import java.util.List;

public class NavigationPresenter implements NavigationCallBack {
    private final NavigationModel navigationModel;
    private NavigationView navigationView;

    public NavigationPresenter(NavigationView navigationView) {
        this.navigationView = navigationView;
        navigationModel = new NavigationModel();
    }

    public void getData() {
        navigationModel.getData(this);
    }

    @Override
    public void onSuccess(List<NaviBean.DataBean> dataBeans) {
navigationView.setData(dataBeans);
    }

    @Override
    public void onFail(String str) {

    }
}

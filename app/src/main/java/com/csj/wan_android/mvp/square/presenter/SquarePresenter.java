package com.csj.wan_android.mvp.square.presenter;


import com.csj.wan_android.bean.square.SquareBean;
import com.csj.wan_android.mvp.square.SquareCallBack;
import com.csj.wan_android.mvp.square.model.SquareModel;
import com.csj.wan_android.mvp.square.view.SquareView;

import java.util.List;

public class SquarePresenter implements SquareCallBack {
    private final SquareModel homeModel;
    private SquareView homeView;

    public SquarePresenter(SquareView homeView) {
        this.homeView = homeView;
        homeModel = new SquareModel();
    }

    public void getData() {
        homeModel.getData(this);
    }


    @Override
    public void onSuccess(List<SquareBean.DataBean.DatasBean> datasBean) {
        homeView.setData(datasBean);
    }

    @Override
    public void onFail(String str) {

    }
}

package com.csj.wan_android.mvp.square.view;

import com.csj.wan_android.bean.square.SquareBean;

import java.util.List;

public interface SquareView {
    void setData(List<SquareBean.DataBean.DatasBean> datasBeans);

    void shoToast(String str);
}

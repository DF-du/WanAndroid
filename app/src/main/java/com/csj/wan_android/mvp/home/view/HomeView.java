package com.csj.wan_android.mvp.home.view;


import com.csj.wan_android.bean.home.JavaBean;

import java.util.List;

public interface HomeView {
    void setData(List<JavaBean.DataBean.DatasBean> datasBeans);

    void shoToast(String str);
}

package com.csj.wan_android.mvp.home;



import com.csj.wan_android.bean.home.JavaBean;

import java.util.List;

public interface HomeCallBack {
    void onSuccess(List<JavaBean.DataBean.DatasBean> datasBeans);
    void onFail(String str);
}

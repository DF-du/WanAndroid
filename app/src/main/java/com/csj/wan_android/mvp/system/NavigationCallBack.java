package com.csj.wan_android.mvp.system;



import com.csj.wan_android.bean.NaviBean;

import java.util.List;

public interface NavigationCallBack {
    void onSuccess(List<NaviBean.DataBean> dataBeans);
    void onFail(String str);
}

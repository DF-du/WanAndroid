package com.csj.wan_android.mvp.square;


import com.csj.wan_android.bean.square.SquareBean;

import java.util.List;

public interface SquareCallBack {
    void onSuccess(List<SquareBean.DataBean.DatasBean> datasBean);
    void onFail(String str);
}

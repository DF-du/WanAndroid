package com.csj.wan_android.mvp.questions;

import com.csj.wan_android.bean.questions.JavaBean;

import java.util.List;

public interface QNetCallBack {
    void onSuccess(List<JavaBean.ResultsBean> resultsBeans);
    void onFail(String str);
}

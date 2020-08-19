package com.csj.wan_android.mvp.questions.view;

import com.csj.wan_android.bean.questions.JavaBean;

import java.util.List;

public interface QuestionsView {
    void setData(List<JavaBean.ResultsBean> resultsBeans);
    void showToast(String str);
}

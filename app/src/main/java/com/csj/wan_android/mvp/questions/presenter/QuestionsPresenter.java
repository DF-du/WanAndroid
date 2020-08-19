package com.csj.wan_android.mvp.questions.presenter;


import com.csj.wan_android.bean.questions.JavaBean;
import com.csj.wan_android.mvp.questions.QNetCallBack;
import com.csj.wan_android.mvp.questions.model.QuestionsModel;
import com.csj.wan_android.mvp.questions.view.QuestionsView;

import java.util.List;

public class QuestionsPresenter implements QNetCallBack {
    private final QuestionsModel questionsModel;
    private QuestionsView questionsView;

    public QuestionsPresenter(QuestionsView questionsView) {
        this.questionsView = questionsView;
        questionsModel = new QuestionsModel();
    }
    public void getData(){
        questionsModel.getData(this);
    }

    @Override
    public void onSuccess(List<JavaBean.ResultsBean> resultsBeans) {
        questionsView.setData(resultsBeans);
    }

    @Override
    public void onFail(String str) {
questionsView.showToast(str);
    }
}

package com.csj.wan_android.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.csj.wan_android.R;
import com.csj.wan_android.adapter.QuestionsAdapter;
import com.csj.wan_android.bean.questions.JavaBean;
import com.csj.wan_android.mvp.questions.presenter.QuestionsPresenter;
import com.csj.wan_android.mvp.questions.view.QuestionsView;

import java.util.ArrayList;
import java.util.List;

public class QuestionsFragment extends Fragment implements QuestionsView {
    private RecyclerView mRecycler;
    int page = 3;
    private QuestionsPresenter questionsPresenter;
    private ArrayList<JavaBean.ResultsBean> list;
    private QuestionsAdapter adapter;
//    private SmartRefreshLayout mSmart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.item_questions, null);
        initView(inflate);
        questionsPresenter = new QuestionsPresenter(this);
        questionsPresenter.getData();
        return inflate;
    }

    @SuppressLint("WrongViewCast")
    private void initView(@NonNull final View itemView) {
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
//        mSmart = (SmartRefreshLayout) itemView.findViewById(R.id.smart);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new QuestionsAdapter(getActivity(), list);
        mRecycler.setAdapter(adapter);

//        mSmart.setOnRefreshListener(new OnRefreshListener() {
//            @Override
//            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
//                list.clear();
//                setData(list);
//                adapter.notifyDataSetChanged();
//            }
//        });
    }

    @Override
    public void setData(List<JavaBean.ResultsBean> resultsBeans) {
        list.addAll(resultsBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {

    }
}

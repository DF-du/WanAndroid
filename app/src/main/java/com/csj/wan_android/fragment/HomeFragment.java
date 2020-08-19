package com.csj.wan_android.fragment;

import android.content.Intent;
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
import com.csj.wan_android.adapter.HomeAdapter;
import com.csj.wan_android.bean.home.JavaBean;
import com.csj.wan_android.mvp.home.presenter.HomePresenter;
import com.csj.wan_android.mvp.home.view.HomeView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements HomeView {
    private RecyclerView mRecycler;
    private ArrayList<JavaBean.DataBean.DatasBean> list;
    private HomeAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.item_home, null);
        initView(inflate);
        HomePresenter homePresenter = new HomePresenter(this);
        homePresenter.getData();
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new HomeAdapter(getActivity(), list);
        mRecycler.setAdapter(adapter);

        adapter.setOnClickListener(new HomeAdapter.onClickListener() {
            @Override
            public void onClick(int position) {
                String apkLink = list.get(position).getLink();
//                Intent intent = new Intent(getActivity(), WebActivity.class);
//                intent.putExtra("link",apkLink);
//                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void setData(List<JavaBean.DataBean.DatasBean> datasBeans) {
        list.addAll(datasBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void shoToast(String str) {

    }
}

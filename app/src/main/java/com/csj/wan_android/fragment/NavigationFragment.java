package com.csj.wan_android.fragment;

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
import com.csj.wan_android.adapter.SystemAdapter;
import com.csj.wan_android.bean.NaviBean;
import com.csj.wan_android.mvp.system.presenter.NavigationPresenter;
import com.csj.wan_android.mvp.system.view.NavigationView;

import java.util.ArrayList;
import java.util.List;

import qdx.stickyheaderdecoration.NormalDecoration;


public class NavigationFragment extends Fragment implements NavigationView {
    private RecyclerView mRecycler;
    private ArrayList<NaviBean.DataBean> list;
    private SystemAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.navigation_fragment, null);
        initView(inflate);
        NavigationPresenter navigationPresenter = new NavigationPresenter(this);
        navigationPresenter.getData();
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new SystemAdapter(getActivity(), list);
        mRecycler.setAdapter(adapter);

        NormalDecoration decoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int i) {
                return list.get(i).getName();
            }
        };
        mRecycler.addItemDecoration(decoration);
    }

    @Override
    public void setData(List<NaviBean.DataBean> dataBeans) {
        list.addAll(dataBeans);
        adapter.notifyDataSetChanged();
    }
}

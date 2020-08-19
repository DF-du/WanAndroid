package com.csj.wan_android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.csj.wan_android.R;
import com.csj.wan_android.adapter.SquareAdapter;
import com.csj.wan_android.bean.square.SquareBean;
import com.csj.wan_android.mvp.square.presenter.SquarePresenter;
import com.csj.wan_android.mvp.square.view.SquareView;

import java.util.ArrayList;
import java.util.List;

public class SquareFragment extends Fragment implements SquareView {
    private RecyclerView mRecycler;
    private ArrayList<SquareBean.DataBean.DatasBean> list;
    private SquareAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.square_fragment, null);
        initView(inflate);
        SquarePresenter squarePresenter = new SquarePresenter(this);
        squarePresenter.getData();
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),1));
        list = new ArrayList<>();
        adapter = new SquareAdapter(getActivity(), list);
        mRecycler.setAdapter(adapter);
    }

    @Override
    public void setData(List<SquareBean.DataBean.DatasBean> datasBeans) {
        list.addAll(datasBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void shoToast(String str) {

    }
}

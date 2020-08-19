package com.csj.wan_android.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.csj.wan_android.FlowLayout;
import com.csj.wan_android.R;
import com.csj.wan_android.bean.NaviBean;

import java.util.ArrayList;
import java.util.List;

public class SystemAdapter extends RecyclerView.Adapter<SystemAdapter.ViewHolder> {
    Context context;
    ArrayList<NaviBean.DataBean> list;

    public SystemAdapter(Context context, ArrayList<NaviBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_navi, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NaviBean.DataBean dataBean = list.get(position);
        List<NaviBean.DataBean.ArticlesBean> articles = dataBean.getArticles();
//        .getArticles();
        for (int i = 0; i < articles.size(); i++) {
            NaviBean.DataBean.ArticlesBean articlesBean = articles.get(i);
            TextView tv = (TextView) LayoutInflater.from(context).inflate(R.layout.item_label, null);

            tv.setText(articlesBean.getTitle());

            if (i %3 ==0){
                tv.setTextColor(Color.parseColor("#ff0000"));
            }else if (i %3 == 1){
                tv.setTextColor(Color.parseColor("#00ff00"));
            }else {
                tv.setTextColor(Color.parseColor("#0000ff"));
            }

            holder.mFl.addView(tv);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FlowLayout mFl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mFl = (FlowLayout) itemView.findViewById(R.id.fl);
        }
    }
}

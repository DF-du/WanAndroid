package com.csj.wan_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.csj.wan_android.R;
import com.csj.wan_android.bean.questions.JavaBean;

import java.util.ArrayList;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.ViewHolder> {
    Context context;
    ArrayList<JavaBean.ResultsBean> list;

    public QuestionsAdapter(Context context, ArrayList<JavaBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_questions_recycler, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JavaBean.ResultsBean resultsBean = list.get(position);
        Glide.with(context).load(resultsBean.getUrl()).into(holder.mQuestionsImg);
        holder.mQuestionsTitle.setText(resultsBean.getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mQuestionsImg;
        TextView mQuestionsTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mQuestionsImg = (ImageView) itemView.findViewById(R.id.img_questions);
            mQuestionsTitle = (TextView) itemView.findViewById(R.id.title_questions);
        }
    }
}

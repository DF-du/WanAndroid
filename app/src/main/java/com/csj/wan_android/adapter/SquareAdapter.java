package com.csj.wan_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.csj.wan_android.R;
import com.csj.wan_android.bean.square.SquareBean;

import java.util.ArrayList;

public class SquareAdapter extends RecyclerView.Adapter<SquareAdapter.ViewHolder> {

    Context context;
    ArrayList<SquareBean.DataBean.DatasBean> list;

    public SquareAdapter(Context context, ArrayList<SquareBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_square, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final SquareBean.DataBean.DatasBean datasBean = list.get(position);
        holder.mSuperChapterName.setText(datasBean.getSuperChapterName() + "-广场");
        holder.mShareUser.setText(datasBean.getShareUser());
        holder.mNiceShareDate.setText(datasBean.getNiceShareDate());
        holder.mTitle.setText(datasBean.getTitle());


        holder.mHx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (datasBean.isCheck()){
                    holder.mHx.setImageResource(R.drawable.heart_unselect);
                }else{
                    holder.mHx.setImageResource(R.drawable.heart_select);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mShareUser;
        TextView mNiceShareDate;
        TextView mTitle;
        TextView mSuperChapterName;
        ImageView mHx;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mShareUser = (TextView) itemView.findViewById(R.id.shareUser);
            mNiceShareDate = (TextView) itemView.findViewById(R.id.niceShareDate);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mSuperChapterName = (TextView) itemView.findViewById(R.id.superChapterName);
            mHx = (ImageView) itemView.findViewById(R.id.hx);
        }
    }
}

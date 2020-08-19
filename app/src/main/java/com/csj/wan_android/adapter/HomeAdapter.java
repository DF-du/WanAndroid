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
import com.csj.wan_android.bean.home.JavaBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<JavaBean.DataBean.DatasBean> list;

    public HomeAdapter(Context context, ArrayList<JavaBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false);
            return new ViewHolder1(inflate);
        }else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            return new ViewHolder2(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 0){
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            viewHolder1.mBanner.setImages(list).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    JavaBean.DataBean.DatasBean datasBean = (JavaBean.DataBean.DatasBean) path;
                    Glide.with(context).load(datasBean.getEnvelopePic()).into(imageView);
                }
            }).start();
        }else {
            JavaBean.DataBean.DatasBean datasBean = list.get(position);
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            viewHolder2.mShareUser.setText(datasBean.getShareUser());
            viewHolder2.mTitle.setText(datasBean.getTitle());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else {
            return 1;
        }
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {
        Banner mBanner;
        public ViewHolder1(View itemView) {
            super(itemView);
            mBanner = (Banner) itemView.findViewById(R.id.banner);
        }
    }

    private class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView mShareUser;
        TextView mTitle;
        public ViewHolder2(View itemView) {
            super(itemView);
            mShareUser = (TextView) itemView.findViewById(R.id.shareUser);
            mTitle = (TextView) itemView.findViewById(R.id.title);
        }
    }
    private onClickListener onClickListener;

        public void setOnClickListener(onClickListener onClickListener) {
            this.onClickListener = onClickListener;
        }

        public interface onClickListener{
            void onClick(int position);
        }
}

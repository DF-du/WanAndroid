package com.csj.wan_android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.csj.wan_android.R;
import com.csj.wan_android.adapter.MainAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class AdvocateFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.advocate_fragment, null);
        initView(inflate);
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mTabLayout = (TabLayout) itemView.findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) itemView.findViewById(R.id.viewPager);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new QuestionsFragment());
        fragments.add(new SystemFragment());
        fragments.add(new MineFragment());
        MainAdapter adapter = new MainAdapter(getChildFragmentManager(), fragments);
        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText("首页");
        mTabLayout.getTabAt(1).setText("问答");
        mTabLayout.getTabAt(2).setText("体系");
        mTabLayout.getTabAt(3).setText("我的");

    }
}

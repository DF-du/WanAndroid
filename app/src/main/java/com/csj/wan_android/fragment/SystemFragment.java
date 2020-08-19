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

public class SystemFragment extends Fragment {
    private TextView mAdvocateTitle;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.system_fragment, null);
        initView(inflate);
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
//        mAdvocateTitle = (TextView) itemView.findViewById(R.id.title_square);
        mTabLayout = (TabLayout) itemView.findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) itemView.findViewById(R.id.viewPager);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new SetupFragment());
        fragments.add(new NavigationFragment());
        MainAdapter mainAdapter = new MainAdapter(getChildFragmentManager(), fragments);
        mViewPager.setAdapter(mainAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText("体系");
        mTabLayout.getTabAt(1).setText("导航");

//        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                mAdvocateTitle.setText(tab.getText());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }
}

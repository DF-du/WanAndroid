package com.csj.wan_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.csj.wan_android.adapter.MainAdapter;
import com.csj.wan_android.fragment.AdvocateFragment;
import com.csj.wan_android.fragment.SquareFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ArrayList<Fragment> fragments;
    private MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        fragments = new ArrayList<>();
        fragments.add(new SquareFragment());
        fragments.add(new AdvocateFragment());
        mainAdapter = new MainAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(mainAdapter);
        //传入的下标
        mViewPager.setCurrentItem(1);
    }
}

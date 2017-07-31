package com.ylx.twomainactivitydemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ylx.twomainactivitydemo.mainfragment.CompeteToBuyFragment;
import com.ylx.twomainactivitydemo.mainfragment.MallToBuyFragment;
import com.ylx.twomainactivitydemo.mainfragment.MyFragmentPagerAdapter;
import com.ylx.twomainactivitydemo.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private MyViewPager mViewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;

    private CompeteToBuyFragment competeToBuyFragment;
    private MallToBuyFragment mallToBuyFragment;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (MyViewPager) findViewById(R.id.view_pager);

        mFragments = new ArrayList<>();
        competeToBuyFragment = new CompeteToBuyFragment();
        mallToBuyFragment = new MallToBuyFragment();
        mFragments.add(competeToBuyFragment);
        mFragments.add(mallToBuyFragment);


        initView();
        initListener();
    }

    private void initView() {
        //使用适配器将ViewPager与Fragment绑定在一起
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout与ViewPager绑定在一起
        mTabLayout.setupWithViewPager(mViewPager);

        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);

    }

    private void initListener() {

        competeToBuyFragment.setOnClickHiddenTabLayoutView(new CompeteToBuyFragment.OnClickHiddenTabLayoutView() {
            @Override
            public void onHiddenClick() {
                mViewPager.setScrollble(false);
                mTabLayout.setVisibility(View.GONE);
            }

            @Override
            public void onShowClick() {
                mViewPager.setScrollble(true);
                mTabLayout.setVisibility(View.VISIBLE);
            }
        });

        mallToBuyFragment.setOnClickHiddenTabLayoutView(new MallToBuyFragment.OnClickHiddenTabLayoutView() {
            @Override
            public void onHiddenClick() {
                mViewPager.setScrollble(false);
                mTabLayout.setVisibility(View.GONE);
            }

            @Override
            public void onShowClick() {
                mViewPager.setScrollble(true);
                mTabLayout.setVisibility(View.VISIBLE);
            }
        });

    }

}

package com.ylx.twomainactivitydemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/7/31  上午9:55
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] titles = new String[]{"竞买", "购物"};

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 1){
            return new MallToBuyFragment();
        }
        return new CompeteToBuyFragment();
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    /**
     * ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}

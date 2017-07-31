package com.ylx.twomainactivitydemo.mainfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ylx.twomainactivitydemo.R;
import com.ylx.twomainactivitydemo.mallchildfragment.MallAccountFragment;
import com.ylx.twomainactivitydemo.mallchildfragment.MallCartFragment;
import com.ylx.twomainactivitydemo.mallchildfragment.MallCategoryFragment;
import com.ylx.twomainactivitydemo.mallchildfragment.MallHomeFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MallToBuyFragment extends Fragment {

    private RadioGroup mRadioGroup;

    private List<String> mFragmentTags;

    private int mCurrentIndex;
    private final String CURRENTINDEX = "mCurrentIndex";
    private final int FRAGMENT_ZERO = 0;
    private final int FRAGMENT_FIRST = 1;
    private final int FRAGMENT_SECOND = 2;
    private final int FRAGMENT_THREE = 3;
    private FragmentManager mFragmentManager;

    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_mall_to_buy, container, false);
        mFragmentManager = getChildFragmentManager();
        initData(savedInstanceState);
        /**
         * 初始化view
         */
        initView();
        return mView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENTINDEX,mCurrentIndex);
    }

    private void initData(Bundle savedInstanceState) {
        mFragmentTags = new ArrayList<String>(Arrays.asList("MallHomeFragment","MallCatergoryFragment","MallCartFragment","SafetyFragment","AccountFragment"));
        mCurrentIndex = FRAGMENT_ZERO; //默认首页0
        if(savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(CURRENTINDEX);
            hindSaveFragment();
        }
    }

    /**
     * 隐藏保存Fragment
     */
    private void hindSaveFragment() {
        Fragment mFragment = mFragmentManager.findFragmentByTag(mFragmentTags.get(mCurrentIndex));
        if(mFragment != null){
            mFragmentManager.beginTransaction().hide(mFragment).commit();
        }
    }

    /**
     * 初始化view
     */
    private void initView() {
        mRadioGroup = (RadioGroup) mView.findViewById(R.id.mRadioGroup);
        ((RadioButton)mRadioGroup.getChildAt(mCurrentIndex)).setChecked(true);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int position) {
                switch (position){
                    case R.id.mRBHome:
                        mCurrentIndex = FRAGMENT_ZERO;
                        break;
                    case R.id.mRBMap:
                        mCurrentIndex = FRAGMENT_FIRST;
                        break;
                    case R.id.mRBCenter:
                        mCurrentIndex = FRAGMENT_SECOND;
                        break;
                    case R.id.mRBFind:
                        mCurrentIndex = FRAGMENT_THREE;
                        break;
                    default:break;
                }
                showFragment();
            }
        });
        showFragment();
    }

    /**
     * 展示fragment
     */
    private void showFragment() {
        Fragment fragment = mFragmentManager.findFragmentByTag(mFragmentTags.get(mCurrentIndex));
        if(fragment == null){
            fragment = initFragment(mCurrentIndex);
        }

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        for(int i = 0 ;i < mFragmentTags.size(); i++){
            Fragment ft = mFragmentManager.findFragmentByTag(mFragmentTags.get(i));
            if(ft != null && ft.isAdded()){
                fragmentTransaction.hide(ft);
            }
        }

        if(fragment.isAdded()){
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.replace(R.id.mFrameLayout,fragment,mFragmentTags.get(mCurrentIndex));
        }

        fragmentTransaction.commitAllowingStateLoss();
        mFragmentManager.executePendingTransactions();
    }

    private Fragment initFragment(int current) {
        switch (current){
            case FRAGMENT_ZERO:
                showClick();
                return  new MallHomeFragment();
            case FRAGMENT_FIRST:
                hiddenClick();
                return new MallCategoryFragment();
            case FRAGMENT_SECOND:
                hiddenClick();
                return new MallCartFragment();
            case FRAGMENT_THREE:
                hiddenClick();
                return new MallAccountFragment();
            default:
                return null;
        }
    }

    /**
     * 隐藏事件
     */
    private void hiddenClick(){
        if(onClickHiddenTabLayoutView != null){
            onClickHiddenTabLayoutView.onHiddenClick();
        }
    }

    /**
     * 显示事件
     */
    private void showClick(){
        if(onClickHiddenTabLayoutView != null){
            onClickHiddenTabLayoutView.onShowClick();
        }
    }

    private OnClickHiddenTabLayoutView onClickHiddenTabLayoutView;

    public void setOnClickHiddenTabLayoutView(OnClickHiddenTabLayoutView onClickHiddenTabLayoutView){
        this.onClickHiddenTabLayoutView = onClickHiddenTabLayoutView;
    }

    public interface OnClickHiddenTabLayoutView{
        void onHiddenClick();
        void onShowClick();
    }
}

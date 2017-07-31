package com.ylx.twomainactivitydemo.mallchildfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylx.twomainactivitydemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MallHomeFragment extends Fragment {


    public MallHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mall_home, container, false);
    }

}

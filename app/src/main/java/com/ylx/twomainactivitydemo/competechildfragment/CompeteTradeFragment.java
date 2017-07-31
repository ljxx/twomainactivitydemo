package com.ylx.twomainactivitydemo.competechildfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylx.twomainactivitydemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompeteTradeFragment extends Fragment {


    public CompeteTradeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compete_trade, container, false);
    }

}

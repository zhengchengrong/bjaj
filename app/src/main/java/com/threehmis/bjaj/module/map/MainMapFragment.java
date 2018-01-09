package com.threehmis.bjaj.module.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.threehmis.bjaj.R;
import com.threehmis.bjaj.module.base.BaseFragment;

/**
 * Created by llz on 2018/1/9.
 */

public class MainMapFragment extends BaseFragment {

    @Override
    protected int attachLayoutRes() {
        return 0;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    protected View createFragment(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView =  inflater.inflate(R.layout.activity_main, container, false);

        return fragmentView;
    }


}

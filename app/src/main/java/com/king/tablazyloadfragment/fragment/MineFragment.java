package com.king.tablazyloadfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.king.tablazyloadfragment.R;
import com.king.tablazyloadfragment.base.BaseLazyLoadFragment;
import com.king.tablazyloadfragment.utils.LogUtils;

/**
 * author lrzg on 2017/11/1.
 * 描述：
 */

public class MineFragment extends BaseLazyLoadFragment {
    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine,container,false);
        return view;
    }

    @Override
    protected void getData() {
        LogUtils.d("OnPageChangeListener#"+4);
    }
}

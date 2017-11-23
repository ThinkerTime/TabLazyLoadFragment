package com.king.tablazyloadfragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.king.tablazyloadfragment.utils.LogUtils;

/**
 * author lrzg on 2017/11/1.
 * 描述：
 */

public abstract class BaseLazyLoadFragment extends Fragment{
    // 标志位，标志已经初始化完成，因为setUserVisibleHint是在onCreateView之前调用的，
    // 在视图未初始化的时候，在lazyLoad当中就使用的话，就会有空指针的异常
    private boolean isPrepared;
    //标志当前页面是否可见
    private boolean isVisible;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPrepared = true;
//        lazyLoad();
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //懒加载
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 可见
     */
    protected void onVisible() {
        LogUtils.d("onVisible");
        lazyLoad();
    }

    /**
     * 懒加载
     */
    protected void lazyLoad() {
        if (!isVisible || !isPrepared) {
            return;
        }
        LogUtils.d("isVisible#"+isVisible);
        LogUtils.d("isPrepared#"+isPrepared);
            getData();//数据请求

    }

    protected abstract void getData();

    /**
     * 不可见
     */
    protected void onInvisible() {
    }
}

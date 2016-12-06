package com.sanxiang.campus.live.util.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Administrator on 2016/8/1.
 */
public abstract class BaseFragment extends Fragment {

    protected View root;
    protected boolean isVisible = false;
    private boolean isPrepare = false;
    private boolean isFirst = true;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

//        MyLog.e("可见值为 isVisibleToUser："+ isVisibleToUser);
        if (getUserVisibleHint()) {
            onVisible();
            isVisible = true;
            loadData();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onInvisible() {

    }

    protected void onVisible() {

    }

    protected abstract void lazyLoad();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(getLayout(), container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        isPrepare = true;

        loadData();
    }


    //加载数据
    protected void loadData() {

        //控件未准备好, 则直接返回不加载数据
        // 或者不可见, 则不加载数据
        // 或者 不是第一次 也加载数据

        //第一次运行的状态
        //1.isPrepare为true
        //2.isVisible为ture
        //3.isFirst为false

        //
        if (!isPrepare || !isVisible || !isFirst) {

            return;
        }

        //加载网络或本地数据
        lazyLoad();

        isFirst = false;
    }


    protected abstract int getLayout();



    /*设置view的隐藏和显示*/
    public static void setViewVisible(View view, int visible) {

        if (view.getVisibility() != visible){
            view.setVisibility(visible);
        }
    }

}

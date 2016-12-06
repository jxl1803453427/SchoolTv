package com.sanxiang.campus.live.my.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sanxiang.campus.live.R;
import com.sanxiang.campus.live.util.ui.BaseFragment;
import com.sanxiang.campus.live.util.utils.Constant;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MyFragment extends BaseFragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(Constant.deBug){
            initView();
            initData();
            initEvent();
        }else {
            try {
                initView();
                initData();
                initEvent();
            }catch (Exception e){

            }
        }

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_my;
    }

    private void initView(){

    }
    private void initData(){

    }
    @Override
    protected void lazyLoad() {

    }
    private void initEvent(){

    }
}

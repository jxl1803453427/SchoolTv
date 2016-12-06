package com.sanxiang.campus.live.live.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sanxiang.campus.live.R;
import com.sanxiang.campus.live.util.ui.BaseFragment;
import com.sanxiang.campus.live.util.utils.Constant;

/**
 * Created by Administrator on 2016/11/30.
 */
public class LiveTabFragment extends BaseFragment {
    @Override
    protected int getLayout() {
        return R.layout.fragment_live_tab;
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
}

package com.sanxiang.campus.live.live.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.sanxiang.campus.live.R;
import com.sanxiang.campus.live.live.adapter.LivePagerAdapter;
import com.sanxiang.campus.live.util.ui.BaseFragment;
import com.sanxiang.campus.live.util.utils.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 */
public class LiveFragment extends BaseFragment {
    private TextView title;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FragmentStatePagerAdapter adapter;
    private List<Fragment> fragments;
    private List<String> titles;
    private FragmentActivity mActivity;
    @Override
    protected int getLayout() {
        return R.layout.fragment_live;
    }

    private void initView(){
        title = (TextView) root.findViewById(R.id.header_title);
        title.setText(R.string.live);
        mTabLayout = (TabLayout) root.findViewById(R.id.live_tablayout);
        mViewPager = (ViewPager) root.findViewById(R.id.live_viewpager);
    }
    private void initData(){
        mActivity = getActivity();
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        titles.add(Constant.hot);
        titles.add(Constant.local);
        titles.add(Constant.beijing);
        titles.add(Constant.shanghai);
//        titles.add(Constant.shenzhen);
//        titles.add(Constant.guangzhou);
//        titles.add(Constant.jilin);
//        titles.add(Constant.nanjing);
//        titles.add(Constant.xian);
//        titles.add(Constant.dalian);

        for (int i=0;i<titles.size();i++){
            fragments.add(new LiveTabFragment());
        }
        adapter = new LivePagerAdapter(mActivity.getSupportFragmentManager(),fragments,titles);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
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

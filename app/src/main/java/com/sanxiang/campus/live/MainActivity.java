package com.sanxiang.campus.live;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import com.sanxiang.campus.live.find.ui.FindFragment;
import com.sanxiang.campus.live.live.ui.LiveFragment;
import com.sanxiang.campus.live.mind.ui.MindFragment;
import com.sanxiang.campus.live.my.ui.MyFragment;
import com.sanxiang.campus.live.util.ui.BaseActivity;
import com.sanxiang.campus.live.util.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private RadioGroup bottomTab;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private List<Fragment> fragments;
    private int tab = 0;
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        if(Constant.deBug){
            initView();
            initData();
            initEvent();
            loadData();
        }else {
            try {
                initView();
                initData();
                initEvent();
                loadData();
            }catch (Exception e){

            }
        }


    }

    private void initView(){
        bottomTab = (RadioGroup) findViewById(R.id.main_rg);
    }
    private void initData(){
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        fragments = new ArrayList<>();
        fragments.add(new LiveFragment());
        fragments.add(new MindFragment());
        fragments.add(new FindFragment());
        fragments.add(new MyFragment());

        for (int i=0;i<fragments.size();i++){
            transaction.add(R.id.main_frame,fragments.get(i));
            transaction.hide(fragments.get(i));
        }
        transaction.show(fragments.get(0));
        transaction.commit();
    }

    private void loadData(){

    }

    private void initEvent(){
        bottomTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                transaction = fragmentManager.beginTransaction();
                switch (i){
                    case R.id.tab_live:
                        transaction.hide(fragments.get(tab));
                        transaction.show(fragments.get(0));
                        tab = 0;
                        break;
                    case R.id.tab_mind:
                        transaction.hide(fragments.get(tab));
                        transaction.show(fragments.get(1));
                        tab = 1;
                        break;
                    case R.id.tab_find:
                        transaction.hide(fragments.get(tab));
                        transaction.show(fragments.get(2));
                        tab = 2;
                        break;
                    case R.id.tab_my:
                        transaction.hide(fragments.get(tab));
                        transaction.show(fragments.get(3));
                        tab = 3;
                        break;
                }
                transaction.commit();
            }
        });
    }
}

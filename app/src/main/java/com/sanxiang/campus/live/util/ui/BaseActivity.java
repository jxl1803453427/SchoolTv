package com.sanxiang.campus.live.util.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/7/22.
 */
public abstract class BaseActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(getLayout());

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        init();
    }

    protected abstract int getLayout();
    protected abstract void init();



    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}

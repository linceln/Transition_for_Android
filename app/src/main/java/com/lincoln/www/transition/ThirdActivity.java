package com.lincoln.www.transition;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;

public class ThirdActivity extends BaseActivity {

    @Override
    protected int getLayout() {

        return R.layout.activity_third;
    }

    @Override
    protected void initUI() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("ThirdActivity");
        setSupportActionBar(toolbar);
    }

    @Override
    protected void initData() {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void setupWindowAnimations() {

        getWindow().setEnterTransition(null);
    }
}

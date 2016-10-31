package com.lincoln.www.transition;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayout() {

        return R.layout.activity_main;
    }

    @Override
    protected void initUI() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("MainActivity");
        setSupportActionBar(toolbar);


        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityAnimated(MainActivity.this, intent, null);
            }
        });
    }

    @Override
    protected void initData() {
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void setupWindowAnimations() {
            Fade fade = new Fade();
            fade.setDuration(500);
            getWindow().setExitTransition(fade);
            getWindow().setReenterTransition(fade);
    }

}

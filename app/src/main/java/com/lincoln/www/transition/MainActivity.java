package com.lincoln.www.transition;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupWindowAnimations();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(MainActivity.this, true);

                View decorView = getWindow().getDecorView();
                View statusBar = decorView.findViewById(android.R.id.statusBarBackground);
                View navigationBar = decorView.findViewById(android.R.id.navigationBarBackground);

                List<Pair<View, String>> pairs = new ArrayList<>(3);
                pairs.add(new Pair(statusBar, statusBar.getTransitionName()));
                pairs.add(new Pair(navigationBar, navigationBar.getTransitionName()));
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, pairs.toArray(new Pair[pairs.size()]));
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent, optionsCompat.toBundle());
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {

        Fade fade = new Fade();
        fade.setDuration(500);
        getWindow().setExitTransition(fade);
        getWindow().setReenterTransition(fade);
    }
}

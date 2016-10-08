package com.lincoln.www.transition;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private BaseAdapter mAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setupWindowAnimations();
        initUI();
        initData();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {

        Explode explode = new Explode();
        explode.setDuration(500);
        explode.excludeTarget(android.R.id.statusBarBackground, true);
        explode.excludeTarget(android.R.id.navigationBarBackground, true);
        getWindow().setEnterTransition(explode);

        Slide slide = new Slide();
        slide.setDuration(200);
        slide.setSlideEdge(Gravity.END);
        slide.excludeTarget(android.R.id.statusBarBackground, true);
        slide.excludeTarget(android.R.id.navigationBarBackground, true);
        getWindow().setReturnTransition(slide);
    }

    private void initData() {

    }

    private void initUI() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("SecondActivity");
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listView);
        mAdapter = new BaseAdapter() {

            @Override
            public int getCount() {

                return 20;
            }

            @Override
            public Object getItem(int position) {

                return null;
            }

            @Override
            public long getItemId(int position) {

                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = LayoutInflater.from(SecondActivity.this).inflate(android.R.layout.simple_list_item_1, parent, false);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setText("position: " + position);
                return view;
            }
        };
        listView.setAdapter(mAdapter);
    }
}

package com.lincoln.www.transition;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pair;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends BaseActivity {

    private BaseAdapter mAdapter;

    @Override
    protected int getLayout() {

        return R.layout.activity_second;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void setupWindowAnimations() {

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

    @Override
    protected void initData() {

    }

    @Override
    protected void initUI() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("SecondActivity");
        setSupportActionBar(toolbar);

        ImageView iv = (ImageView) findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                List<Pair<View, String>> pairs = new ArrayList<>();
                pairs.add(Pair.create(v, getString(R.string.transition)));// Shared Elements
                startActivityAnimated(SecondActivity.this, intent, pairs);
            }
        });

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

                View view = LayoutInflater.from(SecondActivity.this).inflate(R.layout.listview_item, parent, false);
                final View imageView = view.findViewById(R.id.iv);
                View linear = view.findViewById(R.id.linear);
                // 对整个item进行点击监听
                linear.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                        List<Pair<View, String>> pairs = new ArrayList<>();
                        // 需要动画过渡的是ImageView
                        pairs.add(Pair.create(imageView, getString(R.string.transition)));// Shared Elements
                        startActivityAnimated(SecondActivity.this, intent, pairs);
                    }
                });
                return view;
            }
        };
        listView.setAdapter(mAdapter);
    }
}

package com.lincoln.www.transition;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setupWindowAnimations();
        }
        initUI();
        initData();
    }

    /**
     * Return layout id of this Activity
     *
     * @return layout id
     */
    protected abstract int getLayout();

    /**
     * Initialize Animations, only after API 21
     */
    protected abstract void setupWindowAnimations();

    /**
     * Initialize Views
     */
    protected abstract void initUI();

    /**
     * Initialize data, like getting network request
     */
    protected abstract void initData();

    public void startActivityAnimated(Activity activity, Intent intent, List<Pair<View, String>> sharedElement) {

        List<Pair<View, String>> pairs = new ArrayList<>();
        pairs.add(Pair.create(findViewById(android.R.id.statusBarBackground), Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME));
        pairs.add(Pair.create(findViewById(android.R.id.navigationBarBackground), Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME));
        if (sharedElement != null && !sharedElement.isEmpty()) {
            pairs.addAll(sharedElement);
        }
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairs.toArray(new Pair[pairs.size()]));
        ActivityCompat.startActivity(activity, intent, optionsCompat.toBundle());
    }

    public void startActivityAnimatedForResult(Activity activity, Intent intent, int requestCode, List<Pair<View, String>> sharedElement) {

        List<Pair<View, String>> pairs = new ArrayList<>();
        pairs.add(Pair.create(findViewById(android.R.id.statusBarBackground), Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME));
        pairs.add(Pair.create(findViewById(android.R.id.navigationBarBackground), Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME));
        if (sharedElement != null && !sharedElement.isEmpty()) {
            pairs.addAll(sharedElement);
        }
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairs.toArray(new Pair[pairs.size()]));
        ActivityCompat.startActivityForResult(activity, intent, requestCode, optionsCompat.toBundle());
    }
}

package com.intelligenceNode.android.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.intelligenceNode.android.R;
import com.intelligenceNode.android.adapter.WalkThroughAdapter;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private TextView nextButton;
    private LinearLayout mBottomLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgets();
    }

    private void getWidgets() {
        viewPager = (ViewPager) findViewById(R.id.walk_through_pager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        nextButton = (TextView) findViewById(R.id.next_button);
        mBottomLayout = (LinearLayout) findViewById(R.id.bottom_layout);
        nextButton.setOnClickListener(this);
        viewPager.setAdapter(new WalkThroughAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(1);
        viewPager.setPageTransformer(true, new NoPageTransformer());
        viewPager.addOnPageChangeListener(this);
        indicator.setViewPager(viewPager);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slide_up);
                mBottomLayout.startAnimation(slideUp);
                mBottomLayout.setVisibility(View.VISIBLE);

            }
        }, 1800);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next_button:
                if (viewPager.getCurrentItem() < 3) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                } else {
                    finish();
                }
                break;
            case R.id.skip_button:
                finish();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 3) {
            nextButton.setText(R.string.finish);
        } else {
            nextButton.setText(R.string.next);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private static class NoPageTransformer implements ViewPager.PageTransformer {
        public void transformPage(View view, float position) {

            if (position < 0) {
                view.setScrollX((int) ((float) (view.getWidth()) * position));
            } else if (position > 0) {
                view.setScrollX(-(int) ((float) (view.getWidth()) * -position));
            } else {
                view.setScrollX(0);
            }
        }
    }
}

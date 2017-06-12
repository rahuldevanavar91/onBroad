package com.intelligenceNode.android.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.intelligenceNode.android.R;

/**
 * Created by Rahul D on 6/11/17.
 */

public class WalkThroughPage1 extends Fragment {

    private LinearLayout mHookLayout;
    private TextView mMessage;
    private Handler mHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.walk_through_page1_layout, container, false);
        getWidgets(view);
        setText();
        return view;
    }

    private void setText() {
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isAdded()) return;
                Animation slideUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
                mHookLayout.startAnimation(slideUp);
                mHookLayout.setVisibility(View.VISIBLE);
                Animation fadeIn = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
                mMessage.setAnimation(fadeIn);
                mMessage.setVisibility(View.VISIBLE);
            }
        }, 1500);
    }

    private void getWidgets(View view) {
        mHookLayout = (LinearLayout) view.findViewById(R.id.hook_layout);
        mMessage = (TextView) view.findViewById(R.id.message);
    }


    @Override
    public void onStop() {
        if (mHandler != null) {
            mHandler.removeMessages(0);
        }
        super.onStop();
    }
}

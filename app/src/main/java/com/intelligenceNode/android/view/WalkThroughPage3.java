package com.intelligenceNode.android.view;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ScrollView;
import android.widget.TextView;

import com.intelligenceNode.android.R;

/**
 * Created by Rahul D on 6/11/17.
 */

public class WalkThroughPage3 extends Fragment {
    private ScrollView mScrollView;
    private TextView mMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.walk_through_page3_layout, container, false);
        getWidgets(view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            mScrollView.clearAnimation();
            ObjectAnimator.ofInt(mScrollView, "scrollY", mScrollView.getChildAt(0).getHeight()).setDuration(10000).start();
            Animation fadeIn = new AlphaAnimation(0, 1);
            fadeIn.setDuration(1000);
            fadeIn.setStartOffset(500);
            mMessage.setAnimation(fadeIn);
            mMessage.setVisibility(View.VISIBLE);
        }
    }

    private void getWidgets(View view) {
        mScrollView = (ScrollView) view.findViewById(R.id.scrollView);
        mMessage = (TextView) view.findViewById(R.id.message);
    }

}

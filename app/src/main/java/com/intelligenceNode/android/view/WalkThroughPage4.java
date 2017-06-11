package com.intelligenceNode.android.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.intelligenceNode.android.R;

/**
 * Created by Rahul D on 6/11/17.
 */

public class WalkThroughPage4 extends Fragment {

    private TextView mMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.walk_through_page4_layout, container, false);
        getWidgets(view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        if (isVisibleToUser) {
            final Animation in = new AlphaAnimation(0.0f, 1.0f);
            in.setDuration(1500);
            in.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    if (!isAdded()) return;
                    mMessage.setText(getString(R.string.stay_notified));

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    if (!isAdded()) return;
                    mMessage.setText(getString(R.string.shop_fashion_like_pro));
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            in.setStartOffset(500);
            mMessage.setAnimation(in);
            mMessage.setVisibility(View.VISIBLE);

        }
    }

    private void getWidgets(View view) {
        mMessage = (TextView) view.findViewById(R.id.message);
    }
}

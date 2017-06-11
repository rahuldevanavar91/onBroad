package com.intelligenceNode.android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.intelligenceNode.android.view.WalkThroughPage1;
import com.intelligenceNode.android.view.WalkThroughPage2;
import com.intelligenceNode.android.view.WalkThroughPage3;
import com.intelligenceNode.android.view.WalkThroughPage4;

/**
 * Created by Rahul D on 6/10/17.
 */

public class WalkThroughAdapter extends FragmentStatePagerAdapter {

    public WalkThroughAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new WalkThroughPage1();
            case 1:
                return new WalkThroughPage2();
            case 2:
                return new WalkThroughPage3();
            case 3:
                return new WalkThroughPage4();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}

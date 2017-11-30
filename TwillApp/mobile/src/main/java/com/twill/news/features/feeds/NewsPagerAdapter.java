package com.twill.news.features.feeds;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Anil on 6/7/2017.
 */

public class NewsPagerAdapter extends FragmentStatePagerAdapter{

    private static final String[] titles = new String[]{"News Sources"};

    public NewsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return NewsListFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}

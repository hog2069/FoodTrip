package com.hog2020.foodtrip;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Tab2tabAdapter extends FragmentPagerAdapter {

    Fragment[] fragments = new Fragment[2];
    String[] titles= new String[]{"NEW","TOP"};

    public Tab2tabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

        fragments[0]= new New();
        fragments[1]= new Top();

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }



}

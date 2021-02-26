package com.hog2020.foodtrip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;


import java.util.ArrayList;

public class PagerAdapter extends androidx.viewpager.widget.PagerAdapter {

    Context context;
    ArrayList<Integer> image;

    public PagerAdapter(Context context, ArrayList<Integer> image) {
        this.context = context;
        this.image = image;
    }

    @Override
    public int getCount() {
        return image.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View pager =inflater.inflate(R.layout.pager,null);

        ImageView videoImage = pager.findViewById(R.id.videoImage);
        videoImage.setImageResource(image.get(position));

        container.addView(pager);

        return pager;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


}

package com.hog2020.foodtrip;


import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import java.util.ArrayList;

public class Tab1Fragment extends Fragment {

    RecyclerView recyclerView;
    Tab1Adapter adapter;
    PagerAdapter pagerAdapter;
    ViewPager pager;
    ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<Integer> image= new ArrayList<>();





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        items.add(new Item("삼겹살","양평동", R.drawable.food01));
        items.add(new Item("떡볶이","성수동", R.drawable.food02));
        items.add(new Item("불닭치즈","화곡동", R.drawable.food03));
        items.add(new Item("와플치킨","상도동", R.drawable.food04));
        items.add(new Item("소곱창","노량진동", R.drawable.food05));
        items.add(new Item("빈대떡","은천동", R.drawable.food06));
        items.add(new Item("곱창떡볶이","신림동", R.drawable.food07));
        items.add(new Item("연어덮밥","대림동", R.drawable.food08));

        image.add(new Integer(R.drawable.event));
        image.add(new Integer(R.drawable.event2));

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab1, container, false);
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.option_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_serach:
            Toast.makeText(getActivity(), "지도 페이지 이동", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(getActivity(),MapActivity.class);
                startActivity(intent);

            break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.recycler);
        adapter= new Tab1Adapter(getActivity(),items);
        recyclerView.setAdapter(adapter);
        ////////////////////////////////////////////////////
        pager=view.findViewById(R.id.pager);
        pagerAdapter= new PagerAdapter(getActivity(),image);
        pager.setAdapter(pagerAdapter);


        Toolbar toolbar= view.findViewById(R.id.toolbar);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

    }


}


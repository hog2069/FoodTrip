package com.hog2020.foodtrip;

import android.content.Context;
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

import java.util.ArrayList;

public class Tab1Fragment extends Fragment {

    RecyclerView recyclerView;
    Tab1Adapter adapter;
    ArrayList<Item> items = new ArrayList<Item>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        items.add(new Item("가게 설명, 정보","주소", R.drawable.chicken));
        items.add(new Item("가게 설명, 정보","주소", R.drawable.chinafood));
        items.add(new Item("가게 설명, 정보","주소", R.drawable.fish));
        items.add(new Item("가게 설명, 정보","주소", R.drawable.jokbar));
        items.add(new Item("가게 설명, 정보","주소",R.drawable.pizza));



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


        Toolbar toolbar= view.findViewById(R.id.toolbar);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

}


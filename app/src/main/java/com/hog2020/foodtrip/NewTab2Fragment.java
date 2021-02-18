package com.hog2020.foodtrip;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URISyntaxException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

//Tab3 정보 가져와 보여 주는 뷰
public class NewTab2Fragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<FooddataItem> items= new ArrayList<>();
    Tab2NewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.newtab,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_NEW);
        adapter = new Tab2NewAdapter(getActivity(), items);
        recyclerView.setAdapter(adapter);


    }




    @Override
    public void onResume() {


        super.onResume();

        //서버 DB에 있는 정보를 가져와서 리사이클러뷰에 보여주기..
        loadData();

    }

    void  loadData(){
        Retrofit retrofit = RetrofitHelper.getRetrofitInstanceGson();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<ArrayList<FooddataItem>> call = retrofitService.loadDataFromServer();
        call.enqueue(new Callback<ArrayList<FooddataItem>>() {
            @Override
            public void onResponse(Call<ArrayList<FooddataItem>> call, Response<ArrayList<FooddataItem>> response) {
                items.clear();
                adapter.notifyDataSetChanged();

                ArrayList<FooddataItem> list =response.body();
                for (FooddataItem item: list){
                    items.add(0,item);
                    adapter.notifyItemInserted(0);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<FooddataItem>> call, Throwable t) {
                Toast.makeText(getActivity(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

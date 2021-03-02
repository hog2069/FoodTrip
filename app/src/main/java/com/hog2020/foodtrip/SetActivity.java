package com.hog2020.foodtrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class SetActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<SetItem> arrayList= new ArrayList<>();
    SetRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);


        arrayList.add(new SetItem("알림","알림 서비스 설정"));
        arrayList.add(new SetItem("언어","언어 서비스 설정"));

        recyclerView=findViewById(R.id.setrecycler);
        adapter= new SetRecyclerAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);
    }
}
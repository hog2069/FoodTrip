package com.hog2020.foodtrip;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Top extends Fragment {

    RecyclerView recyclerView;
    TopAdapter adapter;
    ArrayList<Item2> arrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.toptab,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arrayList.add(new Item2("가게이름","가게 정보",R.drawable.food1,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("가게이름","가게 정보",R.drawable.food2,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("가게이름","가게 정보",R.drawable.food3,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("가게이름","가게 정보",R.drawable.food4,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("가게이름","가게 정보",R.drawable.food5,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("가게이름","가게 정보",R.drawable.foodimg,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("가게이름","가게 정보",R.drawable.food1,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("가게이름","가게 정보",R.drawable.food2,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("가게이름","가게 정보",R.drawable.food3,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));

        recyclerView=view.findViewById(R.id.recycler_TOP);

        adapter= new TopAdapter(getContext(),arrayList);
        recyclerView.setAdapter(adapter);

    }
}

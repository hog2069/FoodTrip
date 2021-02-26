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

public class TopTab2Fragment extends Fragment {

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

        arrayList.add(new Item2("삽겹살","앙평동",R.drawable.food01,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("떡볶이","성수동",R.drawable.food02,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("불닭치즈","화곡동",R.drawable.food03,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("와플치킨","상도동",R.drawable.food04,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("소곱창","노량진동",R.drawable.food05,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("빈대떡","은천동",R.drawable.food06,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("곱창떡볶이","신림동",R.drawable.food07,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));
        arrayList.add(new Item2("연어덮밥","대림동",R.drawable.food08,R.drawable.ic_heart_black,R.drawable.ic_baseline_question_answer_24));

        recyclerView=view.findViewById(R.id.recycler_TOP);

        adapter= new TopAdapter(getContext(),arrayList);
        recyclerView.setAdapter(adapter);

    }
}
//        items.add(new Item("삼겹살","양평동", R.drawable.food01));
//        items.add(new Item("떡볶이","성수동", R.drawable.food02));
//        items.add(new Item("불닭치즈","화곡동", R.drawable.food03));
//        items.add(new Item("와플치킨","상도동", R.drawable.food04));
//        items.add(new Item("소곱창","노량진동", R.drawable.food05));
//        items.add(new Item("빈대떡","은천동", R.drawable.food06));
//        items.add(new Item("곱창떡볶이","신림동", R.drawable.food07));
//        items.add(new Item("연어덮밥","대림동", R.drawable.food08));

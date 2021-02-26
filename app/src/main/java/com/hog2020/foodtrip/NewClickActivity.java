package com.hog2020.foodtrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewClickActivity extends AppCompatActivity {

    ImageView iv;
    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_click);

        iv=findViewById(R.id.ivitem);
        tv1=findViewById(R.id.tvItem1);
        tv2=findViewById(R.id.tvItem2);
        tv3=findViewById(R.id.tvItem3);

        Intent intent =getIntent();
        String image = intent.getStringExtra("image");
        String name = intent.getStringExtra("name");
        String info =intent.getStringExtra("info");
        String phone= intent.getStringExtra("phone");

        String imgUrl ="http://hog2069.dothome.co.kr/Fooddata/"+image;

        Glide.with(this).load(imgUrl).into(iv);

        tv1.setText(name);
        tv2.setText(info);
        tv3.setText(phone);



    }
}
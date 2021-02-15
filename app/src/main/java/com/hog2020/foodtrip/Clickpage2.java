package com.hog2020.foodtrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Clickpage2 extends AppCompatActivity {

    ImageView clickimg, heart,talk;
    TextView tvname,tvinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickpage2);

        clickimg=findViewById(R.id.iv_clickimg);
        heart= findViewById(R.id.iv_heart);
        talk=findViewById(R.id.iv_talk);
        tvname= findViewById(R.id.tv_name);
        tvinfo=findViewById(R.id.tv_info);

        Intent intent =getIntent();
        int ivimg= intent.getIntExtra("ivimg",R.drawable.food1);
        int ivheart= intent.getIntExtra("ivheart",R.drawable.ic_heart_black);
        int ivtalk= intent.getIntExtra("ivtalk",R.drawable.ic_baseline_question_answer_24);
        String name= intent.getStringExtra("tvname");
        String info=intent.getStringExtra("tvinfo");

        Glide.with(this).load(ivimg).into(clickimg);
        Glide.with(this).load(ivheart).into(heart);
        Glide.with(this).load(ivtalk).into(talk);


        tvname.setText(name);
        tvinfo.setText(info);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            clickimg.setTransitionName("ivimg");
            heart.setTransitionName("ivheart");
            talk.setTransitionName("ivtalk");
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
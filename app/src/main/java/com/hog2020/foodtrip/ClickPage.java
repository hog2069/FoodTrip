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

public class ClickPage extends AppCompatActivity {

    ImageView iv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_page);

        iv=findViewById(R.id.iv_click);
        tv=findViewById(R.id.tv);

        Intent intent =getIntent();
        int img =intent.getIntExtra("img",R.drawable.foodimg);

        Glide.with(this).load(img).into(iv);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            iv.setTransitionName("img");
        }


    }

}
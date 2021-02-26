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

    ImageView ivclick;
    TextView tvname;
    TextView tvinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_page);

        ivclick=findViewById(R.id.iv_img1);
        tvname=findViewById(R.id.tv_name1);
        tvinfo=findViewById(R.id.tv_info1);

        Intent intent =getIntent();
        int img =intent.getIntExtra("img",R.drawable.foodimg);

        String name = intent.getStringExtra("house");
        String info =intent.getStringExtra("address");
        Glide.with(this).load(img).into(ivclick);

        tvname.setText(name);
        tvinfo.setText(info);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            ivclick.setTransitionName("img");
        }


    }

}
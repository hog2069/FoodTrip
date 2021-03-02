package com.hog2020.foodtrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class AlermActivity extends AppCompatActivity {

    TextView alerm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerm);

        alerm = findViewById(R.id.alerm);


        Intent intent =getIntent();
        String st =intent.getStringExtra("st");

        Toast.makeText(this, st+"설정 입니다", Toast.LENGTH_SHORT).show();


    }
}
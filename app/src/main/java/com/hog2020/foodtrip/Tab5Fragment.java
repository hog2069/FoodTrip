package com.hog2020.foodtrip;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.content.CursorLoader;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class Tab5Fragment extends Fragment {

    Button set1,set2,set3;
    CircleImageView crv;
    TextView tv1;
    TextView tv2;

    String imgPath;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab5,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        set1=view.findViewById(R.id.set1);
        set2=view.findViewById(R.id.set2);
        set3=view.findViewById(R.id.set3);
        crv=view.findViewById(R.id.crv);
        tv1= view.findViewById(R.id.tv1);
        tv2=view.findViewById(R.id.tv2);





        set1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,20);
            }
        });


        set3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),VideoActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri uri = data.getData();
        if (uri != null){
            Glide.with(this).load(uri).into(crv);
            imgPath =getRealPathFromUri(uri);
        }


    }
    String getRealPathFromUri(Uri uri){
        String[] proj= {MediaStore.Images.Media.DATA};
        CursorLoader loader= new CursorLoader(getContext(), uri, proj, null, null, null);
        Cursor cursor= loader.loadInBackground();
        int column_index= cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result= cursor.getString(column_index);
        cursor.close();
        return  result;
    }


}

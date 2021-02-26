package com.hog2020.foodtrip;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.content.CursorLoader;

import com.bumptech.glide.Glide;
import com.kakao.sdk.user.UserApiClient;

import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class Tab5Fragment extends Fragment {

    Button set1,set2,set3;
    Button logout;
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
        logout=view.findViewById(R.id.logout);
        crv=view.findViewById(R.id.crv);
        tv1= view.findViewById(R.id.tv1);
        tv2=view.findViewById(R.id.tv2);


        SharedPreferences pref = getActivity().getSharedPreferences("picture",Activity.MODE_PRIVATE);
        String user =pref.getString("user",null); // 저장되어 있지 않으면 null
        if (user !=null){
            Glide.with(getActivity()).load(user).into(crv);
        }




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

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserApiClient.getInstance().logout(new Function1<Throwable, Unit>() {
                    @Override
                    public Unit invoke(Throwable throwable) {
                        if (throwable != null){
                            Toast.makeText(getActivity(), "로그아웃 실패", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(), "로그아웃", Toast.LENGTH_SHORT).show();
                        }
                        tv1.setText("닉네임");
                        tv2.setText("이메일");
                        Glide.with(getActivity()).load(R.mipmap.ic_image).into(crv);


                        return null;
                    }
                });
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

            SharedPreferences pref = getActivity().getSharedPreferences("picture", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor =pref.edit();
            editor.putString("user",imgPath);
            editor.commit();

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

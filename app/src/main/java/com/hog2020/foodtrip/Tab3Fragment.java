package com.hog2020.foodtrip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.content.CursorLoader;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Tab3Fragment extends Fragment {

    ImageView iv;
    EditText etname,etaddress,etnumber;
    Button clicksave;

    //업로드 이미지 절대경로
    String imgPath;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab3,container,false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iv=view.findViewById(R.id.iv_GetImage);
        etname= view.findViewById(R.id.et_name);
        etaddress=view.findViewById(R.id.et_address);
        etnumber=view.findViewById(R.id.et_phone);
        clicksave= view.findViewById(R.id.clicksave);


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,100);
            }
        });

        clicksave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //입력한 img, name, address, number 를 서버 DB에 저장
                String name = etname.getText().toString();
                String address= etaddress.getText().toString();
                String number = etnumber.getText().toString();

                Retrofit retrofit = RetrofitHelper.getRetrofitInstanceScalars();
                RetrofitService retrofitService = retrofit.create(RetrofitService.class);


                MultipartBody.Part filePart =null;
                if (imgPath !=null){
                    File file = new File(imgPath);
                    RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"),file);
                    filePart = MultipartBody.Part.createFormData("image",file.getName(),requestBody);
                }

                Map<String,String> dataPart= new HashMap<>();
                dataPart.put("name",name);
                dataPart.put("address",address);
                dataPart.put("number",number);

                Call<String> call = retrofitService.postDataToServer(dataPart,filePart);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        String s = response.body();
                        Toast.makeText(getContext(), "테스트"+s, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getContext(), "에러"+t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

                //Tab2로 이동하도록.. MainActivity의 BNV를 제어
                ((MainActivity)getActivity()).bnv.setSelectedItemId(R.id.bnv_tab2);

            }
        });

        //남아 있는 데이터 지워지도록


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode==Activity.RESULT_OK){

            Uri uri = data.getData();
            Glide.with(this).load(uri).into(iv);

            imgPath = getRealPathFromUri(uri);
            Log.i("tag",imgPath+"");
        }

    }

    String getRealPathFromUri(Uri uri){
        String[] proj ={MediaStore.Images.Media.DATA};
        CursorLoader loader= new CursorLoader(getActivity(),uri,proj,null,null,null);
        Cursor cursor = loader.loadInBackground();

        int colum_index= cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();

        String result =cursor.getString(colum_index);
        cursor.close();
        return result;
    }

}

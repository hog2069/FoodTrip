package com.hog2020.foodtrip;


import java.util.ArrayList;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface RetrofitService {

    @Multipart
    @POST("/Fooddata/insertDB.php")
    Call<String> postDataToServer(@PartMap Map<String,String> dataPart,
                                  @Part MultipartBody.Part filePart);

    @GET("/Fooddata/loadDB.php")
    Call<ArrayList<FooddataItem>> loadDataFromServer();


}

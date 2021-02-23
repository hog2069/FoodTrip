package com.hog2020.foodtrip;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        KakaoSdk.init(this,"bdebacb54988236e9d0217a766244027");
    }
}

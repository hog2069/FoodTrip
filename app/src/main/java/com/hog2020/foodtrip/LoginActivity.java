package com.hog2020.foodtrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kakao.sdk.auth.LoginClient;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.util.Utility;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    TextView tvnickname;
    TextView tvemail;
    CircleImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvnickname=findViewById(R.id.nickname);
        tvemail = findViewById(R.id.tvemail);
        iv= findViewById(R.id.iv);

        String keyhash= Utility.INSTANCE.getKeyHash(this);
        Log.i("Keyhash",keyhash);
    }

    public void clicklogin(View view) {
        LoginClient.getInstance().loginWithKakaoAccount(this, new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if (oAuthToken != null){

                    UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                        @Override
                        public Unit invoke(User user, Throwable throwable) {

                            if (user != null){

                                String nickname = user.getKakaoAccount().getProfile().getNickname();
                                String profileImageUrl = user.getKakaoAccount().getProfile().getThumbnailImageUrl();
                                String email = user.getKakaoAccount().getEmail();

                                tvnickname.setText(nickname);
                                tvemail.setText(email);

                                Glide.with(LoginActivity.this).load(profileImageUrl).into(iv);

                                startActivity(new Intent(LoginActivity.this,MainActivity.class));

                            }else{
                                Toast.makeText(LoginActivity.this, "사용자 정보 요청 실패", Toast.LENGTH_SHORT).show();
                            }

                            return null;
                        }
                    });


                }else {
                    Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                }

                return null;
            }
        });
    }

}
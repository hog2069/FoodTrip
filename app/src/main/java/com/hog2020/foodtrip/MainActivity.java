package com.hog2020.foodtrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    Fragment[] fragments = new Fragment[5];
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager= getSupportFragmentManager();

        FragmentTransaction tran = fragmentManager.beginTransaction();
        fragments[0]= new Tab1Fragment();
        tran.add(R.id.container,fragments[0]);
        tran.commit();



        bnv=findViewById(R.id.bnv);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction tran = fragmentManager.beginTransaction();

                if (fragments[0]!=null) tran.hide(fragments[0]);
                if (fragments[1]!=null) tran.hide(fragments[1]);
                if (fragments[2]!=null) tran.hide(fragments[2]);
                if (fragments[3]!=null) tran.hide(fragments[3]);
                if (fragments[4]!=null) tran.hide(fragments[4]);

                switch (item.getItemId()){
                    case R.id.bnv_tab1:
                        tran.show(fragments[0]);
                        break;
                    case R.id.bnv_tab2:
                        if (fragments[1]==null){
                            fragments[1]= new Tab2Fragment();
                            tran.add(R.id.container,fragments[1]);
                        }
                        tran.show(fragments[1]);
                        break;
                    case R.id.bnv_tab3:
                        if (fragments[2]==null){
                            fragments[2]= new Tab3Fragment();
                            tran.add(R.id.container,fragments[2]);
                        }
                        tran.show(fragments[2]);
                        break;
                    case R.id.bnv_tab4:
                        if (fragments[3]==null){
                            fragments[3]= new Tab4Fragment();
                            tran.add(R.id.container,fragments[3]);
                        }
                        tran.show(fragments[3]);
                        break;
                    case R.id.bnv_tab5:
                        if (fragments[4]==null){
                            fragments[4]= new Tab5Fragment();
                            tran.add(R.id.container,fragments[4]);
                        }
                        tran.show(fragments[4]);
                        break;
                }
                tran.commit();

                return true;
            }
        });



        //퍼미션
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_DENIED){
                String[] permission = new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permission,0);
            }
        }



    }

}
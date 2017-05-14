package com.example.admin.mygamel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.admin.mygamel.interfaces.*;

/**
 * Created by Admin on 23.04.2017.
 */
public class MainActivity extends FragmentActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        startService(new Intent(this,MusicService.class));
        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        MainScreen mainScreen = new MainScreen();
        fragmentTransaction.add(R.id.main_activity,mainScreen);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this,MusicService.class));
    }


    public SaveData getStorage(){
        return BaseStorage.instance(this);
    }
    /*
    @Override
    public void onBackPressed() {
        android.app.Fragment fragment = getFragmentManager().getFragment(null,"select");
        if(fragment!=null && fragment.isVisible() && fragment instanceof OnBackPressedListener){
            ((OnBackPressedListener) fragment).onBackPressed();
        } else {
            super.onBackPressed();
        }
    }*/
}


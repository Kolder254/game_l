package com.example.admin.mygamel.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.example.admin.mygamel.fragments.MainScreen;
import com.example.admin.mygamel.service.MusicService;
import com.example.admin.mygamel.R;
import com.example.admin.mygamel.storage.BaseStorage;
import com.example.admin.mygamel.storage.SaveData;

/**
 * Created by Admin on 23.04.2017.
 */
public class MainActivity extends FragmentActivity{
    private boolean musicActive;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        startService(new Intent(this,MusicService.class));
        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        MainScreen mainScreen = new MainScreen();
        fragmentTransaction.add(R.id.main_activity,mainScreen);
        fragmentTransaction.commit();
        musicActive = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this,MusicService.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(new Intent(this,MusicService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(musicActive) {
            startService(new Intent(this, MusicService.class));
        }
    }

    public SaveData getStorage(){
        return BaseStorage.instance(this);
    }

    public boolean isMusicActive() {
        return musicActive;
    }

    public void setMusicActive(){
        if(musicActive){
            stopService(new Intent(this,MusicService.class));
            musicActive = false;
        } else {
            startService(new Intent(this,MusicService.class));
            musicActive = true;
        }
    }

}


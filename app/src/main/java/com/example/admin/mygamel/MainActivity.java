package com.example.admin.mygamel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.example.admin.mygamel.Model.Levels;

import java.util.ArrayList;

/**
 * Created by Admin on 23.04.2017.
 */
public class MainActivity extends FragmentActivity{
    private boolean musicActive;
    private static Levels levels;

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



    public static void createLevel(ArrayList<Element> arrayList){

        if(levels == null){
            levels = new Levels();
        }

        levels.addElem(arrayList);

    }

    public static void getView(View v){
        levels.getView(v);
    }

    public static void updateLevel(){

    }
}


package com.example.admin.mygamel.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.admin.mygamel.R;

/**
 * Created by Admin on 27.04.2017.
 */

public class MusicService extends Service {
    MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player =  MediaPlayer.create(this, R.raw.theme_music);
        player.setLooping(true);
        player.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

}

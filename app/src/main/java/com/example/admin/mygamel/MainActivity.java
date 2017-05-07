package com.example.admin.mygamel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        if(getStorage().loadData()!=null) {
            String string = getStorage().loadData();
            Log.v("myLog", string);
        } else {
            Log.v("myLog", "Empty base");
        }
        ImageView buttonStart = (ImageView) findViewById(R.id.button_start);
        buttonStart.setOnClickListener(this);
        startService(new Intent(this,MusicService.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this,MusicService.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_start:
                getStorage().saveData("string22");
                Intent intent = new Intent(this,LevelSelection.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public SaveData getStorage(){
        return BaseStorage.instance(this);
    }

}


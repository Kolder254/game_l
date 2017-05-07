package com.example.admin.mygamel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Admin on 25.04.2017.
 */

public class LevelSelection extends AppCompatActivity implements View.OnClickListener {
    ImageView level1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_selection);
        level1=(ImageView) findViewById(R.id.level_1);
        level1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.level_1:
                Intent intent = new Intent(this,Level1.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}

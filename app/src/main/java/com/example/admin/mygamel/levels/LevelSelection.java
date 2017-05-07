package com.example.admin.mygamel.levels;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.admin.mygamel.Level1;
import com.example.admin.mygamel.R;

/**
 * Created by Admin on 27.04.2017.
 */

public class LevelSelection extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.level_1:
                Intent intent = new Intent(this, Level1.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}

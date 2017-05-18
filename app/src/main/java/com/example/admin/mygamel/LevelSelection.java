package com.example.admin.mygamel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.mygamel.interfaces.SaveData;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Admin on 25.04.2017.
 */

public class LevelSelection extends android.app.Fragment implements View.OnClickListener,OnBackPressedListener{

    ImageView level1;
    ImageView level2;
    ImageView level3;
    ImageView level4;
    ImageView level5;
    ImageView level6;
    ImageView level7;
    ImageView level8;
    ImageView level9;

    JSONArray jsonArray;

    public LevelSelection(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.level_selection, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        if(getStorage().loadData()==null){
            JSONArray jsonArray = new JSONArray();
            for(int i = 0;i<10;i++) {
                jsonArray.put(false);
            }
            getStorage().saveData(jsonArray.toString());
        }

        try {
            jsonArray = new JSONArray(getStorage().loadData());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        level1=(ImageView) getActivity().findViewById(R.id.level_1);
        level1.setOnClickListener(this);
        level2=(ImageView) getActivity().findViewById(R.id.level_2);
        level3=(ImageView) getActivity().findViewById(R.id.level_3);
        level4=(ImageView) getActivity().findViewById(R.id.level_4);
        level5=(ImageView) getActivity().findViewById(R.id.level_5);
        level6=(ImageView) getActivity().findViewById(R.id.level_6);
        level7=(ImageView) getActivity().findViewById(R.id.level_7);
        level8=(ImageView) getActivity().findViewById(R.id.level_8);
        level9=(ImageView) getActivity().findViewById(R.id.level_9);


        try {
            if(jsonArray.getBoolean(0)){
                level2.setOnClickListener(this);
                level2.setImageResource(R.drawable.button_level_active);
            }

            if(jsonArray.getBoolean(1)){
                level3.setOnClickListener(this);
                level3.setImageResource(R.drawable.button_level_active);
            }

            if(jsonArray.getBoolean(2)){
                level4.setOnClickListener(this);
                level4.setImageResource(R.drawable.button_level_active);
            }

            if(jsonArray.getBoolean(3)){
                level4.setOnClickListener(this);
                level4.setImageResource(R.drawable.button_level_active);
            }

            if(jsonArray.getBoolean(4)){
                level4.setOnClickListener(this);
                level4.setImageResource(R.drawable.button_level_active);
            }

            if(jsonArray.getBoolean(5)){
                level4.setOnClickListener(this);
                level4.setImageResource(R.drawable.button_level_active);
            }

            if(jsonArray.getBoolean(6)){
                level4.setOnClickListener(this);
                level4.setImageResource(R.drawable.button_level_active);
            }

            if(jsonArray.getBoolean(7)){
                level4.setOnClickListener(this);
                level4.setImageResource(R.drawable.button_level_active);
            }

            if(jsonArray.getBoolean(8)){
                level4.setOnClickListener(this);
                level4.setImageResource(R.drawable.button_level_active);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        switch(v.getId()){
            case R.id.level_1:
                Level1 myFragment = new Level1();
                fragmentTransaction.replace(R.id.main_activity, myFragment);
                break;
            case R.id.level_2:
                Level2 myFragment2 = new Level2();
                fragmentTransaction.replace(R.id.main_activity,myFragment2);
                break;
            case R.id.level_3:
                break;
            case R.id.level_4:
                break;
            case R.id.level_5:
                break;
            case R.id.level_6:
                break;
            case R.id.level_7:
                break;
            case R.id.level_8:
                break;
            case R.id.level_9:
                break;
            default:
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
        MainScreen mainScreen = new MainScreen();
        ft.replace(R.id.main_activity,mainScreen);
        ft.commit();
    }

    public SaveData getStorage(){
        return BaseStorage.instance(getActivity());
    }
}

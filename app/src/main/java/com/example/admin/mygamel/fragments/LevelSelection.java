package com.example.admin.mygamel.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.mygamel.R;
import com.example.admin.mygamel.levels.Level1;
import com.example.admin.mygamel.levels.Level2;
import com.example.admin.mygamel.levels.Level3;
import com.example.admin.mygamel.levels.Level4;
import com.example.admin.mygamel.levels.Level5;
import com.example.admin.mygamel.levels.Level6;
import com.example.admin.mygamel.levels.Level7;
import com.example.admin.mygamel.levels.Level8;
import com.example.admin.mygamel.levels.Level9;
import com.example.admin.mygamel.storage.BaseStorage;
import com.example.admin.mygamel.storage.SaveData;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Admin on 25.04.2017.
 */

public class LevelSelection extends android.app.Fragment implements View.OnClickListener{

    ImageView level1;
    ImageView level2;
    ImageView level3;
    ImageView level4;
    ImageView level5;
    ImageView level6;
    ImageView level7;
    ImageView level8;
    ImageView level9;
    ImageView buttonHome;

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
            for(int i = 0;i<9;i++) {
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

        buttonHome = (ImageView) getActivity().findViewById(R.id.btn_home);
        buttonHome.setOnClickListener(this);


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
                level5.setOnClickListener(this);
                level5.setImageResource(R.drawable.button_level_active);
            }

            if(jsonArray.getBoolean(4)){
                level6.setOnClickListener(this);
                level6.setImageResource(R.drawable.button_level_active);
            }

            if(jsonArray.getBoolean(5)){
                level7.setOnClickListener(this);
                level7.setImageResource(R.drawable.button_level_active);
            }

            if(jsonArray.getBoolean(6)){
                level8.setOnClickListener(this);
                level8.setImageResource(R.drawable.button_level_active);
            }

            if(jsonArray.getBoolean(7)){
                level9.setOnClickListener(this);
                level9.setImageResource(R.drawable.button_level_active);
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
                Level1 fragmentLv1 = new Level1();
                fragmentTransaction.replace(R.id.main_activity, fragmentLv1);
                break;
            case R.id.level_2:
                Level2 fragmentLv2 = new Level2();
                fragmentTransaction.replace(R.id.main_activity,fragmentLv2);
                break;
            case R.id.level_3:
                Level3 fragmentLv3 = new Level3();
                fragmentTransaction.replace(R.id.main_activity,fragmentLv3);
                break;
            case R.id.level_4:
                Level4 fragmentLv4 = new Level4();
                fragmentTransaction.replace(R.id.main_activity,fragmentLv4);
                break;
            case R.id.level_5:
                Level5 fragmentLv5 = new Level5();
                fragmentTransaction.replace(R.id.main_activity,fragmentLv5);
                break;
            case R.id.level_6:
                Level6 fragmentLv6 = new Level6();
                fragmentTransaction.replace(R.id.main_activity,fragmentLv6);
                break;
            case R.id.level_7:
                Level7 fragmentLv7 = new Level7();
                fragmentTransaction.replace(R.id.main_activity,fragmentLv7);
                break;
            case R.id.level_8:
                Level8 fragmentLv8 = new Level8();
                fragmentTransaction.replace(R.id.main_activity,fragmentLv8);
                break;
            case R.id.level_9:
                Level9 fragmentLv9 = new Level9();
                fragmentTransaction.replace(R.id.main_activity,fragmentLv9);
                break;
            case R.id.btn_home:
                MainScreen mainFragment = new MainScreen();
                fragmentTransaction.replace(R.id.main_activity,mainFragment);
            default:
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public SaveData getStorage(){
        return BaseStorage.instance(getActivity());
    }
}

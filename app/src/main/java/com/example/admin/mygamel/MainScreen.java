package com.example.admin.mygamel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Admin on 13.05.2017.
 */

public class MainScreen extends android.app.Fragment implements View.OnClickListener {
    ImageView btnStart;
    ImageView btnSettings;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_screen, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        btnStart = (ImageView) getActivity().findViewById(R.id.button_start);
        btnSettings = (ImageView) getActivity().findViewById(R.id.button_settings);
        btnStart.setOnClickListener(this);
        btnSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button_start){
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            LevelSelection levelSelection = new LevelSelection();
            fragmentTransaction.replace(R.id.main_activity,levelSelection,"select");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else {
            android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            Settings settings = new Settings();
            fragmentTransaction.replace(R.id.main_activity,settings);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}

package com.example.admin.mygamel.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.mygamel.R;
import com.example.admin.mygamel.main.MainActivity;

/**
 * Created by Admin on 27.05.2017.
 */

public class Settings extends android.app.Fragment implements View.OnClickListener {

    ImageView music;
    ImageView homeBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        music = (ImageView) getActivity().findViewById(R.id.music_btn);
        homeBtn = (ImageView) getActivity().findViewById(R.id.btn_home);
        super.onViewCreated(view, savedInstanceState);
        music.setOnClickListener(this);
        homeBtn.setOnClickListener(this);

        if(((MainActivity)getActivity()).isMusicActive()){
            music.setImageResource(R.drawable.music_on);
        } else {
            music.setImageResource(R.drawable.music_off);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == music.getId()){
           if(((MainActivity)getActivity()).isMusicActive()){
               ((MainActivity)getActivity()).setMusicActive();
               music.setImageResource(R.drawable.music_off);
           } else {
               ((MainActivity)getActivity()).setMusicActive();
               music.setImageResource(R.drawable.music_on);
           }
        } else {
            MainScreen ms = new MainScreen();
            android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.main_activity,ms);
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}

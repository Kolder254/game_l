package com.example.admin.mygamel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Admin on 27.05.2017.
 */

public class Settings extends android.app.Fragment implements View.OnClickListener {

    ImageView music;

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
        super.onViewCreated(view, savedInstanceState);
        music.setOnClickListener(this);

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
        }
    }
}

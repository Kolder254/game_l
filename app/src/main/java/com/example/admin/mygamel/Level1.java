package com.example.admin.mygamel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class Level1 extends android.app.Fragment implements View.OnClickListener{


    ArrayList<Element> arrayList;
    ImageView buttonNext;
    ImageView view44;
    JSONArray jsonArray;
    MainActivity main;

    public Level1(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.level_1, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        arrayList = new ArrayList<>();
        main = (MainActivity)getActivity();

        ImageView view11 = (ImageView)getView().findViewById(R.id.pos_1_1);
        ElementCorner view12 = (ElementCorner)getView().findViewById(R.id.pos_1_2);
        ElementCorner view13 = (ElementCorner)getView().findViewById(R.id.pos_1_3);
        ElementLine view14 = (ElementLine)getView().findViewById(R.id.pos_1_4);
        ElementLine view21 = (ElementLine)getView().findViewById(R.id.pos_2_1);
        ElementLine view22 = (ElementLine)getView().findViewById(R.id.pos_2_2);
        ElementLine view23 = (ElementLine)getView().findViewById(R.id.pos_2_3);
        ElementCorner view24 = (ElementCorner)getView().findViewById(R.id.pos_2_4);
        ElementCorner view31 = (ElementCorner)getView().findViewById(R.id.pos_3_1);
        ElementCorner view32 = (ElementCorner)getView().findViewById(R.id.pos_3_2);
        ElementCorner view33 = (ElementCorner)getView().findViewById(R.id.pos_3_3);
        ElementCorner view34 = (ElementCorner)getView().findViewById(R.id.pos_3_4);
        ElementCorner view41 = (ElementCorner)getView().findViewById(R.id.pos_4_1);
        ElementLine view42 = (ElementLine)getView().findViewById(R.id.pos_4_2);
        ElementCorner view43 = (ElementCorner)getView().findViewById(R.id.pos_4_3);
        view44 = (ImageView)getView().findViewById(R.id.pos_4_4);
        buttonNext = (ImageView)getView().findViewById(R.id.button_next);


        view12.setRightPos(Position.pos2);
        view13.setRightPos(Position.pos3);
        view21.setRightPos(Position.pos1);
        view22.setRightPos(Position.pos1);
        view23.setRightPos(Position.pos1);
        view31.setRightPos(Position.pos1);
        view32.setRightPos(Position.pos4);
        view33.setRightPos(Position.pos1);
        view34.setRightPos(Position.pos3);

        arrayList.add(view12);
        arrayList.add(view13);
        arrayList.add(view21);
        arrayList.add(view22);
        arrayList.add(view23);
        arrayList.add(view31);
        arrayList.add(view32);
        arrayList.add(view33);
        arrayList.add(view34);

        view11.setOnClickListener(this);
        view12.setOnClickListener(this);
        view13.setOnClickListener(this);
        view14.setOnClickListener(this);
        view21.setOnClickListener(this);
        view22.setOnClickListener(this);
        view23.setOnClickListener(this);
        view24.setOnClickListener(this);
        view31.setOnClickListener(this);
        view32.setOnClickListener(this);
        view33.setOnClickListener(this);
        view34.setOnClickListener(this);
        view41.setOnClickListener(this);
        view42.setOnClickListener(this);
        view43.setOnClickListener(this);
        view44.setOnClickListener(this);

        try {
            jsonArray = new JSONArray(main.getStorage().loadData());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {

        if (v instanceof Element) {
            ((Element) v).myRotate();
        } else if (v.getId() == R.id.button_next) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();  		// добавляем фрагмент
            LevelSelection levelSelection = new LevelSelection();
            fragmentTransaction.replace(R.id.main_activity,levelSelection);
            fragmentTransaction.commit();
        }


        if (isCompleted()) {
            buttonNext.setImageResource(R.drawable.button_next_active);
            buttonNext.setOnClickListener(this);
            view44.setImageResource(R.drawable.elem_light_active);
            for(Element i:arrayList){
                if(i instanceof ElementLine){
                    ((ElementLine) i).setActive();
                }
            }
            saveData();
        } else {
            buttonNext.setImageResource(R.drawable.button_next);
            buttonNext.setOnClickListener(null);
            view44.setImageResource(R.drawable.elem_light);
            for(Element i:arrayList){
                if(i instanceof ElementLine){
                    ((ElementLine) i).resetActive();
                }
            }
        }
    }



    boolean isCompleted(){
        for (Element v: arrayList) {
            if (!v.isRightPos()) {
                return false;
            }
        }
        return true;
    }

    void saveData(){
       try {
            jsonArray.put(0,true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        main.getStorage().saveData(jsonArray.toString());
        Log.v("saveL1",main.getStorage().loadData());
    }
}



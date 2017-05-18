package com.example.admin.mygamel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Admin on 18.05.2017.
 */

public class Level2 extends Level implements View.OnClickListener{
    ArrayList<Element> arrayList;
    ImageView buttonNext;

    public Level2(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.level_2, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        arrayList = new ArrayList<>();

        ElementLine view11 = (ElementLine) getActivity().findViewById(R.id.pos_1_1);
        ImageView view12 = (ImageView) getActivity().findViewById(R.id.pos_1_2);
        ElementLine view13 = (ElementLine) getActivity().findViewById(R.id.pos_1_3);
        ElementCorner view14 = (ElementCorner) getActivity().findViewById(R.id.pos_1_4);
        ElementCorner view21 = (ElementCorner) getActivity().findViewById(R.id.pos_2_1);
        ElementLine view22 = (ElementLine) getActivity().findViewById(R.id.pos_2_2);
        ElementLine view23 = (ElementLine) getActivity().findViewById(R.id.pos_2_3);
        ElementCorner view24 = (ElementCorner) getActivity().findViewById(R.id.pos_2_4);
        ElementLine view31 = (ElementLine) getActivity().findViewById(R.id.pos_3_1);
        ElementCorner view32 = (ElementCorner) getActivity().findViewById(R.id.pos_3_2);
        ElementLine view33 = (ElementLine) getActivity().findViewById(R.id.pos_3_3);
        ElementCorner view34 = (ElementCorner) getActivity().findViewById(R.id.pos_3_4);
        ElementCorner view41 = (ElementCorner) getActivity().findViewById(R.id.pos_4_1);
        ElementLine view42 = (ElementLine) getActivity().findViewById(R.id.pos_4_2);
        ImageView view43 = (ImageView) getActivity().findViewById(R.id.pos_4_3);
        ElementCorner view44 = (ElementCorner) getActivity().findViewById(R.id.pos_4_4);
        buttonNext = (ImageView)getView().findViewById(R.id.button_next);

        view13.setRightPos(Position.pos2);
        view14.setRightPos(Position.pos3);
        view21.setRightPos(Position.pos2);
        view22.setRightPos(Position.pos2);
        view23.setRightPos(Position.pos2);
        view24.setRightPos(Position.pos4);
        view31.setRightPos(Position.pos1);
        view41.setRightPos(Position.pos1);
        view42.setRightPos(Position.pos2);

        arrayList.add(view13);
        arrayList.add(view14);
        arrayList.add(view21);
        arrayList.add(view22);
        arrayList.add(view23);
        arrayList.add(view24);
        arrayList.add(view31);
        arrayList.add(view41);
        arrayList.add(view42);

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

    }

    @Override
    public void onClick(View v) {

        if (v instanceof Element) {
            ((Element) v).myRotate();
        } else if (v.getId() == R.id.button_next) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            LevelSelection levelSelection = new LevelSelection();
            fragmentTransaction.replace(R.id.main_activity,levelSelection);
            fragmentTransaction.commit();
        }


        if (isCompleted(arrayList)) {
            buttonNext.setImageResource(R.drawable.button_next_active);
            buttonNext.setOnClickListener(this);
            for(Element i:arrayList){
                if(i instanceof ElementLine){
                    ((ElementLine) i).setActive();
                }
            }
            super.saveData(2);
        } else {
            buttonNext.setImageResource(R.drawable.button_next);
            buttonNext.setOnClickListener(null);
            for(Element i:arrayList){
                if(i instanceof ElementLine){
                    ((ElementLine) i).resetActive();
                }
            }
        }
    }

}


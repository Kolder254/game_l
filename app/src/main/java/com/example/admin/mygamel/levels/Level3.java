package com.example.admin.mygamel.levels;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.mygamel.Position;
import com.example.admin.mygamel.R;
import com.example.admin.mygamel.base_classes.Element;
import com.example.admin.mygamel.base_classes.Level;
import com.example.admin.mygamel.elements.ElementCorner;
import com.example.admin.mygamel.elements.ElementLine;
import com.example.admin.mygamel.fragments.LevelSelection;

import java.util.ArrayList;

/**
 * Created by Admin on 05.06.2017.
 */

public class Level3 extends Level {
    ArrayList<Element> arrayList;
    ImageView buttonNext;

    public Level3(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.level_3, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        arrayList = new ArrayList<>();

        ImageView view11 = (ImageView) getActivity().findViewById(R.id.pos_1_1);
        ElementCorner view12 = (ElementCorner) getActivity().findViewById(R.id.pos_1_2);
        ElementLine view13 = (ElementLine) getActivity().findViewById(R.id.pos_1_3);
        ImageView view14 = (ImageView) getActivity().findViewById(R.id.pos_1_4);
        ElementLine view21 = (ElementLine) getActivity().findViewById(R.id.pos_2_1);
        ElementCorner view22 = (ElementCorner) getActivity().findViewById(R.id.pos_2_2);
        ElementLine view23 = (ElementLine) getActivity().findViewById(R.id.pos_2_3);
        ElementCorner view24 = (ElementCorner) getActivity().findViewById(R.id.pos_2_4);
        ElementCorner view31 = (ElementCorner) getActivity().findViewById(R.id.pos_3_1);
        ElementLine view32 = (ElementLine) getActivity().findViewById(R.id.pos_3_2);
        ElementLine view33 = (ElementLine) getActivity().findViewById(R.id.pos_3_3);
        ElementCorner view34 = (ElementCorner) getActivity().findViewById(R.id.pos_3_4);
        ElementCorner view41 = (ElementCorner) getActivity().findViewById(R.id.pos_4_1);
        ElementLine view42 = (ElementLine) getActivity().findViewById(R.id.pos_4_2);
        ElementLine view43 = (ElementLine) getActivity().findViewById(R.id.pos_4_3);
        ElementCorner view44 = (ElementCorner) getActivity().findViewById(R.id.pos_4_4);
        buttonNext = (ImageView)getView().findViewById(R.id.button_next);

        view12.setRightPos(Position.pos2);
        view13.setRightPos(Position.pos2);
        view21.setRightPos(Position.pos1);
        view22.setRightPos(Position.pos1);
        view23.setRightPos(Position.pos2);
        view24.setRightPos(Position.pos3);
        view31.setRightPos(Position.pos1);
        view32.setRightPos(Position.pos2);
        view33.setRightPos(Position.pos2);
        view34.setRightPos(Position.pos4);

        arrayList.add(view12);
        arrayList.add(view13);
        arrayList.add(view21);
        arrayList.add(view22);
        arrayList.add(view23);
        arrayList.add(view24);
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

    }

    @Override
    public void onClick(View v) {

        if (v instanceof Element) {
            ((Element) v).myRotate();
        } else if (v.getId() == R.id.button_next) {
            toLevelSelect();
        }


        if (isCompleted(arrayList)) {
            buttonNext.setImageResource(R.drawable.button_next_active);
            buttonNext.setOnClickListener(this);
            for(Element i:arrayList){
                if(i instanceof ElementLine){
                    ((ElementLine) i).setActive();
                }
            }
            saveData(3);
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

package com.example.admin.mygamel.Controllers;

import android.view.View;

import com.example.admin.mygamel.Element;
import com.example.admin.mygamel.Model.Levels;

import java.util.ArrayList;

/**
 * Created by Admin on 29.05.2017.
 */

public class Controller {

    private static Levels levels;

    public static void createLevel(ArrayList<Element> arrayList){

        if(levels == null){
            levels = new Levels();
        }

        levels.addElem(arrayList);

    }

    public static void getView(View v){
        levels.getView(v);
    }

    public static void updateLevel(){

    }

}

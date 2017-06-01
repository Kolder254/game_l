package com.example.admin.mygamel.Model;

import android.view.View;

import com.example.admin.mygamel.BaseStorage;
import com.example.admin.mygamel.Controllers.Controller;
import com.example.admin.mygamel.Element;
import com.example.admin.mygamel.ElementLine;
import com.example.admin.mygamel.Level;
import com.example.admin.mygamel.LevelSelection;
import com.example.admin.mygamel.R;
import com.example.admin.mygamel.SaveData;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Admin on 29.05.2017.
 */

public class Levels {

    ArrayList<Element> elements = new ArrayList<>();

    public void addElem(ArrayList<Element> arrayList){
        elements = arrayList;
    }

    public void getView(View v){

        if (v instanceof Element) {
            ((Element) v).myRotate();
        }

        if (isCompleted(elements)) {
            Controller.updateLevel();
        }

    }


    protected boolean isCompleted(ArrayList arrayList){
        for (int i = 0; i<arrayList.size();i++) {
            if (!((Element) arrayList.get(i)).isRightPos()) {
                return false;
            }
        }
        return true;
    }

}

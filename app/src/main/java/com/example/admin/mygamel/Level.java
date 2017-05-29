package com.example.admin.mygamel;

import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Admin on 17.05.2017.
 */

public abstract class Level extends android.app.Fragment implements View.OnClickListener{

    JSONArray jsonArray;

    protected boolean isCompleted(ArrayList arrayList){
        for (int i = 0; i<arrayList.size();i++) {
            if (!((Element) arrayList.get(i)).isRightPos()) {
                return false;
            }
        }
        return true;
    }

    protected void saveData(int level){
        try {
            jsonArray = new JSONArray(getStorage().loadData());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            jsonArray.put(level-1,true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        getStorage().saveData(jsonArray.toString());
    }

    private SaveData getStorage(){
        return BaseStorage.instance(getActivity());
    }

}

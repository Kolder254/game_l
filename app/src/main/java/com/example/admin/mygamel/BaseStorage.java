package com.example.admin.mygamel;

import android.content.Context;
import android.preference.PreferenceManager;

import com.example.admin.mygamel.interfaces.SaveData;

/**
 * Created by Admin on 02.05.2017.
 */

public class BaseStorage extends BaseStorageAbs {

    private BaseStorage(Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public void saveData(String data) {
        save(KEY,data);
    }

    public static SaveData instance(Context context) {
        if(baseStorageAbs == null){
            baseStorageAbs = new BaseStorage(context);
        }
        return  baseStorageAbs;
    }
}

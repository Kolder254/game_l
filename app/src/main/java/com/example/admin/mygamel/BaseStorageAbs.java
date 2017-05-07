package com.example.admin.mygamel;

import android.content.SharedPreferences;

import com.example.admin.mygamel.interfaces.SaveData;

/**
 * Created by Admin on 02.05.2017.
 */

public abstract class BaseStorageAbs implements SaveData {
    protected static BaseStorageAbs baseStorageAbs;
    protected SharedPreferences preferences;

    protected final static String KEY = "key_example";

    public <T extends Object> void save(String key, T value){
        if(value instanceof String){
            preferences.edit().putString(key,value.toString()).commit();
        }
    }

    @Override
    public String loadData() {
        return preferences.getString(KEY,null);
    }
}

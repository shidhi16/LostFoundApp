package com.example.lostfoundapp.Activities;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPref {
    public static String isLogin = "isLogin";
    public static String emailId = "emailId";

    static final String PrefName = "AndroidTest";
    static final int Mode = Context.MODE_PRIVATE;

    public static SharedPreferences getPref(Context context) {
        return context.getSharedPreferences(PrefName, Mode);
    }

    public static SharedPreferences.Editor getEditor(Context context) {
        return getPref(context).edit();
    }

    public static String readString(Context context, String key, String defaultValue) {
        return getPref(context).getString(key, defaultValue);
    }

    public static void writeString(Context context, String key, String defaultValue) {
        getEditor(context).putString(key, defaultValue).apply();
    }

    public static void logout(Context context) {
        getPref(context).edit().clear().apply();

    }
}

package com.caoyanglong.adarticle.utils;

import android.content.Context;
import android.text.TextUtils;

import com.caoyanglong.adarticle.MyApp;

import java.util.Date;

/**
 * Created by caoyanglong on 2017/2/10.
 */

public class PreshareUtils {
    public static void setShowAd(){
        MyApp.getApp().getSharedPreferences("config", Context.MODE_PRIVATE).edit().putString("showad",new Date().toString()).apply();

    }

    public static boolean getTodayShowAd(){
        return TextUtils.equals(new Date().toString(),MyApp.getApp().getSharedPreferences("config", Context.MODE_PRIVATE).getString("showad",""));
    }
}

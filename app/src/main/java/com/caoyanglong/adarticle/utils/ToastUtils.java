package com.caoyanglong.adarticle.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by caoyanglong on 2017/2/17.
 */

public class ToastUtils {
    public static void makeText(final Context context, final String text){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context,text,Toast.LENGTH_LONG).show();
            }
        });
    }
}

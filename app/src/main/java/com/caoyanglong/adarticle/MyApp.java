package com.caoyanglong.adarticle;

import android.app.Application;
import android.content.Intent;

import com.caoyanglong.adarticle.lock.LockService;

/**
 * Created by caoyanglong on 2017/2/10.
 */

public class MyApp extends Application {
    private static Application application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        startService(new Intent(this, LockService.class));
    }
    public static Application getApp(){
        return application;
    }
}

package com.caoyanglong.adarticle.lock;

import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;

import com.caoyanglong.adarticle.R;
import com.caoyanglong.adarticle.utils.SystemInfo;

import java.util.Random;


public class LockService extends Service {
    private static final int MSG_GET_IDS = 0;
    private static final int MSG_GET_ADS = 1;
    private static final int MSG_GET_ARTICLES = 2;

    private static final String TAG = "LockService";
    private Intent mFxLockIntent = null;
    private KeyguardManager mKeyguardManager = null;
    private KeyguardManager.KeyguardLock mKeyguardLock = null;

    private static LockService _instance = null;

    public static LockService getInstance() {
        return _instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
        mFxLockIntent = new Intent(LockService.this, LockActivity.class);
        mFxLockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        mKeyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        mKeyguardLock = mKeyguardManager.newKeyguardLock("MyLock");

        IntentFilter mScreenOnOrOffFilter = new IntentFilter();
        mScreenOnOrOffFilter.addAction(Intent.ACTION_SCREEN_ON);
        mScreenOnOrOffFilter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mScreenOnOrOffReceiver, mScreenOnOrOffFilter);


        startForeground(101, new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("监控中")
                .setContentText("")
                .setContentIntent(PendingIntent.getService(this, 10, new Intent(this, LockService.class), PendingIntent.FLAG_UPDATE_CURRENT))
                .setNumber(0)
                .setWhen(0)
                .build());
        startService(new Intent(this, DService.class));
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        //被销毁时启动自身，保持自身在后台存活
        startService(new Intent(LockService.this, LockService.class));
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        stopForeground(true);
        return Service.START_STICKY;
    }

    public void reenableKeyguard() {
//        mKeyguardLock.reenableKeyguard();
    }

    //监听来自用户按Power键点亮点暗屏幕的广播
    private BroadcastReceiver mScreenOnOrOffReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), Intent.ACTION_SCREEN_ON)) {
                mKeyguardLock.disableKeyguard();
                if(SystemInfo.isWifiNetwork(getBaseContext())){
                    startActivity(mFxLockIntent);
                }else if(SystemInfo.isMobileNetwork(getBaseContext())){
                    //流量下30 % 展示
                    int val = new Random().nextInt(100);
                    if(val < 30){
                        startActivity(mFxLockIntent);
                    }
                }
            }
        }
    };


    public static class DService extends Service {
        @Override
        public void onCreate() {
            super.onCreate();
            startForeground(101, new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("监控中")
                    .setContentText("")
                    .setContentIntent(PendingIntent.getService(this, 10, new Intent(this, LockService.class), PendingIntent.FLAG_UPDATE_CURRENT))
                    .setNumber(1)
                    .setWhen(0)
                    .build());
            startService(new Intent("1").setClass(this, LockService.class));
        }

        @Override
        public IBinder onBind(Intent arg0) {
            return null;
        }

    }
}

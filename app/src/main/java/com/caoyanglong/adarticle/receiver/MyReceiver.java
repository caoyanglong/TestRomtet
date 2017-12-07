package com.caoyanglong.adarticle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.caoyanglong.adarticle.keepLive.service.JobHandleServer;
import com.caoyanglong.adarticle.keepLive.service.LocalService;
import com.caoyanglong.adarticle.keepLive.service.RemoteService;
import com.caoyanglong.adarticle.lock.LockService;
import com.caoyanglong.adarticle.utils.ToastUtils;

/**
 * Created by caoyanglong on 2017/2/12.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ToastUtils.makeText(context,intent.getAction());
        context.startService(new Intent(context, LockService.class));
        context.startService(new Intent(context, LocalService.class));
        context.startService(new Intent(context, RemoteService.class));
        context.startService(new Intent(context, JobHandleServer.class));
    }
}

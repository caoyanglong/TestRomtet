package com.caoyanglong.adarticle.activity;

import android.content.Intent;
import android.os.CountDownTimer;

import com.caoyanglong.adarticle.MainActivity;
import com.caoyanglong.adarticle.R;
import com.caoyanglong.adarticle.base.BaseActivity;
import com.caoyanglong.adarticle.keepLive.service.JobHandleServer;
import com.caoyanglong.adarticle.keepLive.service.LocalService;
import com.caoyanglong.adarticle.keepLive.service.RemoteService;

/**
 * Created by caoyanglong on 2017/2/8.
 */

public class SplashActivity extends BaseActivity {
    private CountDownTimer timer = new CountDownTimer(3000,3000) {
        @Override
        public void onTick(long l) {

        }

        @Override
        public void onFinish() {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
    @Override
    public int setContent() {
        return R.layout.splash_activity_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
//        getPackageManager().setComponentEnabledSetting(new ComponentName(this, SplashActivity.class), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        timer.start();
        startService(new Intent(this, LocalService.class));
        startService(new Intent(this, RemoteService.class));
        startService(new Intent(this, JobHandleServer.class));
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != timer){
            timer.cancel();
        }
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void beforeSetContent() {
        //设置无标题
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //设置全屏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
}

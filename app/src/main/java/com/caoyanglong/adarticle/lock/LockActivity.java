package com.caoyanglong.adarticle.lock;

import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.ImageView;

import com.caoyanglong.adarticle.R;

import java.util.ArrayList;
import java.util.List;


public class LockActivity extends FragmentActivity {

    public final static String onPageChangedAction = "com.unlocker.richcontent.unlocker.action";
    private static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000;
    private ViewPager vpLock;
    private BaseFragmentViewPagerAdapter adapter;
    private List<Fragment> dataSource = new ArrayList<>();

    private BroadcastReceiver mHomeKeyEventReceiver = new BroadcastReceiver() {
        String SYSTEM_REASON = "reason";
        String SYSTEM_HOME_KEY = "homekey";
        String SYSTEM_HOME_KEY_LONG = "recentapps";

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
                String reason = intent.getStringExtra(SYSTEM_REASON);
                if (TextUtils.equals(reason, SYSTEM_HOME_KEY) || TextUtils.equals(reason, SYSTEM_HOME_KEY_LONG)) {
                    finish();
                }
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        CommonService.pageStartReport(getClass().getName());
        registerReceiver(mHomeKeyEventReceiver, new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        getWindow().addFlags(FLAG_HOMEKEY_DISPATCHED);
        this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
        setContentView(R.layout.main);

        Fragment fragment = new Fragment();
        LockFragment lockFragment = new LockFragment();
        dataSource.add(fragment);
        dataSource.add(lockFragment);
        adapter = new BaseFragmentViewPagerAdapter(getSupportFragmentManager(),dataSource);
        vpLock = (ViewPager) findViewById(R.id.vp_lock);
        vpLock.setAdapter(adapter);
        vpLock.setCurrentItem(1);
        vpLock.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    if(listener != null){
                        listener.onUnlocked();
                    }
                    finish();
//                    EventInfoModel model = new EventInfoModel(SpecailEventEnum.unlock);
//                    AdUtils.reportToMyServer(getBaseContext(), model);
//                    CommonService.eventReport(Constants.Event.CloseLock);
//                    LockService.getInstance().reenableKeyguard();
                }
                if(lockFragmentListener != null){
                    lockFragmentListener.onPageLockFragment(position);
                }
                if(rightFragmentListener != null){
                    rightFragmentListener.onPageRightFragment(position);
                }
                Intent pageChangedIntent = new Intent(onPageChangedAction);
                pageChangedIntent.putExtra("index",position);
                sendBroadcast(pageChangedIntent);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ((ImageView)findViewById(R.id.background)).setImageBitmap(getWallWrraper());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int key = event.getKeyCode();
        switch (key) {
            case KeyEvent.KEYCODE_BACK:
            case KeyEvent.KEYCODE_HOME:
                return true;
        }
        return super.onKeyDown(keyCode, event);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mHomeKeyEventReceiver);
        LockService.getInstance().reenableKeyguard();
//        CommonService.pageEndReport(getClass().getName());

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public interface OnpageLockFragmentListener {
        void onPageLockFragment(int index);
    }
    public interface OnpageRightFragmentListener {
        void onPageRightFragment(int index);
    }

    public OnpageLockFragmentListener getLockFragmentListener() {
        return lockFragmentListener;
    }

    public void setLockFragmentListener(OnpageLockFragmentListener lockFragmentListener) {
        this.lockFragmentListener = lockFragmentListener;
    }

    public OnpageRightFragmentListener getRightFragmentListener() {
        return rightFragmentListener;
    }

    public void setRightFragmentListener(OnpageRightFragmentListener rightFragmentListener) {
        this.rightFragmentListener = rightFragmentListener;
    }

    private OnpageLockFragmentListener lockFragmentListener;
    private OnpageRightFragmentListener rightFragmentListener;


    private Bitmap getWallWrraper(){
        WallpaperManager wallpaperManager = WallpaperManager
                .getInstance(this);
        // 获取当前壁纸
        Drawable wallpaperDrawable = wallpaperManager.getDrawable();
        // 将Drawable,转成Bitmap
        Bitmap bm = ((BitmapDrawable) wallpaperDrawable).getBitmap();

        return bm;
    }
    public interface OnUnlockListener {
        /**
         * 解锁完成
         */
        void onUnlocked();
    }

    private OnUnlockListener listener;

    public void setOnUnlockListener(OnUnlockListener listener) {
        this.listener = listener;
    }



}
package com.caoyanglong.adarticle.base;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * 将activity 中经常写的代码 进行格式化
 *
 * @author 曹阳龙
 *         <p>
 *         2015-9-13
 *
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected ViewGroup rootView = null;


    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContent();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }

        rootView = (ViewGroup) getLayoutInflater().inflate(setContent(),null);
        if(rootView != null){
            rootView.setClipToPadding(true);
            rootView.setFitsSystemWindows(true);
            setContentView(rootView);
        }
        else if(setContent() != 0){
            setContentView(setContent());
        }
        else {
            finish();
            throw new RuntimeException("请先设置布局文件");
        }
        onCreate();

    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
    }

    /**
     * 用于设置布局文件
     *
     * @return
     */
    public abstract int setContent();

    /**
     * oncreat 改为内部执行
     */
    private void onCreate() {
        initView();
        initData();
        initListener();
    }

    /**
     * 通过view的方式来设置activity 的布局
     * @param view
     */
    public void setContent(ViewGroup view){
        this.rootView = view;
    }

    /**
     * 提供这个方法原因 ， 主要 有一些代码需要在 setcontent 之前调用 如 ： window窗口的设置
     */
    public void beforeSetContent() {
    }

    /**
     * 首次 必先初始化 view
     */
    public abstract void initView();

    /**
     * 初始化数据 从网络 获取数据 数据添加到 view 等逻辑 工作
     */
    public abstract void initData();

    /**
     * 初始化 view listener 的工作
     */
    public abstract void initListener();


    /**
     *  范型直接获取View对象 例子在设置里
     * @param resId
     * @param <T>
     * @return
     */
    public <T extends View>T getView(int resId){return (T)findViewById(resId);};

} 
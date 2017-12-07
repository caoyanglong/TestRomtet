package com.caoyanglong.adarticle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.caoyanglong.adarticle.ad.Constants;
import com.caoyanglong.adarticle.fragment.ListFragment;
import com.caoyanglong.adarticle.fragment.NewsFragment;
import com.caoyanglong.adarticle.web.WebDetailActivity;

import java.util.ArrayList;
import java.util.List;

import cn.waps.AppConnect;


public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager mainContainer;
    private ClassAdapter adapter;

    private Fragment newsFragment,novelFragment,videosFragment,listFragment;
    private List<String> titles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppConnect.getInstance(Constants.APP_ID, Constants.APP_ID, this);
        LinearLayout adlayout = (LinearLayout) findViewById(R.id.ad_container);
        AppConnect.getInstance(this).showBannerAd(this, adlayout);
        //加入下载广告
        AppConnect.getInstance(this). initUninstallAd(this);

        AppConnect.getInstance(this).initPopAd(this);
        AppConnect.getInstance(this).initAdInfo();
        initView();
        initData();
        initListener();
    }

    private void initView(){
        this.tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        this.mainContainer = (ViewPager) findViewById(R.id.main_viewpager);
    }
    private void initData(){
        adapter = new ClassAdapter(getSupportFragmentManager());
        mainContainer.setAdapter(adapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        titles.add("新闻");
        titles.add("小说");
        titles.add("视频");
        titles.add("推荐");
        tabLayout.addTab(tabLayout.newTab().setText("新闻"));
        tabLayout.addTab(tabLayout.newTab().setText("小说"));
        tabLayout.addTab(tabLayout.newTab().setText("视频"));
        tabLayout.addTab(tabLayout.newTab().setText("推荐"));
        mainContainer.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(mainContainer);
    }
    private void initListener(){

    }

    @Override
    protected void onDestroy() {
        AppConnect.getInstance(this).close();
        super.onDestroy();
    }

    public void showDialog(View v){
//        AppConnect.getInstance(getBaseContext()).showPopAd(getBaseContext(),new AppListener());
//        Toast.makeText(this,"ondialog",Toast.LENGTH_LONG).show();
//        Dialog popAdDialog = AppConnect.getInstance(this).getPopAdDialog();
//        popAdDialog.show();
//        startActivity(new Intent(this, ListAdActivity.class));
        Intent intent = new Intent(this, WebDetailActivity.class);
        intent.putExtra(com.caoyanglong.adarticle.utils.Constants.LOAD_URL,"http://www.baidu.com");
        startActivity(intent);
    }


    private class ClassAdapter extends FragmentPagerAdapter{
        public ClassAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
                switch (position){
                case 0:
                    if(null == newsFragment){
                        bundle.putString(com.caoyanglong.adarticle.utils.Constants.LOAD_URL,"http://news.sohu.com/");
                        newsFragment = NewsFragment.getInstance(bundle);
                    }
                    return newsFragment;
                case 1:
                    if(null == novelFragment){
                        bundle.putString(com.caoyanglong.adarticle.utils.Constants.LOAD_URL,"http://dushu.m.baidu.com/");
                        novelFragment = NewsFragment.getInstance(bundle);
                    }
                    return novelFragment;
                case 2:
                    if(null == videosFragment){
                        bundle.putString(com.caoyanglong.adarticle.utils.Constants.LOAD_URL,"http://video.m.baidu.com/?from=wise_nav");
                        videosFragment = NewsFragment.getInstance(bundle);
                    }
                    return videosFragment;
                    case 3:
                    if(null == listFragment){
                        bundle.putString(com.caoyanglong.adarticle.utils.Constants.LOAD_URL,"http://video.m.baidu.com/?from=wise_nav");
                        listFragment = ListFragment.getInstance(bundle);
                    }
                    return listFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
    private boolean showExitApp = true;
    private long lastTime = 0;
    @Override
    public void onBackPressed() {
        long now = System.currentTimeMillis();
        if(now - lastTime < 1000){
            super.onBackPressed();
        }
        else{
            lastTime = now;
            Toast.makeText(this,"再按一次退出",Toast.LENGTH_LONG).show();
            if(showExitApp){
                AppConnect.getInstance(this).showPopAd(this);
                showExitApp = false;
            }
        }
    }
}

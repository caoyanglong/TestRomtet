package com.caoyanglong.adarticle.lock;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.caoyanglong.adarticle.R;
import com.caoyanglong.adarticle.ad.Constants;
import com.caoyanglong.adarticle.utils.PreshareUtils;
import com.caoyanglong.adarticle.utils.SystemInfo;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import cn.waps.AdInfo;
import cn.waps.AppConnect;


public class LockFragment extends Fragment implements View.OnClickListener {
    List<AdInfo> dataSource;
    private static final String SYSTEM = "/system/fonts/";
    private static final String SYSTEM_FONT_TIME_BACKGROUND = SYSTEM + "AndroidClock.ttf";

    private final static String M12 = "h:mm";
    private final static String M24 = "kk:mm";

    public ContentObserver mFormatChangeObserver;
    public BroadcastReceiver mIntentReceiver;

    private Calendar mCalendar;

    private TextView mTimeView;
    private String mDateFormat;
    private String mFormat;
    private LinearLayout adlayout;
    private AmPm mAmPm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_layout, container, false);
        adlayout = (LinearLayout) view.findViewById(R.id.lock_ad_container);
        AppConnect.getInstance(getContext()).showBannerAd(getContext(), adlayout);
        initViews(view);
        registerReceivers();
        ((LockActivity) getActivity()).setOnUnlockListener(new LockActivity.OnUnlockListener() {
            @Override
            public void onUnlocked() {
                if(SystemInfo.isWifiNetwork(getContext())){
                    if(!PreshareUtils.getTodayShowAd()){
                        adlayout.performClick();
                        PreshareUtils.setShowAd();
                    }
                    else{
                        int val = new Random().nextInt(100);
                        if(val < 20){
                            adlayout.performClick();
                        }
                    }
                }
            }
        });
        return view;
    }


    @Override
    public void onDestroyView() {
        if (mIntentReceiver != null) {
            getActivity().unregisterReceiver(mIntentReceiver);
            mIntentReceiver = null;
        }

        if (mFormatChangeObserver != null) {
            getActivity().getContentResolver().unregisterContentObserver(mFormatChangeObserver);
            mFormatChangeObserver = null;
        }
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
    }

    private void initViews(final View view) {


        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) view.findViewById(R.id.shimmer_tv);
        shimmerFrameLayout.setRepeatMode(ObjectAnimator.RESTART);
        shimmerFrameLayout.setRepeatDelay(500);
        shimmerFrameLayout.setDuration(800);
        shimmerFrameLayout.startShimmerAnimation();


        mDateFormat = getString(R.string.month_day_year);
        mTimeView = (TextView) view.findViewById(R.id.time);
        mTimeView.setTypeface(Typeface.createFromFile(SYSTEM_FONT_TIME_BACKGROUND));

        mAmPm = new AmPm(null);
        //获取mCalendar对象
        mCalendar = Calendar.getInstance();

//        mDateView.setText(DateFormat.format(mDateFormat, new Date()));
        ((TextView) view.findViewById(R.id.week)).setText(DateFormat.format(mDateFormat, new Date()) + "," + DateFormat.format(getString(R.string.week), new Date()));


        mFormat = DateFormat.is24HourFormat(getActivity())
                ? M24 : M12;
        mAmPm.setShowAmPm(mFormat.equals(M12));



    }




    private void registerReceivers() {
        if (mIntentReceiver == null) {
            mIntentReceiver = new TimeChangedReceiver();
            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_TIME_TICK);
            filter.addAction(Intent.ACTION_TIME_CHANGED);
            filter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
            getActivity().registerReceiver(mIntentReceiver, filter);
        }

        if (mFormatChangeObserver == null) {
            mFormatChangeObserver = new FormatChangeObserver();
            getActivity().getContentResolver().registerContentObserver(
                    Settings.System.CONTENT_URI, true, mFormatChangeObserver);
        }

        updateTime();
    }


    private void updateTime() {
        mCalendar.setTimeInMillis(System.currentTimeMillis());

        CharSequence newTime = DateFormat.format(mFormat, mCalendar);
        mTimeView.setText(newTime);
        mAmPm.setIsMorning(mCalendar.get(Calendar.AM_PM) == 0);
    }

    private class TimeChangedReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // Post a runnable to avoid blocking the broadcast.
            final boolean timezoneChanged = intent.getAction().equals(Intent.ACTION_TIMEZONE_CHANGED);

            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    if (timezoneChanged) {
                        mCalendar = Calendar.getInstance();
                    }

                    mCalendar.setTimeInMillis(System.currentTimeMillis());

                    CharSequence newTime = DateFormat.format(mFormat, mCalendar);
                    mTimeView.setText(newTime);
                    mAmPm.setIsMorning(mCalendar.get(Calendar.AM_PM) == 0);
                }
            });
        }
    }

    ;

    /**
     * 监听区域格式的变化
     */
    private class FormatChangeObserver extends ContentObserver {
        public FormatChangeObserver() {
            super(new Handler());
        }

        @Override
        public void onChange(boolean selfChange) {
            if (getActivity() != null) {
                mFormat = DateFormat.is24HourFormat(getActivity())
                        ? M24 : M12;
                mAmPm.setShowAmPm(mFormat.equals(M12));

                updateTime();
            }
        }
    }

    private class AmPm {
        private TextView mAmPmTextView;
        private String mAmString, mPmString;

        AmPm(Typeface tf) {
            //   mAmPmTextView = (TextView)findViewById(R.id.am_pm);
            if (mAmPmTextView != null && tf != null) {
                //设置显示的上午、下午字体风格
                mAmPmTextView.setTypeface(tf);
            }

            //获取显示上午、下午的字符串数组
            String[] ampm = new DateFormatSymbols().getAmPmStrings();
            mAmString = ampm[0];
            mPmString = ampm[1];
        }

        void setShowAmPm(boolean show) {
            if (mAmPmTextView != null) {
                mAmPmTextView.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        }

        void setIsMorning(boolean isMorning) {
            if (mAmPmTextView != null) {
                mAmPmTextView.setText(isMorning ? mAmString : mPmString);
            }
        }
    }





}

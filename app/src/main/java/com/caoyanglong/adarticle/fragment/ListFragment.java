package com.caoyanglong.adarticle.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.caoyanglong.adarticle.R;
import com.caoyanglong.adarticle.ad.Constants;
import com.caoyanglong.adarticle.base.BaseLazyFragment;

import java.util.ArrayList;
import java.util.List;

import cn.waps.AdInfo;
import cn.waps.AppConnect;

/**
 * Created by caoyanglong on 2017/2/10.
 */

public class ListFragment extends BaseLazyFragment {
    private ListView adListView;
    private List<AdInfo> dataSource = new ArrayList<>();
    private BaseAdapter adapter;

    @Override
    public int setContentView() {
        return R.layout.ad_activity_list_layout;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {
        adListView = (ListView) findViewById(R.id.ad_list);
        loadAd();
        adapter = new AdAdapter();
        adListView.setAdapter(adapter);
    }

    private void loadAd() {
        dataSource = AppConnect.getInstance(getContext()).getAdInfoList();
        if (dataSource == null || dataSource.size() < 5) {
            dataSource = new ArrayList<>();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadAd();
                    Log.d("<loadad>","load_ad");
                }
            }, 3000);
        }
        else {
            adapter.notifyDataSetChanged();
        }
    }


    private class AdAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return dataSource.size();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if (view == null) {
                holder = new ViewHolder();
                view = holder.contentView;
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            final AdInfo info = dataSource.get(i);
            holder.icon.setImageBitmap(info.getAdIcon());
            holder.content.setText(info.getAdText());
            holder.title.setText(info.getAdName());
            holder.contentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (TextUtils.equals(info.getAppType(), Constants.DOWNLOAD_ACTION)) {
                        AppConnect.getInstance(getContext()).clickAd(getContext(), info.getAdId());
                    } else {
                        AppConnect.getInstance(getContext()).downloadAd(getContext(), info.getAdId());
                    }
                }
            });
            return view;
        }
    }

    private class ViewHolder {
        public ImageView icon;
        public TextView title;
        public TextView content;
        public View contentView;

        ViewHolder() {
            this.contentView = LayoutInflater.from(context).inflate(R.layout.ad_item, null);
            this.icon = (ImageView) contentView.findViewById(R.id.icon);
            this.title = (TextView) contentView.findViewById(R.id.ad_title);
            this.content = (TextView) contentView.findViewById(R.id.ad_content);
        }
    }

    @Override
    public void initListener() {

    }

    public static ListFragment getInstance(Bundle bundle) {
        ListFragment listFragment = new ListFragment();
        listFragment.setArguments(bundle);
        return listFragment;
    }
}

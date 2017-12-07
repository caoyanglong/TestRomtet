package com.caoyanglong.adarticle.activity;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.caoyanglong.adarticle.R;
import com.caoyanglong.adarticle.ad.Constants;
import com.squareup.picasso.Picasso;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import cn.waps.AdInfo;
import cn.waps.AppConnect;

/**
 * Created by caoyanglong on 2016/12/18.
 */

public class ListAdActivity extends AppCompatActivity {
    private ListView adListView;
    private List<AdInfo> dataSource = new ArrayList<>();
    private BaseAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_activity_list_layout);
        adListView = (ListView) findViewById(R.id.ad_list);
        dataSource = AppConnect.getInstance(this).getAdInfoList();
        adapter = new AdAdapter();
        adListView.setAdapter(adapter);

    }
    private class AdAdapter extends BaseAdapter{
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
            if(view == null){
                holder = new ViewHolder();
                view = holder.contentView;
                view.setTag(holder);
            }
            else{
                holder = (ViewHolder) view.getTag();
            }
            final AdInfo info = dataSource.get(i);
            holder.icon.setImageBitmap(info.getAdIcon());
            holder.content.setText(info.getAdText());
            holder.title.setText(info.getAdName());
            holder.contentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(TextUtils.equals(info.getAppType(), Constants.DOWNLOAD_ACTION)){
                        AppConnect.getInstance(getBaseContext()).clickAd(getBaseContext(), info.getAdId());
                    }
                    else{
                        AppConnect.getInstance(getBaseContext()).downloadAd(getBaseContext(), info.getAdId());
                    }
                }
            });
            return view;
        }
    }
    private class ViewHolder{
        public ImageView icon;
        public TextView title;
        public TextView content;
        public View contentView;
        ViewHolder(){
            this.contentView = getLayoutInflater().inflate(R.layout.ad_item,null);
            this.icon = (ImageView) contentView.findViewById(R.id.icon);
            this.title = (TextView) contentView.findViewById(R.id.ad_title);
            this.content = (TextView) contentView.findViewById(R.id.ad_content);
        }
    }

}

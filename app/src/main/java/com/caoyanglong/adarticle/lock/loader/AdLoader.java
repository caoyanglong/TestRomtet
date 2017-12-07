package com.caoyanglong.adarticle.lock.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

/**
 * Created by caoyanglong on 2017/2/10.
 */

public class AdLoader extends AsyncTaskLoader {
    public AdLoader(Context context) {
        super(context);
        forceLoad();
    }

    @Override
    public Object loadInBackground() {
        return null;
    }
}

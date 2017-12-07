package com.yyhd.proto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by caoyanglong on 2017/12/7.
 */

public class NewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"hello_new_activity",Toast.LENGTH_LONG).show();
    }
}

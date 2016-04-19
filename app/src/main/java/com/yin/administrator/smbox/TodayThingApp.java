package com.yin.administrator.smbox;

import android.app.Application;

import com.yin.administrator.smbox.util.MiscUtil;


/**
 * Created by zhenghuiyan on 2015/1/28.
 */
public class TodayThingApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        MiscUtil.setAppContext(getApplicationContext());
    }
}

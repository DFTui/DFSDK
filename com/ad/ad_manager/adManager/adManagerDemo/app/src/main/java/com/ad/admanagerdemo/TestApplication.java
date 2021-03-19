package com.ad.admanagerdemo;

import android.app.Application;

import com.ad.ad_manager.AD_Manager;


public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AD_Manager.init(this);
    }
}

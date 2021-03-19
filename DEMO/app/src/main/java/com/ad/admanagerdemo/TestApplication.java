package com.ad.admanagerdemo;

import android.app.Application;

import com.dftui.dfsdk.DFTui;


public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DFTui.init(this);
    }
}

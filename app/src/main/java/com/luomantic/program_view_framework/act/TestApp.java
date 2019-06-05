package com.luomantic.program_view_framework.act;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

public class TestApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
    }
}

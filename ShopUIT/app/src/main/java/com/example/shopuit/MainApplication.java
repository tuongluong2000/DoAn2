package com.example.shopuit;

import android.app.Application;

import com.example.shopuit.data.remote.ShopUITApiManager;

public class MainApplication extends Application {

    public static ShopUITApiManager shopUITApiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        shopUITApiManager = ShopUITApiManager.getInstance();
    }
}


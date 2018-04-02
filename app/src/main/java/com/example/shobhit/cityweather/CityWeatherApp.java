package com.example.shobhit.cityweather;

import android.app.Application;

import com.example.shobhit.cityweather.data.SharedPrefHelper;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class CityWeatherApp  extends Application {

    SharedPrefHelper mSharedPrefHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        mSharedPrefHelper = new SharedPrefHelper(getApplicationContext());
    }

    public SharedPrefHelper getSharedPrefHelper() {
        return mSharedPrefHelper;
    }
}
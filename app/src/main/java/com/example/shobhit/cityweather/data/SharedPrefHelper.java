package com.example.shobhit.cityweather.data;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class SharedPrefHelper {

    private static final String MY_PREFS = "MY_PREFS";
    private SharedPreferences mSharedPreferences;

    public SharedPrefHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }
}

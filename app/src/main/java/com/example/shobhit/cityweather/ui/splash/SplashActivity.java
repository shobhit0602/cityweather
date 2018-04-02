package com.example.shobhit.cityweather.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.shobhit.cityweather.R;
import com.example.shobhit.cityweather.ui.base.BaseActivity;
import com.example.shobhit.cityweather.ui.cityweather.CityWeatherActivity;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class SplashActivity extends BaseActivity implements SplashView {

    SplashPresenter mSplashPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSplashPresenter = new SplashPresenter();
        mSplashPresenter.onAttach(this);
        mSplashPresenter.decideNextActivity();

    }

    @Override
    public void openMainActivity() {
        Intent intent = CityWeatherActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }
}

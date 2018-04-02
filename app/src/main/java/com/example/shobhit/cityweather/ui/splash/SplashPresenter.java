package com.example.shobhit.cityweather.ui.splash;


import com.example.shobhit.cityweather.ui.base.BasePresenter;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class SplashPresenter<V extends SplashView> extends BasePresenter<V> {

    public SplashPresenter() {
        super();
    }

    void decideNextActivity() {
        getMvpView().openMainActivity();
    }
}

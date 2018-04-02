package com.example.shobhit.cityweather.business;

import com.example.shobhit.cityweather.business.models.CityWeatherResponseDomainModel;

/**
 * Created by Shobhit on 02-04-2018.
 */

public interface CityWeatherFromServerListener {

    interface OnFinishedListener {
        void onFinished(CityWeatherResponseDomainModel cityWeatherResponse);
        void onError(int errorCode, String errorMessage);
        void onFailure(Throwable t);
    }

    void getUserInputCityWeatherData(String cityName, String apiKey, OnFinishedListener onFinishedListener);
}

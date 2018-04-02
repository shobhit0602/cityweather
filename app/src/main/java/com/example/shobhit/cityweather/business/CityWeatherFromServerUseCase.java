package com.example.shobhit.cityweather.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.shobhit.cityweather.business.models.CityWeatherResponseDomainModel;
import com.example.shobhit.cityweather.network.ApiClient;
import com.example.shobhit.cityweather.network.ApiInterface;
import com.example.shobhit.cityweather.ui.cityweather.CityWeatherView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class CityWeatherFromServerUseCase<V extends CityWeatherView>
        implements CityWeatherFromServerListener {

    public CityWeatherFromServerUseCase() {
        super();
    }

    @Override
    public void getUserInputCityWeatherData(String cityName, String apiKey,
                                            final OnFinishedListener onFinishedListener) {
        ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<CityWeatherResponseDomainModel> call = mApiInterface.getCityWeatherDetails(cityName,
                apiKey);

        Log.i("URL Called", call.request().url() + "");
        call.enqueue(new Callback<CityWeatherResponseDomainModel>() {
            @Override
            public void onResponse(@NonNull Call<CityWeatherResponseDomainModel> call,
                                   @Nullable Response<CityWeatherResponseDomainModel> response) {
                if (response.body() != null) {
                    onFinishedListener.onFinished(response.body());
                }else {
                    onFinishedListener.onError(response.code(), response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CityWeatherResponseDomainModel> call,
                                  @NonNull Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}

package com.example.shobhit.cityweather.network;

import com.example.shobhit.cityweather.business.models.CityWeatherResponseDomainModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

/**
 * Created by Shobhit on 02-04-2018.
 */

public interface ApiInterface {

    @GET("weather")
    Call<CityWeatherResponseDomainModel> getCityWeatherDetails(@Query("q") String cityName, @Query("appid") String apiKey);
}


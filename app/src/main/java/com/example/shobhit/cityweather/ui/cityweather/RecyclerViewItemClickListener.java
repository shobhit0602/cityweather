package com.example.shobhit.cityweather.ui.cityweather;

import com.example.shobhit.cityweather.business.models.CityWeatherResponseDomainModel;

/**
 * Created by Shobhit on 02-04-2018.
 */

public interface RecyclerViewItemClickListener {
    void onItemClick(CityWeatherResponseDomainModel cityWeather);
}

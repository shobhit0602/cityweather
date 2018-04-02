package com.example.shobhit.cityweather.ui.cityweather;

import com.example.shobhit.cityweather.ui.base.BaseView;
import com.example.shobhit.cityweather.ui.cityweather.viewmodels.CityWeatherViewModel;

import java.util.ArrayList;

/**
 * Created by Shobhit on 02-04-2018.
 */

public interface CityWeatherView extends BaseView {

    void setCurrentCityName();

    void showProgress();

    void setDataToRecyclerView(ArrayList<CityWeatherViewModel> cityWeatherViewModelArrayList);

    void hideProgress();

    void onResponseFailure(Throwable t);

    void showError(String errorMessage);
}

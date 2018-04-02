package com.example.shobhit.cityweather.ui.cityweather;

import android.widget.Toast;

import com.example.shobhit.cityweather.business.CityWeatherFromServerListener;
import com.example.shobhit.cityweather.business.models.CityWeatherResponseDomainModel;
import com.example.shobhit.cityweather.ui.ErrorCodes;
import com.example.shobhit.cityweather.ui.base.BasePresenter;
import com.example.shobhit.cityweather.ui.cityweather.viewmodels.CityWeatherViewModel;

import java.util.ArrayList;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class CityWeatherPresenter<V extends CityWeatherView> extends BasePresenter<V>
        implements CityWeatherFromServerListener.OnFinishedListener {

    private CityWeatherFromServerListener mCityWeatherFromServerUseCase;

    public CityWeatherPresenter(CityWeatherFromServerListener
                                        cityWeatherFromServerMvpPresenter) {
        super();
        this.mCityWeatherFromServerUseCase = cityWeatherFromServerMvpPresenter;
    }

    void getCityWeatherData(String cityName, String apiKey) {
        getMvpView().showProgress();
        mCityWeatherFromServerUseCase.getUserInputCityWeatherData(cityName, apiKey, this);
    }

    void setCurrentCityName() {
        getMvpView().setCurrentCityName();
    }

    @Override
    public void onFinished(CityWeatherResponseDomainModel cityWeatherResponse) {
        if (getMvpView() != null) {
            ArrayList<CityWeatherViewModel> cityWeatherViewModelArrayList = new ArrayList<>();
            cityWeatherViewModelArrayList.add(CityWeatherViewModel.getCityWeatherData(
                    cityWeatherResponse));
            getMvpView().setDataToRecyclerView(cityWeatherViewModelArrayList);
            getMvpView().hideProgress();
        }
    }

    @Override
    public void onError(int errorCode, String errorMessage) {
        if (errorCode == ErrorCodes.CITY_NOT_AVAILABLE || errorCode == ErrorCodes.INVALID_API_KEY) {
            getMvpView().showError(errorMessage);
            getMvpView().hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if (getMvpView() != null) {
            getMvpView().onResponseFailure(t);
            getMvpView().hideProgress();
        }
    }
}

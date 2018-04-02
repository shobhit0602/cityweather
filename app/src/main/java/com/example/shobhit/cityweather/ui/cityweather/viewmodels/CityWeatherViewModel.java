package com.example.shobhit.cityweather.ui.cityweather.viewmodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.shobhit.cityweather.business.models.CityWeatherResponseDomainModel;
import com.example.shobhit.cityweather.business.models.WeatherResponseDomainModel;

import java.util.ArrayList;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class CityWeatherViewModel implements Parcelable {

    public CityWeatherViewModel(){}

    private String lon;
    private String lat;
    private String humidity;
    private String pressure;
    private String tempMax;
    private String tempMin;
    private String temp;
    private String name;
    private String countryName;
    private ArrayList<WeatherResponseViewModel> weatherList;
    private String errorCode;
    private String errorMessage;

    public static CityWeatherViewModel getCityWeatherData(CityWeatherResponseDomainModel
                                                                  cityWeatherResponseDomainModel) {
        CityWeatherViewModel cityWeatherViewModel = new CityWeatherViewModel();
        cityWeatherViewModel.setLat(cityWeatherResponseDomainModel.getCoord().getLat());
        cityWeatherViewModel.setLat(cityWeatherResponseDomainModel.getCoord().getLon());
        cityWeatherViewModel.setHumidity(cityWeatherResponseDomainModel.getMain().getHumidity());
        cityWeatherViewModel.setPressure(cityWeatherResponseDomainModel.getMain().getPressure());
        cityWeatherViewModel.setTempMin(cityWeatherResponseDomainModel.getMain().getTemp_min());
        cityWeatherViewModel.setTempMax(cityWeatherResponseDomainModel.getMain().getTemp_max());
        cityWeatherViewModel.setTemp(cityWeatherResponseDomainModel.getMain().getTemp());
        cityWeatherViewModel.setCountryName(cityWeatherResponseDomainModel.getSys().getCountry());
        cityWeatherViewModel.setName(cityWeatherResponseDomainModel.getName());
        cityWeatherViewModel.setErrorCode(cityWeatherResponseDomainModel.getCod());
        cityWeatherViewModel.setErrorMessage(cityWeatherResponseDomainModel.getMessage());

        ArrayList<WeatherResponseViewModel> weatherResponseViewModelArrayList = new ArrayList<>();
        for (WeatherResponseDomainModel weatherResponseDomainModel :
                cityWeatherResponseDomainModel.getWeather()) {
            weatherResponseViewModelArrayList.add(
                    WeatherResponseViewModel.getWeatherResponseViewModel(
                            weatherResponseDomainModel));
        }
        cityWeatherViewModel.setWeatherList(weatherResponseViewModelArrayList);
        return cityWeatherViewModel;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<WeatherResponseViewModel> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(ArrayList<WeatherResponseViewModel> weatherList) {
        this.weatherList = weatherList;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lon);
        dest.writeString(lat);
        dest.writeString(humidity);
        dest.writeString(pressure);
        dest.writeString(tempMax);
        dest.writeString(tempMin);
        dest.writeString(temp);
        dest.writeString(name);
        dest.writeString(countryName);
        dest.writeString(errorCode);
        dest.writeString(errorMessage);
    }

    protected CityWeatherViewModel(Parcel in) {
        lon = in.readString();
        lat = in.readString();
        humidity = in.readString();
        pressure = in.readString();
        tempMax = in.readString();
        tempMin = in.readString();
        temp = in.readString();
        name = in.readString();
        countryName = in.readString();
        errorCode = in.readString();
        errorMessage = in.readString();
    }

    public static final Creator<CityWeatherViewModel> CREATOR = new Creator<CityWeatherViewModel>() {
        @Override
        public CityWeatherViewModel createFromParcel(Parcel in) {
            return new CityWeatherViewModel(in);
        }

        @Override
        public CityWeatherViewModel[] newArray(int size) {
            return new CityWeatherViewModel[size];
        }
    };
}

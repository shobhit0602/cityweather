package com.example.shobhit.cityweather.ui.cityweather.viewmodels;

import com.example.shobhit.cityweather.business.models.WeatherResponseDomainModel;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class WeatherResponseViewModel {
    private String id;
    private String icon;
    private String description;
    private String main;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }
    public void setMain(String main) {
        this.main = main;
    }

    public static WeatherResponseViewModel getWeatherResponseViewModel(
            WeatherResponseDomainModel weatherResponseDomainModel){
        WeatherResponseViewModel weatherResponseViewModel = new WeatherResponseViewModel();
        weatherResponseViewModel.setMain(weatherResponseDomainModel.getMain());
        weatherResponseViewModel.setDescription(weatherResponseDomainModel.getDescription());
        return weatherResponseViewModel;

    }
}

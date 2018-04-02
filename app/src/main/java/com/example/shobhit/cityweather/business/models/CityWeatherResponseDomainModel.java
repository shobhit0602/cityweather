package com.example.shobhit.cityweather.business.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class CityWeatherResponseDomainModel implements Serializable {

    private String id;
    private String dt;
    private CloudsResponseDomainModel clouds;
    private CoordResponseDomainModel coord;
    private WindResponseDomainModel wind;
    private String cod;
    private String visibility;
    private SysResponseDomainModel sys;
    private String name;
    private String base;
    private ArrayList<WeatherResponseDomainModel> weather;
    private MainResponseDomainModel main;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public CloudsResponseDomainModel getClouds() {
        return clouds;
    }

    public void setClouds(CloudsResponseDomainModel clouds) {
        this.clouds = clouds;
    }

    public CoordResponseDomainModel getCoord() {
        return coord;
    }

    public void setCoord(CoordResponseDomainModel coord) {
        this.coord = coord;
    }

    public WindResponseDomainModel getWind() {
        return wind;
    }

    public void setWind(WindResponseDomainModel wind) {
        this.wind = wind;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public SysResponseDomainModel getSys() {
        return sys;
    }

    public void setSys(SysResponseDomainModel sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public ArrayList<WeatherResponseDomainModel> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<WeatherResponseDomainModel> weather) {
        this.weather = weather;
    }

    public MainResponseDomainModel getMain() {
        return main;
    }

    public void setMain(MainResponseDomainModel main) {
        this.main = main;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[id = " + id + ", dt = " + dt + ", clouds = " + clouds + ", coord = " + coord + ", wind = " + wind + ", cod = " + cod + ", visibility = " + visibility + ", sys = " + sys + ", name = " + name + ", base = " + base + ", weather = " + weather + ", main = " + main + "]";
    }
}

package com.example.shobhit.cityweather.business.models;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class CoordResponseDomainModel {
    private String lon;
    private String lat;

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

    @Override
    public String toString() {
        return "[lon = " + lon + ", lat = " + lat + "]";
    }
}

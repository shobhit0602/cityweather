package com.example.shobhit.cityweather.business.models;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class CloudsResponseDomainModel {
    private String all;

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "[all = " + all + "]";
    }
}

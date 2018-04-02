package com.example.shobhit.cityweather.business.models;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class WindResponseDomainModel {
    private String speed;
    private String deg;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "[speed = " + speed + ", deg = " + deg + "]";
    }
}

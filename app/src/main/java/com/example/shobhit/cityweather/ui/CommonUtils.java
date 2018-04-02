package com.example.shobhit.cityweather.ui;

/**
 * Created by Shobhit on 02-04-2018.
 */

public class CommonUtils {

    public static String convertFarenheitToCelcius(String temparature) {
        return  String.valueOf(((Float.parseFloat(temparature) - 32)*5)/9);
    }

}

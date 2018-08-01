package com.example.android.quakereport;

/**
 * Created by rik on 8/1/2018.
 */

/**
 *  {@link Earthquake} is a class which provide data about earthquake
 *  It contains properties magnitude, location, date
 */

public class Earthquake {

private String mMagnitude;
private String mLocation;
private String mDate;

/**
 * @param magnitude is a magnitude of earthquke
 * @param location shows where it happened
 * @param date shows when it happened
* */


public Earthquake(String magnitude, String location, String date){
    this.mMagnitude = magnitude;
    this.mLocation = location;
    this.mDate = date;
}

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }
}

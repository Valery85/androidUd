package com.example.android.quakereport;

/**
 * Created by rik on 8/1/2018.
 */

/**
 *  {@link Earthquake} is a class which provide data about earthquake
 *  It contains properties magnitude, location, date
 */

public class Earthquake {

private double mMagnitude;
private String mLocation;
private long mTimeInMilliseconds;
private String mUrl;


/**
 * @param magnitude is a magnitude of earthquke
 * @param location shows where it happened
 * @param timeInMilliseconds shows when it happened in ms (from 1970)
 * @param url contain url to website with details about the earthquake
* */


public Earthquake(double magnitude, String location, long timeInMilliseconds, String url){
    this.mMagnitude = magnitude;
    this.mLocation = location;
    this.mTimeInMilliseconds = timeInMilliseconds;
    this.mUrl = url;
}

    public Double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getUrl() {return mUrl;}
}

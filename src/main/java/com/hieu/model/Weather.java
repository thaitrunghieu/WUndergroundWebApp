package com.hieu.model;

/**
 * Created by Hieu on 4/4/2015.
 */
public class Weather {

    private String city;
    private String state;
    private double temperatureInFarenheit;

    public String getCity(){
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTemperatureInFarenheit() {
        return temperatureInFarenheit;
    }

    public void setTemperatureInFarenheit(double temperatureInFarenheit) {
        this.temperatureInFarenheit = temperatureInFarenheit;
    }
}

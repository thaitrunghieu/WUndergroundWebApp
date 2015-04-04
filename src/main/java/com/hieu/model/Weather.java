package com.hieu.model;

import javax.validation.constraints.Pattern;

/**
 * Created by Hieu on 4/4/2015.
 */
public class Weather {

    private String city;
    private String state;
    private double temperatureInFarenheit;

    @Pattern(regexp="\\d{5}", message = "invalid zip code format")
    private String zipCode;

    public String getCity(){ return city; }

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

    public String getZipCode() { return zipCode; }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
}

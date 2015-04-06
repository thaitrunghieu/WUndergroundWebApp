package com.hieu.model;

import javax.validation.constraints.Pattern;

public class Weather {

    private String city;
    private String state;
    private double temperatureInFarenheit;

    @Pattern(regexp="\\d{5}", message = "Invalid zip code format.")
    private String zipCode;

    private boolean isValidPlace;

    public Weather() {
        isValidPlace = false;
    }

    public Weather(String zipCode) {
        this.zipCode = zipCode.trim();
        isValidPlace = false;
    }

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

    public void setZipCode(String zipCode) { this.zipCode = zipCode.trim(); }

    public boolean getIsValidPlace() { return isValidPlace; }

    public void setIsValidPlace(boolean isValidPlace) { this.isValidPlace = isValidPlace; }

    public String toString() {
        return this.getCity() + ", " + this.getState() + ": " + this.getTemperatureInFarenheit() + "\u00b0F";
    }
}

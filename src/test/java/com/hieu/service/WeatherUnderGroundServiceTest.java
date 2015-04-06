package com.hieu.service;

import org.junit.Test;
import com.hieu.model.Weather;

import static org.junit.Assert.*;

public class WeatherUnderGroundServiceTest {

    @Test
    public void validPlaceTest() {

        final String zipCode = "77072";
        final String expectedCity = "Houston";
        final String expectedState = "TX";

        WeatherUndergroundService wus = new WeatherUnderGroundServiceImp();
        final Weather weather = wus.getWeather(new Weather(zipCode));

        assertTrue(weather.getIsValidPlace()
                && weather.getCity().equals(expectedCity)
                && weather.getState().equals(expectedState));
    }

    @Test
    public void invalidPlaceTest() {

        final String zipCode = "00000";

        WeatherUndergroundService wus = new WeatherUnderGroundServiceImp();
        final Weather weather = wus.getWeather(new Weather(zipCode));

        assertFalse(weather.getIsValidPlace());
    }

    @Test
    public void invalidZipCodeFormatTest() {

        final String zipCode = "";

        WeatherUndergroundService wus = new WeatherUnderGroundServiceImp();
        final Weather weather = wus.getWeather(new Weather(zipCode));

        assertFalse(weather.getIsValidPlace());
    }
}

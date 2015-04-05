package com.hieu.service;

import org.junit.Test;
import com.hieu.model.Weather;

import static org.junit.Assert.*;

public class WeatherUnderGroundServiceTest {

    @Test
    public void cityTest() throws Exception {

        final String expectedCity = "Houston";
        final String zipCode = "77072";

        WeatherUndergroundService wus = new WeatherUnderGroundServiceImp();
        final Weather weather = wus.getWeather(new Weather(zipCode));
        final String resultCity = weather.getCity();

        assertEquals(expectedCity, resultCity);
    }
}

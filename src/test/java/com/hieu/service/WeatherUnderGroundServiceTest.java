package com.hieu.service;

/**
 * Created by Hieu on 4/4/2015.
 */
import org.junit.Test;
import com.hieu.model.Weather;

import static org.junit.Assert.*;

public class WeatherUnderGroundServiceTest {

    @Test
    public void cityTest() throws Exception {

        final String expectedCity = "Houston";
        final String zipCode = "77072";

        WeatherUndergroundService wus = new WeatherUnderGroundServiceImp();
        final Weather weather = wus.getWeather(zipCode);
        final String resultCity = weather.getCity();

        assertEquals(expectedCity, resultCity);
    }
}

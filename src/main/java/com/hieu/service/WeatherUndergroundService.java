package com.hieu.service;

import com.hieu.model.Weather;

/**
 * Created by Hieu on 4/4/2015.
 */
public interface WeatherUndergroundService {

    public Weather getWeather(String zipCode);
}

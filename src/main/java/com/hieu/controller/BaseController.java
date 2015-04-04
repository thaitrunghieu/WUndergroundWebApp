package com.hieu.controller;

import com.hieu.service.WeatherUndergroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hieu.service.ZipCodeValidationService;
import com.hieu.model.Weather;

@Controller
public class BaseController {

    private static final String VIEW_INDEX = "index";

    @Autowired
    private WeatherUndergroundService weatherUndergroundService;

    @Autowired
    private ZipCodeValidationService zipCodeValidationService;

    @RequestMapping(value = "/")
    public String weather(ModelMap model) {

        model.addAttribute("weather", null);
        model.addAttribute("message", "Please enter your zip code");

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String weatherWithGivenZip(Weather weather, ModelMap model) {

        String message;

        String zipCode = weather.getZipCode();
        System.out.println(weather.getState() + ' ' + weather.getCity() + ' ' + weather.getZipCode());
        if (zipCodeValidationService.isValidZipCodeFormat(zipCode)) {
            weather = weatherUndergroundService.getWeather(zipCode);
            if (weather == null)
                message = "Error: zipcode not found.";
            else {
                message = "Weather data for zip code " + zipCode + ":";
            }
        }
        else
            message = "Error: invalid zip code format.";
        model.addAttribute("weather", weather);
        model.addAttribute("message", message);

        return VIEW_INDEX;
    }
}
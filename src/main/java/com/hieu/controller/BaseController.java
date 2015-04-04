package com.hieu.controller;

import com.hieu.service.WeatherUndergroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.hieu.service.ZipCodeValidationService;
import com.hieu.model.Weather;

@Controller
public class BaseController {

    private static final String VIEW_INDEX = "index";

    @Autowired
    private WeatherUndergroundService weatherUndergroundService;

    @Autowired
    private ZipCodeValidationService zipCodeValidationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String weather(ModelMap model) {

        Weather weather = null;
        model.addAttribute("message", "Please enter your zip code");
        model.addAttribute("weather", weather);

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/", params = {"zip"}, method = RequestMethod.GET)
    public String weatherWithGivenZip(@RequestParam("zip")String zipCode, ModelMap model) {

        String message;
        Weather weather = null;
        if (zipCodeValidationService.isValidZipCodeFormat(zipCode)) {
            weather = weatherUndergroundService.getWeather(zipCode);
            message = "Weather data in your zip code is " + zipCode;
        }
        else
            message = "Error: invalid zip code format.";
        model.addAttribute("message", message);
        model.addAttribute("weather", weather);

        return VIEW_INDEX;
    }
}
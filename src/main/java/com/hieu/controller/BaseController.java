package com.hieu.controller;

import com.hieu.service.WeatherUndergroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hieu.model.Weather;

import javax.validation.Valid;

@Controller
public class BaseController {

    private static final String VIEW_INDEX = "index";

    @Autowired
    private WeatherUndergroundService weatherUndergroundService;

    @RequestMapping(value = "/")
    public String initialPage(ModelMap model) {
        model.addAttribute("weather", new Weather());
        model.addAttribute("message", "Please enter your zip code");
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String weatherWithGivenZip(@Valid @ModelAttribute("weather") Weather weather, BindingResult result, ModelMap model) {

        String message = "";
        Weather newWeather = weather;
        if (!result.hasErrors()) {
            newWeather = weatherUndergroundService.getWeather(weather.getZipCode());
            if (newWeather == null) {
                newWeather = weather;
                message = "Zip Code not found";
            }
            else
                message = "Weather data for zip code " + newWeather.getZipCode();
        }

        model.addAttribute("weather", newWeather);
        model.addAttribute("message", message);
        return VIEW_INDEX;
    }
}
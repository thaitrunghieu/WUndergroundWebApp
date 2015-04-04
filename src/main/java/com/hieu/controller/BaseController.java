package com.hieu.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {

    private static final String VIEW_INDEX = "index";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String weather(ModelMap model) {

        model.addAttribute("message", "Please enter your zip code");

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/", params = {"zip"}, method = RequestMethod.GET)
    public String weatherWithGivenZip(@RequestParam("zip")String zipCode, ModelMap model) {

        model.addAttribute("message", "Weather data in your zip code is " + zipCode);
        return VIEW_INDEX;
    }
}
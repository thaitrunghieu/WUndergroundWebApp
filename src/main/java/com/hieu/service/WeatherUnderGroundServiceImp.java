package com.hieu.service;

import com.hieu.model.Weather;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import org.json.JSONObject;

@Component
public class WeatherUnderGroundServiceImp implements WeatherUndergroundService {

    private final String wuApiKey = "ed044d75b91fb500";
    private final String wuPathPrefix = "http://api.wunderground.com/api/" + wuApiKey + "/conditions/q/";
    private final String wuPathSuffix = ".json";

    public Weather getWeather(Weather weather) {

        try {
            URL url = new URL(wuPathPrefix + weather.getZipCode() + wuPathSuffix);
            InputStream inputStream = url.openStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String jsonText = readAll(bufferedReader);

            JSONObject jsonObject = new JSONObject(jsonText);
            JSONObject weatherData = jsonObject.getJSONObject("current_observation");

            weather.setCity(weatherData.getJSONObject("display_location").getString("city"));
            weather.setState(weatherData.getJSONObject("display_location").getString("state"));
            weather.setTemperatureInFarenheit(weatherData.getDouble("temp_f"));
            weather.setIsValidPlace(true);
        }

        catch (Exception e) {

        }

        return weather;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}

package com.weatherapp.weather_details.Controllers;


import com.weatherapp.weather_details.Models.CurrentWeatherForecast;
import com.weatherapp.weather_details.Services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentWeatherController {

    @Autowired
    WeatherServices weather;

    @GetMapping("/data/2.5/weather")
    public ResponseEntity<CurrentWeatherForecast> currentWeather(@RequestParam("lat") double lat,
                                                                 @RequestParam("lon") double lon) {
        CurrentWeatherForecast wth=weather.getCurrentWeather(lat,lon);
        return new ResponseEntity<>(wth, HttpStatusCode.valueOf(200));
    }
}

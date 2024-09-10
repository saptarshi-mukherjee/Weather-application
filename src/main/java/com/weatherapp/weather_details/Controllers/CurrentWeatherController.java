package com.weatherapp.weather_details.Controllers;


import com.weatherapp.weather_details.DTO.LocationDetails;
import com.weatherapp.weather_details.Exceptions.LocationNotFoundException;
import com.weatherapp.weather_details.Models.CurrentWeatherForecast;
import com.weatherapp.weather_details.Services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrentWeatherController {

    @Autowired
    WeatherServices weather;

    @GetMapping("/get/lat_lon")
    public ResponseEntity<CurrentWeatherForecast> currentWeather(@RequestParam("lat") double lat,
                                                                 @RequestParam("lon") double lon) throws LocationNotFoundException {
        CurrentWeatherForecast wth=weather.getCurrentWeather(lat,lon);
        return new ResponseEntity<>(wth, HttpStatusCode.valueOf(200));
    }


    @GetMapping("/get/weather/city")
    public ResponseEntity<CurrentWeatherForecast> currentWeatherOfCity(@RequestParam("city") String city) throws LocationNotFoundException{
        List<LocationDetails> location_city=weather.unwrapLatAndLon(city);
        double lat=location_city.get(0).getLat();
        double lon=location_city.get(0).getLon();
        CurrentWeatherForecast wth=weather.getCurrentWeather(lat,lon);
        return new ResponseEntity<>(wth, HttpStatusCode.valueOf(200));
    }
}

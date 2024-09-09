package com.weatherapp.weather_details.Services;

import com.weatherapp.weather_details.Models.CurrentWeatherForecast;

public interface WeatherServices {
    public CurrentWeatherForecast getCurrentWeather(double lat, double lon);
}

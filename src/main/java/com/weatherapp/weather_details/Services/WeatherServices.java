package com.weatherapp.weather_details.Services;

import com.weatherapp.weather_details.DTO.LocationDetails;
import com.weatherapp.weather_details.Exceptions.LocationNotFoundException;
import com.weatherapp.weather_details.Models.CurrentWeatherForecast;
import com.weatherapp.weather_details.Models.FourDayWeatherForecast;

import java.util.List;

public interface WeatherServices {
    public CurrentWeatherForecast getCurrentWeather(double lat, double lon) throws LocationNotFoundException;
    public List<LocationDetails> unwrapLatAndLon(String city) throws LocationNotFoundException;
    public List<FourDayWeatherForecast> getForecast(double lat, double lon) throws LocationNotFoundException;
}

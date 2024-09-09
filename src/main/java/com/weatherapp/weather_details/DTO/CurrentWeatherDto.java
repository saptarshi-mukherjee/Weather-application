package com.weatherapp.weather_details.DTO;

import com.weatherapp.weather_details.Models.MainWeather;
import com.weatherapp.weather_details.Models.WeatherDescription;
import com.weatherapp.weather_details.Models.Wind;

import java.util.List;

public class CurrentWeatherDto {
    List<WeatherDescription> weather;
    MainWeather main;
    double visibility;
    Wind wind;

    public List<WeatherDescription> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDescription> weather) {
        this.weather = weather;
    }

    public MainWeather getMain() {
        return main;
    }

    public void setMain(MainWeather main) {
        this.main = main;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}

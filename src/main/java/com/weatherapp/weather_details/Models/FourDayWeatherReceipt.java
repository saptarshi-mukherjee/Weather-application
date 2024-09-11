package com.weatherapp.weather_details.Models;

import java.util.List;

public class FourDayWeatherReceipt {
    MainWeather main;
    List<WeatherDescription> weather;
    Wind wind;
    double visibility;
    String dt_txt;

    public MainWeather getMain() {
        return main;
    }

    public void setMain(MainWeather main) {
        this.main = main;
    }

    public List<WeatherDescription> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDescription> weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}

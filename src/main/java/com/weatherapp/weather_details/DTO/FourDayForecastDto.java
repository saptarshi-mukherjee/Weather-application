package com.weatherapp.weather_details.DTO;

import com.weatherapp.weather_details.Models.FourDayWeatherReceipt;

import java.util.List;

public class FourDayForecastDto {
    List<FourDayWeatherReceipt> list;

    public List<FourDayWeatherReceipt> getList() {
        return list;
    }

    public void setList(List<FourDayWeatherReceipt> list) {
        this.list = list;
    }
}

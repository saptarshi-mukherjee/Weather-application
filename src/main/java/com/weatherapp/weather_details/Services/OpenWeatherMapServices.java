package com.weatherapp.weather_details.Services;

import com.weatherapp.weather_details.DTO.CurrentWeatherDto;
import com.weatherapp.weather_details.Models.CurrentWeatherForecast;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapServices implements WeatherServices{

    @Override
    public CurrentWeatherForecast getCurrentWeather(double lat, double lon) {
        String api_key="809de0328c67c87e7d0727cec3849488";
        String url="https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid="+api_key;
        RestTemplate rest=new RestTemplate();
        CurrentWeatherDto weather=rest.getForObject(url, CurrentWeatherDto.class);
        return getCustomWeather(weather);
    }

    private CurrentWeatherForecast getCustomWeather(CurrentWeatherDto w) {
        CurrentWeatherForecast current_weather=new CurrentWeatherForecast();
        current_weather.setDescription(w.getWeather().get(0).getDescription());
        current_weather.setAvg_temperature(w.getMain().getTemp());
        current_weather.setHumidity(w.getMain().getHumidity());
        current_weather.setMax_temperature(w.getMain().getTemp_max());
        current_weather.setMin_temperature(w.getMain().getTemp_min());
        current_weather.setReal_feel(w.getMain().getFeels_like());
        current_weather.setPressure(w.getMain().getPressure());
        current_weather.setWind_speed(w.getWind().getSpeed());
        current_weather.setWind_gust(w.getWind().getGust());
        current_weather.setWind_degree(w.getWind().getDeg());
        current_weather.setVisibility(w.getVisibility());
        return current_weather;
    }
}

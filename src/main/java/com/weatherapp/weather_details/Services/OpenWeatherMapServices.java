package com.weatherapp.weather_details.Services;

import com.weatherapp.weather_details.DTO.CurrentWeatherDto;
import com.weatherapp.weather_details.DTO.LocationDetails;
import com.weatherapp.weather_details.Exceptions.LocationNotFoundException;
import com.weatherapp.weather_details.Models.CurrentWeatherForecast;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OpenWeatherMapServices implements WeatherServices{
    String api_key="809de0328c67c87e7d0727cec3849488";

    @Override
    public CurrentWeatherForecast getCurrentWeather(double lat, double lon) throws LocationNotFoundException {
        if((lat>=-90 && lat<=90) || (lon>=-180 && lon<=180)) {
            String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + api_key;
            RestTemplate rest = new RestTemplate();
            CurrentWeatherDto weather = rest.getForObject(url, CurrentWeatherDto.class);
            return getCustomWeather(weather);
        }
        throw new LocationNotFoundException("Location does not exist");
    }

    @Override
    public List<LocationDetails> unwrapLatAndLon(String city) throws LocationNotFoundException{
        String url="http://api.openweathermap.org/geo/1.0/direct?q="+city+"&limit="+1+"&appid="+api_key;
        RestTemplate rest=new RestTemplate();
        LocationDetails[] location=rest.getForObject(url, LocationDetails[].class);
        List<LocationDetails> loc=List.of(location);
        if(loc.isEmpty())
            throw new LocationNotFoundException("Location does not exist");
        return loc;
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

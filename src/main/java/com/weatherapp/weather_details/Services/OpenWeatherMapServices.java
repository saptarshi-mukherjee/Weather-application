package com.weatherapp.weather_details.Services;

import com.weatherapp.weather_details.DTO.CurrentWeatherDto;
import com.weatherapp.weather_details.DTO.FourDayForecastDto;
import com.weatherapp.weather_details.DTO.LocationDetails;
import com.weatherapp.weather_details.Exceptions.LocationNotFoundException;
import com.weatherapp.weather_details.Models.CurrentWeatherForecast;
import com.weatherapp.weather_details.Models.FourDayWeatherForecast;
import com.weatherapp.weather_details.Models.FourDayWeatherReceipt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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

    @Override
    public List<FourDayWeatherForecast> getForecast(double lat, double lon) throws LocationNotFoundException{
        //String ak="809de0328c67c87e7d0727cec3849488";
        if((lat>=-90 && lat<=90) || (lon>=-180 && lon<=180)) {
            String url = "http://api.openweathermap.org/data/2.5/forecast?lat="+lat+"&lon="+lon+"&appid="+api_key;
            RestTemplate rest = new RestTemplate();
            FourDayForecastDto forecast_dto = rest.getForObject(url, FourDayForecastDto.class);
            List<FourDayWeatherForecast> forecast_list = getCustomForecast(forecast_dto);
            return forecast_list;
        }
        throw new LocationNotFoundException("Location does not exist");
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

    private List<FourDayWeatherForecast> getCustomForecast(FourDayForecastDto forecast_dto) {
        List<FourDayWeatherForecast> forecast_list=new ArrayList<>();
        FourDayWeatherForecast forecast=null;
        List<FourDayWeatherReceipt> dto_list=forecast_dto.getList();
        for(FourDayWeatherReceipt f : dto_list) {
            forecast=new FourDayWeatherForecast();
            forecast.setDate(f.getDt_txt());
            forecast.setDescription(f.getWeather().get(0).getDescription());
            forecast.setHumidity(f.getMain().getHumidity());
            forecast.setPressure(f.getMain().getPressure());
            forecast.setAvg_temperature(f.getMain().getTemp());
            forecast.setMax_temperature(f.getMain().getTemp_max());
            forecast.setMin_temperature(f.getMain().getTemp_min());
            forecast.setReal_feel(f.getMain().getFeels_like());
            forecast.setVisibility(f.getVisibility());
            forecast.setWind_degree(f.getWind().getDeg());
            forecast.setWind_speed(f.getWind().getSpeed());
            forecast.setWind_gust(f.getWind().getGust());
            forecast_list.add(forecast);
        }
        return forecast_list;
    }
}

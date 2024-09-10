package com.weatherapp.weather_details.Models;

public class CurrentWeatherForecast {
    String description;
    double avg_temperature, real_feel, max_temperature;
    double min_temperature, pressure, humidity;
    double visibility, wind_speed, wind_degree, wind_gust;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAvg_temperature() {
        return avg_temperature;
    }

    public void setAvg_temperature(double avg_temperature) {
        this.avg_temperature = avg_temperature-273.0;
        this.avg_temperature=Math.round(this.avg_temperature);
    }

    public double getReal_feel() {
        return real_feel;
    }

    public void setReal_feel(double real_feel) {
        this.real_feel = real_feel-273.0;
        this.real_feel=Math.round(this.real_feel);
    }

    public double getMax_temperature() {
        return max_temperature;
    }

    public void setMax_temperature(double max_temperature) {
        this.max_temperature = max_temperature-273.0;
        this.max_temperature=Math.round(this.max_temperature);
    }

    public double getMin_temperature() {
        return min_temperature;
    }

    public void setMin_temperature(double min_temperature) {
        this.min_temperature = min_temperature-273.0;
        this.min_temperature=Math.round(this.min_temperature);
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public double getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(double wind_degree) {
        this.wind_degree = wind_degree;
    }

    public double getWind_gust() {
        return wind_gust;
    }

    public void setWind_gust(double wind_gust) {
        this.wind_gust = wind_gust;
    }
}

package com.thatcoolcoder.weather.weatherApp.weatherDisplayPanel;

import com.thatcoolcoder.weather.weatherApi.models.*;

public interface WeatherDisplayer {
    public abstract void displayWeather(WeatherSnapshot snapshot);
}

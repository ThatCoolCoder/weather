package com.thatcoolcoder.weather.weatherApp;

import javax.swing.*;
import java.awt.BorderLayout;
import java.io.IOException;

import com.thatcoolcoder.weather.common.*;
import com.thatcoolcoder.weather.weatherApi.*;
import com.thatcoolcoder.weather.weatherApi.models.WeatherSnapshot;

public class WeatherApp extends JFrame {
    private WeatherService weatherService;
    private WeatherDisplayPanel weatherDisplayPanel = new WeatherDisplayPanel();

    public WeatherApp(WeatherService weatherService)
    {
        super("Weather App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        
        this.weatherService = weatherService;
        TopBar topBar = new TopBar((String location) -> showWeather(location));
        add(topBar, BorderLayout.NORTH);
        add(weatherDisplayPanel, BorderLayout.CENTER);
    }

    public void showWeather(String location)
    {
        try
        {
            WeatherSnapshot weatherSnapshot = weatherService.getCurrentWeather(location);
            weatherDisplayPanel.showWeather(weatherSnapshot);
        }
        catch (IOException | InterruptedException e)
        {
            UIUtils.showException(this, e, "fetching weather data");
        }
        catch (Exception e)
        {
            UIUtils.showException(this, e, "displaying weather data");
        }
    }
}

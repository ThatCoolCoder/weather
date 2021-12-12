package com.thatcoolcoder.weather.weatherApp;

import javax.swing.*;
import java.awt.BorderLayout;

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
            System.out.println(weatherSnapshot.metadata.name);
            weatherDisplayPanel.showWeather(weatherSnapshot);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this,
                "Unexpected error fetching weather data",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}

package com.thatcoolcoder.weather.weatherApp;

import javax.swing.*;
import java.awt.event.*;
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

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                try
                {
                    Config.save();
                }
                catch (Exception e)
                {
                    // do nothing - saving config is not a major error
                }
            }

            public void windowOpened(WindowEvent we)
            {
                onWindowOpened();
            }
        });
    }

    private void onWindowOpened()
    {
        if (Config.current.weatherApiKey.isEmpty())
        {
            getWeatherApiKey();
        }
        
        showWeather(Config.current.locationLastVisited);
    }

    private void getWeatherApiKey()
    {
        Config.current.weatherApiKey = JOptionPane.showInputDialog(this, "Enter a valid API key for weatherapi.com");
        weatherService.apiKey = Config.current.weatherApiKey;
    }

    private void showWeather(String location)
    {
        Config.current.locationLastVisited = location;
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

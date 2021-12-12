package com.thatcoolcoder.weather.weatherApp;

import java.nio.file.Files;
import java.nio.file.Path;

import com.thatcoolcoder.weather.weatherApi.*;

public class Main 
{
    public static void main(String[] args)
    {
        try
        {
            Config.load();
            WeatherService weatherService = new WeatherService(Config.current.weatherApiKey);
            WeatherApp app = new WeatherApp(weatherService);
            app.setVisible(true);
        }
        catch (Config.ConfigSaveException e)
        {
            System.err.println("Config error: " + e.getMessage());
        }
    }
}

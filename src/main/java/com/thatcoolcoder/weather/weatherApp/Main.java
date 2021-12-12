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
            String apiKey = Files.readString(Path.of("weatherApiKey.txt"));
            WeatherService weatherService = new WeatherService(apiKey);
            WeatherApp app = new WeatherApp(weatherService);
            app.setVisible(true);
        }
        catch (Exception e)
        {
            System.out.println("Error starting application");
        }
    }
}

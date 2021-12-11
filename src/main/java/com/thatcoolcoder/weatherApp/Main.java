package com.thatcoolcoder.weatherApp;

import java.nio.file.Files;
import java.nio.file.Path;

import com.thatcoolcoder.weatherApi.*;
import com.thatcoolcoder.weatherApi.models.WeatherSnapshot;

public class Main 
{
    public static void main(String[] args)
    {
        WeatherApp app = new WeatherApp();
        app.setVisible(true);
        // try
        // {
        //     String apiKey = Files.readString(Path.of("weatherApiKey.txt"));
        //     WeatherService weatherService = new WeatherService(apiKey);
        //     WeatherSnapshot currentWeather = weatherService.getCurrentWeather("New York");
        //     System.out.println(currentWeather.toString());
        // }
        // catch (Exception e)
        // {
        //     System.out.println("Error");
        // }
    }
}

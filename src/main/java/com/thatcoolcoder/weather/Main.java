package com.thatcoolcoder.weather;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        try
        {
            String apiKey = Files.readString(Path.of("weatherApiKey.txt"));
            WeatherService s = new WeatherService(apiKey);
            s.getCurrentWeather("Chicago");
            
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace().toString());
            System.out.println("Error");
        }
    }
}

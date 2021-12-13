package com.thatcoolcoder.weather.weatherApi.exceptions;

public class NoLocationProvided extends Exception {
    public NoLocationProvided()
    {
        super("No location was provided to the weather api");
    }
}

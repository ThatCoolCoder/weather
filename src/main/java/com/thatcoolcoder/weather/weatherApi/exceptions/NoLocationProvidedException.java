package com.thatcoolcoder.weather.weatherApi.exceptions;

public class NoLocationProvidedException extends Exception {
    public NoLocationProvidedException()
    {
        super("No location was provided to the weather api");
    }
}

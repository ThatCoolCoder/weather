package com.thatcoolcoder.weather.weatherApi.exceptions;

public class InvalidLocation extends Exception {
    public InvalidLocation(String locationName)
    {
        super(String.format("No location matching the name \"%s\" was found", locationName));
    }
}

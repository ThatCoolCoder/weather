package com.thatcoolcoder.weather.weatherApi.exceptions;

public class InvalidLocationException extends Exception {
    public InvalidLocationException(String locationName)
    {
        super(String.format("No location matching the name \"%s\" was found", locationName));
    }
}

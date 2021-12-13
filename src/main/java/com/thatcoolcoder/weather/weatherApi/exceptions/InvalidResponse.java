package com.thatcoolcoder.weather.weatherApi.exceptions;

public class InvalidResponse extends Exception {
    public InvalidResponse(Exception e)
    {
        super(e);
    }
}

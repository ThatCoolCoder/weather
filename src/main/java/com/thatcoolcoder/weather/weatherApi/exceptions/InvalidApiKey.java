package com.thatcoolcoder.weather.weatherApi.exceptions;

public class InvalidApiKey extends Exception {
    public InvalidApiKey()
    {
        super("API key is invalid");
    }
}

package com.thatcoolcoder.weather.weatherApi.exceptions;

public class InvalidApiKeyException extends Exception {
    public InvalidApiKeyException()
    {
        super("API key is invalid");
    }
}

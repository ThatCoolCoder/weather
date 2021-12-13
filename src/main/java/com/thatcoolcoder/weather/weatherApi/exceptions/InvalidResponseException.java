package com.thatcoolcoder.weather.weatherApi.exceptions;

public class InvalidResponseException extends Exception {
    public InvalidResponseException(Exception e)
    {
        super(e);
    }
}

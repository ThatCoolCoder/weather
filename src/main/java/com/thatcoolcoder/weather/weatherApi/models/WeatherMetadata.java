package com.thatcoolcoder.weather.weatherApi.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;

public class WeatherMetadata {
    // Metadata about a WeatherSnapshot - location, time

    public LocalDateTime localTime;
    public String timeZoneIdentifier;
    public long localTimeEpoch;
    public String name;
    public String region;
    public String country;
    public float latitude;
    public float longitude;

    private static DateTimeFormatter localTimeFormatter = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static WeatherMetadata fromJson(JSONObject json)
    {
        WeatherMetadata l = new WeatherMetadata();
        l.localTime = LocalDateTime.parse(json.getString("localtime"), localTimeFormatter);
        l.timeZoneIdentifier = json.getString("tz_id");
        l.localTimeEpoch = json.getLong("localtime_epoch");
        l.name = json.getString("name");
        l.region = json.getString("region");
        l.country = json.getString("country");
        l.latitude = json.getFloat("lat");
        l.longitude = json.getFloat("lon");
        return l;
    }
}

package com.thatcoolcoder.weather.weatherApi.models;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;

public class WeatherMetadata {
    // Metadata about a WeatherSnapshot - location, time

    public LocalDateTime localDateTime;
    public ZonedDateTime dateTime;
    public ZoneId timeZone;
    public long localTimeEpoch;
    public String location;
    public String region;
    public String country;
    public float latitude;
    public float longitude;

    private static DateTimeFormatter localTimeFormatter = 
        DateTimeFormatter.ofPattern("yyyy-M-d H:mm");

    public static WeatherMetadata fromJson(JSONObject json)
    {
        WeatherMetadata l = new WeatherMetadata();
        l.localDateTime = LocalDateTime.parse(json.getString("localtime"), localTimeFormatter);
        l.timeZone = ZoneId.of(json.getString("tz_id"));
        l.dateTime = l.localDateTime.atZone(l.timeZone);
        l.localTimeEpoch = json.getLong("localtime_epoch");
        l.location = json.getString("name");
        l.region = json.getString("region");
        l.country = json.getString("country");
        l.latitude = json.getFloat("lat");
        l.longitude = json.getFloat("lon");
        return l;
    }
}

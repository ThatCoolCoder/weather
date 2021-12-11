package com.thatcoolcoder.weather.weatherApi.models;

import java.util.HashMap;

import org.json.JSONObject;

public class WeatherSnapshot {
    // Snapshot of weather at a particular time and location
    // For info on units used, see README

    public float temperature;
    public float temperatureFeelsLike;
    public float windSpeed;
    public float windGustSpeed;
    public float windDirection;
    public float ultravioletLevel;
    public int visibility;
    public float cloudCover; // 0 to 1
    public int precipitationAmount;
    public int humidity;
    public int airPressure;

    public WeatherMetadata metadata;

    private static HashMap<String, Float> windDirectionTable = new HashMap<String, Float>()
    {{
        put("N", 0f);
        put("NNE", 22.5f);
        put("NE", 45f);
        put("ENE", 67.5f);
        put("E", 90f);
        put("ESE", 112.5f);
        put("SE", 135f);
        put("SSE", 157.5f);
        put("S", 180f);
        put("SSW", 202.5f);
        put("SW", 225f);
        put("WSW", 247.5f);
        put("W", 270f);
        put("NWN", 292.5f);
        put("NW", 315f);
        put("NNW", 337.f);
    }};

    public static WeatherSnapshot fromJson(JSONObject json)
    {
        // Note that this does not populate the metadata field
        // as due to the data from the API, this is not accessible from this json

        WeatherSnapshot w = new WeatherSnapshot();
        w.temperature = json.getFloat("temp_c");
        w.temperatureFeelsLike = json.getFloat("feelslike_c");
        w.windSpeed = json.getFloat("wind_kph");
        w.windGustSpeed = json.getFloat("gust_kph");
        w.windDirection = windDirectionTable.get(json.getString("wind_dir"));
        w.ultravioletLevel = json.getFloat("uv");
        w.visibility = json.getInt("vis_km");
        w.cloudCover = json.getFloat("cloud") / 100;
        w.precipitationAmount = json.getInt("precip_mm");
        w.humidity = json.getInt("humidity");
        w.airPressure = json.getInt("pressure_mb");
        return w;
    }
}

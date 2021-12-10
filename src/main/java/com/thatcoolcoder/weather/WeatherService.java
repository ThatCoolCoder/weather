package com.thatcoolcoder.weather;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.*;

// import org.json.simple.parser.*;
import org.json.*;

public class WeatherService 
{
    private String apiKey;
    private String apiPrefix = "http://api.weatherapi.com/v1/";
    private HttpClient httpClient;

    public WeatherService(String _apiKey)
    {
        apiKey = _apiKey;
        httpClient = HttpClient.newHttpClient();
    }

    JSONObject getCurrentWeather(String locationName) throws IOException, InterruptedException
    {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(apiPrefix + "current.json?key=" + apiKey + "&q=" + locationName))
            .build();
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        System.out.println(response.body());
        JSONTokener tokener = new JSONTokener(
            new ByteArrayInputStream(response.body().getBytes()));
        return new JSONObject(tokener);
    }
}

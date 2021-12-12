package com.thatcoolcoder.weather.weatherApi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.*;

import com.thatcoolcoder.weather.common.*;
import com.thatcoolcoder.weather.weatherApi.models.*;

import org.json.*;

public class WeatherService 
{
    public String apiKey;
    private String apiPrefix = "http://api.weatherapi.com/v1/";
    private HttpClient httpClient;

    public WeatherService(String apiKey)
    {
        this.apiKey = apiKey;
        httpClient = HttpClient.newHttpClient();
    }

    public WeatherSnapshot getCurrentWeather(String locationName) throws IOException, InterruptedException
    {
        String url = apiPrefix + "current.json?key=" + apiKey +
            "&q=" + Utils.urlEncode(locationName);
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        JSONTokener tokener = new JSONTokener(
            new ByteArrayInputStream(response.body().getBytes()));

        JSONObject json = new JSONObject(tokener);
        WeatherSnapshot w = WeatherSnapshot.fromJson(json.getJSONObject("current"));
        w.metadata = WeatherMetadata.fromJson(json.getJSONObject("location"));
        return w;
    }

    
}

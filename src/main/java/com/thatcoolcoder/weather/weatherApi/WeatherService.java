package com.thatcoolcoder.weather.weatherApi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.*;

import com.thatcoolcoder.weather.common.*;
import com.thatcoolcoder.weather.weatherApi.models.*;
import com.thatcoolcoder.weather.weatherApi.exceptions.*;

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

    public WeatherSnapshot getCurrentWeather(String locationName) throws IOException, InterruptedException,
        InvalidLocationException, InvalidResponseException, InvalidApiKeyException, NoLocationProvidedException
    {
        String url = apiPrefix + "current.json?key=" + Utils.urlEncode(apiKey) +
            "&q=" + Utils.urlEncode(locationName);
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        JSONTokener tokener = new JSONTokener(
            new ByteArrayInputStream(response.body().getBytes()));

        try
        {
            JSONObject json = new JSONObject(tokener);
            if (json.has("error"))
            {
                int errorCode = json.getJSONObject("error").getInt("code");
                switch (errorCode)
                {
                    case 1006:
                        throw new InvalidLocationException(locationName);
                    case 1002:
                    case 2006:
                        throw new InvalidApiKeyException();
                    case 1003:
                        throw new NoLocationProvidedException();
                }
            }

            WeatherSnapshot w = WeatherSnapshot.fromJson(json.getJSONObject("current"));
            w.metadata = WeatherMetadata.fromJson(json.getJSONObject("location"));
            return w;
        }
        catch (JSONException e)
        {
            throw new InvalidResponseException(e);
        }
    }

    
}

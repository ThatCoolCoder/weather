package com.thatcoolcoder.weather.weatherApp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;

import org.json.*;

public class Config {
    public static Config current = null;

    public String weatherApiKey = "";
    public String locationLastVisited = "New York";
    public boolean autoOpenLastLocation = true;

    // Relative to home directory
    private static String configFileName = ".tccweather.json";
    private static String homeDirectoryPath = System.getProperty("user.home");
    private static Path configFilePath = Path.of(homeDirectoryPath, configFileName);

    public static class ConfigSaveException extends Exception
    {
        public ConfigSaveException (Throwable cause) {
            super(cause);
        }
    }

    public Config()
    {
        ; // do nothing
    }

    public static void load() throws ConfigSaveException
    {
        // Set the current config from a file
        // If no config is found, try and create a default one

        try
        {
            String jsonString = Files.readString(configFilePath);
            JSONTokener tokener = new JSONTokener(
                new ByteArrayInputStream(jsonString.getBytes()));
            JSONObject json = new JSONObject(tokener);
                
            current = new Config();
            current.weatherApiKey = json.getString("weatherApiKey");
            current.locationLastVisited = json.getString("locationLastVisited");
            current.autoOpenLastLocation = json.getBoolean("autoOpenLastLocation");
        }
        catch (IOException | JSONException e)
        {
            // Try creating new config if the existing one doesn't exist
            // (but maybe this will fail too due to permissions, etc so let that bubble up)
            current = new Config();
            save();
        }
    }

    public static void save() throws ConfigSaveException
    {
        // Save the current config

        JSONObject json = new JSONObject();
        json.put("weatherApiKey", current.weatherApiKey);
        json.put("locationLastVisited", current.locationLastVisited);
        json.put("autoOpenLastLocation", current.autoOpenLastLocation);

        try
        {
            Files.writeString(configFilePath, json.toString());
        }
        catch (IOException e)
        {
            throw new ConfigSaveException(e);
        }
    }

    public static void delete() throws ConfigSaveException
    {
        // Delete the current config (not sure why you want to do this, implemented for testing)
        try
        {
            Files.delete(configFilePath);
        }
        catch (IOException e)
        {
            throw new ConfigSaveException(e);
        }
    }
}

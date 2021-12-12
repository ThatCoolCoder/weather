package com.thatcoolcoder.weather.weatherApp;

import java.util.ArrayList;
import java.util.function.*;
import javax.swing.*;
import java.awt.*;

import com.thatcoolcoder.weather.weatherApi.models.WeatherSnapshot;

public class WeatherDisplayPanel extends JPanel {
    ArrayList<WeatherDisplayRow> rows = new ArrayList<WeatherDisplayRow>() {{
        add(new WeatherDisplayRow((ws) -> {
            return String.format("Weather for %s", ws.metadata.name);
        }));
        // add(new WeatherDisplayRow((ws) -> {
        //     return String.format("Local time is %tc", ws.metadata.dateTime);
        // }));
        // add(new WeatherDisplayRow((ws) -> {
        //     return "";
        // }));
        add(new WeatherDisplayRow((ws) -> {
            return String.format("Latitude: %.3f   Longitude: %.3f", ws.metadata.latitude, ws.metadata.longitude);
        }));
        add(new WeatherDisplayRow((ws) -> {
            return String.format("Temperature is %.1f °C", ws.temperature);
        }));
        add(new WeatherDisplayRow((ws) -> {
            return String.format("Temperature feels like %.1f °C", ws.temperatureFeelsLike);
        }));
        add(new WeatherDisplayRow((ws) -> {
            return String.format("Wind speed is %d km/h", (int) ws.windSpeed);
        }));
        add(new WeatherDisplayRow((ws) -> {
            return String.format("Wind gusting to %d km/h", (int) ws.windGustSpeed);
        }));
        add(new WeatherDisplayRow((ws) -> {
            return String.format("Wind direction %d°", (int) ws.windDirection);
        }));
        add(new WeatherDisplayRow((ws) -> {
            return String.format("Ultraviolet level: %.1f ", ws.ultravioletLevel);
        }));
        add(new WeatherDisplayRow((ws) -> {
            return String.format("Cloud cover: %d%%", (int) (ws.cloudCover * 100));
        }));
        add(new WeatherDisplayRow((ws) -> {
            return String.format("Precipitation: %d mm", ws.precipitationAmount);
        }));
        add(new WeatherDisplayRow((ws) -> {
            return String.format("Humidity: %d%%", ws.humidity);
        }));
        add(new WeatherDisplayRow((ws) -> {
            return String.format("Air pressure: %d mb", ws.airPressure);
        }));
    }};

    public WeatherDisplayPanel()
    {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (WeatherDisplayRow row : rows)
        {
            add(Box.createRigidArea(new Dimension(0, 20)));
            add(row);
        }
    }

    public void showWeather(WeatherSnapshot weatherSnapshot)
    {
        for (WeatherDisplayRow row : rows)
        {
            row.update(weatherSnapshot);
        }
    }

    private class WeatherDisplayRow extends JLabel
    {
        private Function<WeatherSnapshot, String> formatter;

        public WeatherDisplayRow(Function<WeatherSnapshot, String> formatter)
        {
            this.formatter = formatter;
            setAlignmentX(CENTER_ALIGNMENT);
        }

        public void update(WeatherSnapshot weatherSnapshot)
        {
            setText(formatter.apply(weatherSnapshot));
        }
    }
}

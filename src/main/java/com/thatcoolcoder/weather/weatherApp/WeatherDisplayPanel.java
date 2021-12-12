package com.thatcoolcoder.weather.weatherApp;

import java.util.ArrayList;
import java.util.function.*;
import javax.swing.*;
import java.awt.*;

import com.thatcoolcoder.weather.weatherApi.models.WeatherSnapshot;

public class WeatherDisplayPanel extends JPanel {
    ArrayList<WeatherDisplayRow> rows = new ArrayList<WeatherDisplayRow>() {{
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
    }};

    public WeatherDisplayPanel()
    {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (WeatherDisplayRow row : rows)
        {
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

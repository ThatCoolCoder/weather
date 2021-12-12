package com.thatcoolcoder.weather.weatherApp;

import javax.swing.*;
import java.awt.event.*;

import com.thatcoolcoder.weather.weatherApi.models.WeatherSnapshot;

public class WeatherDisplayPanel extends JPanel {
    JLabel temperature = new JLabel();
    JLabel temperatureFeelsLike = new JLabel();
    JLabel windSpeed = new JLabel();
    JLabel windGustSpeed = new JLabel();

    public WeatherDisplayPanel()
    {
        super();
        add(temperature);
        add(temperatureFeelsLike);
        add(windSpeed);
        add(windGustSpeed);
    }

    public void showWeather(WeatherSnapshot weatherSnapshot)
    {
        temperature.setText(String.format(
            "Temperature is %.1f °C", weatherSnapshot.temperature));
        temperatureFeelsLike.setText(String.format(
            "Temperature feels like %.1f °C", weatherSnapshot.temperatureFeelsLike));
        windSpeed.setText(String.format(
            "Wind speed is %d km/h", (int) weatherSnapshot.windSpeed));
        windGustSpeed.setText(String.format(
            "Wind gusting to %d km/h", (int) weatherSnapshot.windGustSpeed));
    }
}

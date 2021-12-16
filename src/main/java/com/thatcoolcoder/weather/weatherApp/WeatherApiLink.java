package com.thatcoolcoder.weather.weatherApp;

import javax.swing.*;

import com.thatcoolcoder.weather.common.Hyperlink;

public class WeatherApiLink extends JPanel {
    public WeatherApiLink()
    {
        add(new JLabel("Powered by "));
        add(new Hyperlink("weatherapi.com", "https://weatherapi.com"));
    }
}

package com.thatcoolcoder.weather.weatherApp.weatherDisplayPanel;

import javax.swing.*;
import java.awt.*;

import com.thatcoolcoder.weather.weatherApi.models.*;

public class HeadingBar extends JPanel implements PanelSection {
    private JLabel heading;

    public HeadingBar()
    {
        super();
        
        heading = new JLabel("Heading");
        heading.setFont(new Font("Helvetica", Font.PLAIN, 20));
        add(heading);
    }

    public void displayWeather(WeatherSnapshot snapshot)
    {
        heading.setText(String.format("Weather for %s, %s, %s",
            snapshot.metadata.location,
            snapshot.metadata.region,
            snapshot.metadata.country));
    }
}

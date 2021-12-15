package com.thatcoolcoder.weather.weatherApp.weatherDisplayPanel;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.synth.SynthPainter;

import java.awt.*;

import com.thatcoolcoder.weather.weatherApi.models.*;
import com.thatcoolcoder.weather.weatherApp.Fonts;

public class HeadingBar extends JPanel implements WeatherDisplayer {
    private JLabel heading;
    private JLabel coordinates;
    private JLabel lastUpdated;

    public HeadingBar()
    {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        heading = new JLabel();
        heading.setFont(Fonts.heading2);
        add(heading);

        add(Box.createRigidArea(new DimensionUIResource(0, 5)));

        coordinates = new JLabel();
        coordinates.setFont(Fonts.text);
        add(coordinates);
        
        add(Box.createRigidArea(new DimensionUIResource(0, 5)));

        lastUpdated = new JLabel();
        lastUpdated.setFont(Fonts.text);
        add(lastUpdated);
    }

    public void displayWeather(WeatherSnapshot snapshot)
    {
        heading.setText(String.format("Weather for %s, %s, %s",
            snapshot.metadata.location,
            snapshot.metadata.region,
            snapshot.metadata.country));
        coordinates.setText(String.format(
            "Latitude: %.3f    Longitude: %.3f",
            snapshot.metadata.latitude,
            snapshot.metadata.longitude));
        lastUpdated.setText(String.format(
            "Last updated: %tc",
            snapshot.metadata.dateTime));
    }
}

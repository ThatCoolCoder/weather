package com.thatcoolcoder.weather.weatherApp.weatherDisplayPanel;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.synth.SynthPainter;

import java.awt.*;

import com.thatcoolcoder.weather.weatherApi.models.*;
import com.thatcoolcoder.weather.weatherApp.Fonts;

public class MetadataBar extends JPanel implements WeatherDisplayer {
    private JLabel coordinates;
    private JLabel lastUpdated;

    public MetadataBar()
    {
        super();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new DimensionUIResource(0, 5)));

        coordinates = new JLabel();
        coordinates.setFont(Fonts.smallText);
        add(coordinates);
        
        add(Box.createRigidArea(new DimensionUIResource(0, 5)));

        lastUpdated = new JLabel();
        lastUpdated.setFont(Fonts.smallText);
        add(lastUpdated);
    }

    public void displayWeather(WeatherSnapshot snapshot)
    {
        coordinates.setText(String.format(
            "Latitude: %.3f    Longitude: %.3f",
            snapshot.metadata.latitude,
            snapshot.metadata.longitude));
        lastUpdated.setText(String.format(
            "Last updated: %tc",
            snapshot.metadata.dateTime));
    }
}

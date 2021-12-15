package com.thatcoolcoder.weather.weatherApp.weatherDisplayPanel;

import java.util.*;
import java.util.function.*;
import javax.swing.*;
import javax.swing.plaf.InsetsUIResource;
import java.awt.*;

import com.thatcoolcoder.weather.weatherApi.models.*;
import com.thatcoolcoder.weather.weatherApp.Fonts;

public class WeatherDisplayPanel extends JPanel implements WeatherDisplayer {
    private JLabel locationHeading;
    private ArrayList<WeatherDisplayer> weatherPanelSections =
        new ArrayList<WeatherDisplayer>();

    public WeatherDisplayPanel() {
        super();
        setLayout(new GridBagLayout());
        InsetsUIResource layoutInsets = new InsetsUIResource(5, 5, 5, 5);

        locationHeading = new JLabel();
        locationHeading.setFont(Fonts.heading1);
        add(locationHeading, new GridBagConstraints() {{
            gridx = 0;
            gridy = 0;
            gridwidth = 2;
            anchor = GridBagConstraints.NORTH;
            insets = layoutInsets;
        }});

        SummaryPanel summaryPanel = new SummaryPanel();
        weatherPanelSections.add(summaryPanel);
        add(summaryPanel, new GridBagConstraints() {{
            gridx = 0;
            gridy = 1;
            gridwidth = 1;
            anchor = GridBagConstraints.NORTHEAST;
            fill = GridBagConstraints.BOTH;
            insets = layoutInsets;
        }});

        WindPanel windPanel = new WindPanel();
        weatherPanelSections.add(windPanel);
        add(windPanel, new GridBagConstraints() {{
            gridx = 1;
            gridy = 1;
            gridwidth = 1;
            anchor = GridBagConstraints.NORTHWEST;
            fill = GridBagConstraints.VERTICAL;
            insets = layoutInsets;
        }});

        MetadataBar metadataBar = new MetadataBar();
        weatherPanelSections.add(metadataBar);
        add(metadataBar, new GridBagConstraints() {{
            gridx = 0;
            gridy = 2;
            gridwidth = 2;
            weighty = 1;
            anchor = GridBagConstraints.NORTH;
            insets = layoutInsets;
        }});
    }

    public void displayWeather(WeatherSnapshot snapshot) {
        locationHeading.setText(String.format("Weather for %s, %s, %s",
            snapshot.metadata.location,
            snapshot.metadata.region,
            snapshot.metadata.country));
        for (WeatherDisplayer section : weatherPanelSections)
        {
            section.displayWeather(snapshot);
        }
    }
}

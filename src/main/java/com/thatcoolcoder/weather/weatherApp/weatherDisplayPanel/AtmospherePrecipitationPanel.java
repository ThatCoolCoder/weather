package com.thatcoolcoder.weather.weatherApp.weatherDisplayPanel;

import javax.swing.*;
import javax.swing.plaf.InsetsUIResource;

import java.awt.*;

import com.thatcoolcoder.weather.weatherApi.models.WeatherSnapshot;
import com.thatcoolcoder.weather.weatherApp.Fonts;
import com.thatcoolcoder.weather.weatherApp.UIUtils;

public class AtmospherePrecipitationPanel extends JPanel implements WeatherDisplayer {
    private JLabel visibility;
    private JLabel ultravioletLevel;

    private JLabel airPressure;
    private JLabel humidity;

    private JLabel cloudCover;
    private JLabel precipitation;

    public AtmospherePrecipitationPanel()
    {
        setBorder(UIUtils.createTitledBorder("Atmosphere and precipitation"));
        setLayout(new GridBagLayout());
        InsetsUIResource layoutInsets = new InsetsUIResource(5, 5, 5, 5);

        visibility = new JLabel();
        visibility.setFont(Fonts.text);
        add(visibility, new GridBagConstraints() {{
            gridx = 0;
            gridy = 0;
            anchor = GridBagConstraints.NORTHWEST;
            insets = layoutInsets;
        }});

        ultravioletLevel = new JLabel();
        ultravioletLevel.setFont(Fonts.text);
        add(ultravioletLevel, new GridBagConstraints() {{
            gridx = 0;
            gridy = 1;
            anchor = GridBagConstraints.SOUTHWEST;
            insets = layoutInsets;
        }});

        airPressure = new JLabel();
        airPressure.setFont(Fonts.text);
        add(airPressure, new GridBagConstraints() {{
            gridx = 1;
            gridy = 0;
            anchor = GridBagConstraints.NORTH;
            insets = layoutInsets;
        }});

        humidity = new JLabel();
        humidity.setFont(Fonts.text);
        add(humidity, new GridBagConstraints() {{
            gridx = 1;
            gridy = 1;
            anchor = GridBagConstraints.SOUTH;
            insets = layoutInsets;
        }});

        cloudCover = new JLabel();
        cloudCover.setFont(Fonts.text);
        add(cloudCover, new GridBagConstraints() {{
            gridx = 2;
            gridy = 0;
            anchor = GridBagConstraints.NORTHEAST;
            insets = layoutInsets;
        }});

        precipitation = new JLabel();
        precipitation.setFont(Fonts.text);
        add(precipitation, new GridBagConstraints() {{
            gridx = 2;
            gridy = 1;
            anchor = GridBagConstraints.SOUTHEAST;
            insets = layoutInsets;
        }});
    }

    public void displayWeather(WeatherSnapshot snapshot)
    {
        visibility.setText(String.format("%d km visibility",
            snapshot.visibility));
        ultravioletLevel.setText(String.format("Ultraviolet level: %.1f",
            snapshot.ultravioletLevel));
        airPressure.setText(String.format("Air pressure %d millibar",
            snapshot.airPressure));
        humidity.setText(String.format("%d%% humidity",
            (int) (snapshot.humidity * 100)));
        cloudCover.setText(String.format("%d%% cloud cover",
            (int) (snapshot.cloudCover * 100)));
        precipitation.setText(String.format("%d mm precipitation",
            snapshot.precipitationAmount));
    }
}

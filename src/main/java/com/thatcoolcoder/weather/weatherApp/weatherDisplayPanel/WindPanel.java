package com.thatcoolcoder.weather.weatherApp.weatherDisplayPanel;

import javax.swing.*;
import javax.swing.plaf.InsetsUIResource;

import java.awt.*;

import com.thatcoolcoder.weather.weatherApi.models.*;
import com.thatcoolcoder.weather.weatherApp.Fonts;
import com.thatcoolcoder.weather.weatherApp.UIUtils;

public class WindPanel extends JPanel implements WeatherDisplayer {
    private JLabel windSpeed;
    private JLabel windGustSpeed;
    private JLabel windDirection;

    public WindPanel()
    {
        setLayout(new GridBagLayout());
        setBorder(UIUtils.createTitledBorder("Wind"));
        InsetsUIResource layoutInsets = new InsetsUIResource(5, 5, 5, 5);

        windSpeed = new JLabel();
        windSpeed.setFont(Fonts.text);
        add(windSpeed, new GridBagConstraints() {{
            gridx = 0;
            gridy = 0;
            anchor = GridBagConstraints.WEST;
            insets = layoutInsets;
        }});

        windGustSpeed = new JLabel();
        windGustSpeed.setFont(Fonts.text);
        add(windGustSpeed, new GridBagConstraints() {{
            gridx = 0;
            gridy = 1;
            anchor = GridBagConstraints.WEST;
            insets = layoutInsets;
        }});

        windDirection = new JLabel();
        windDirection.setFont(Fonts.heading2);
        add(windDirection, new GridBagConstraints() {{
            gridx = 1;
            gridy = 0;
            gridheight = 2;
            anchor = GridBagConstraints.EAST;
            insets = layoutInsets;
        }});
    }

    public void displayWeather(WeatherSnapshot snapshot)
    {
        windSpeed.setText(String.format("%.0f km/h", snapshot.windSpeed));
        windGustSpeed.setText(String.format("Gusting to %.0f km/h", snapshot.windGustSpeed));
        windDirection.setText(String.format("%.0f °", snapshot.windDirection));
    }
}

package com.thatcoolcoder.weather.weatherApp.weatherDisplayPanel;

import java.util.*;
import java.util.function.*;
import javax.swing.*;
import javax.swing.plaf.InsetsUIResource;
import java.awt.*;

import com.thatcoolcoder.weather.weatherApi.models.*;

public class WeatherDisplayPanel extends JPanel implements WeatherDisplayer {
    private ArrayList<WeatherDisplayer> weatherPanelSections =
        new ArrayList<WeatherDisplayer>();

    public WeatherDisplayPanel() {
        super();
        setLayout(new GridBagLayout());
        InsetsUIResource layoutInsets = new InsetsUIResource(5, 5, 5, 5);

        HeadingBar headingBar = new HeadingBar();
        weatherPanelSections.add(headingBar);
        add(headingBar, new GridBagConstraints() {{
            gridx = 0;
            gridy = 0;
            gridwidth = 12;
            anchor = GridBagConstraints.NORTH;
            weighty = 1;
            insets = layoutInsets;
        }});
    }

    public void displayWeather(WeatherSnapshot weatherSnapshot) {
        for (WeatherDisplayer section : weatherPanelSections)
        {
            section.displayWeather(weatherSnapshot);
        }
    }
}

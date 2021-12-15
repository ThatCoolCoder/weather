package com.thatcoolcoder.weather.weatherApp;

import java.util.*;
import java.util.function.*;
import javax.swing.*;
import javax.swing.plaf.InsetsUIResource;
import java.awt.*;

import com.thatcoolcoder.weather.weatherApi.models.*;
import com.thatcoolcoder.weather.weatherApp.weatherDisplayPanel.*;

public class WeatherDisplayPanel extends JPanel {
    private ArrayList<PanelSection> weatherPanelSections =
        new ArrayList<PanelSection>();

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
            insets = layoutInsets;
        }});
    }

    public void showWeather(WeatherSnapshot weatherSnapshot) {
        for (PanelSection section : weatherPanelSections)
        {
            section.displayWeather(weatherSnapshot);
        }
    }
}

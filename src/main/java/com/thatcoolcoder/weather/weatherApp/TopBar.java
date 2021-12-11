package com.thatcoolcoder.weather.weatherApp;

import javax.swing.*;

import com.thatcoolcoder.weather.common.*;

public class TopBar extends JPanel {
    JTextField locationInput;

    public TopBar()
    {
        super();
        locationInput = new PromptTextField(40, "Enter city name");
        add(locationInput);
        requestFocusInWindow();
    }
}

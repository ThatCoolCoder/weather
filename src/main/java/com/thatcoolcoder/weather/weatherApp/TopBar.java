package com.thatcoolcoder.weather.weatherApp;

import java.util.function.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import com.thatcoolcoder.weather.common.*;

public class TopBar extends JPanel {
    JTextField locationInput;

    public TopBar()
    {
        super();

        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);

        locationInput = new PromptTextField(25, "Enter city name");
        locationInput.setFont(Fonts.smallText);
        centerPanel.add(locationInput);

        JButton searchButton = new JButton("Go!");
        searchButton.setFont(Fonts.smallText);
        centerPanel.add(searchButton);

        Action searchAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Actions.searchWeather.execute(locationInput.getText());
            }
        };
        locationInput.addActionListener(searchAction);
        searchButton.addActionListener(searchAction);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setFont(Fonts.smallText);
        settingsButton.addActionListener(a -> {
            SettingsPopup s = new SettingsPopup();
            s.setVisible(true);
        });
        add(settingsButton, BorderLayout.EAST);
    }
}

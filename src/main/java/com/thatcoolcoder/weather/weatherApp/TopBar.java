package com.thatcoolcoder.weather.weatherApp;

import java.util.function.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import com.thatcoolcoder.weather.common.*;

public class TopBar extends JPanel {
    JTextField locationInput;

    public TopBar(Consumer<String> showWeatherAction)
    {
        super();

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JPanel centerPanel = new JPanel();
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        add(centerPanel, c);

        locationInput = new PromptTextField(25, "Enter city name");
        centerPanel.add(locationInput);

        JButton searchButton = new JButton("Go!");
        centerPanel.add(searchButton);

        Action searchAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                showWeatherAction.accept(locationInput.getText());
            }
        };
        locationInput.addActionListener(searchAction);
        searchButton.addActionListener(searchAction);

        JButton settingsButton = new JButton("Settings");
        settingsButton.addActionListener(a -> {
            SettingsPopup s = new SettingsPopup();
            s.setVisible(true);
        });
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.EAST;
        add(settingsButton, c);
    }
}

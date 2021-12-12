package com.thatcoolcoder.weather.weatherApp;

import java.util.function.*;
import javax.swing.*;
import java.awt.event.*;

import com.thatcoolcoder.weather.common.*;

public class TopBar extends JPanel {
    JTextField locationInput;

    public TopBar(Consumer<String> showWeatherAction)
    {
        super();

        locationInput = new PromptTextField(25, "Enter city name");
        add(locationInput);

        JButton searchButton = new JButton("Go!");
        add(searchButton);

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
    }
}

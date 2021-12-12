package com.thatcoolcoder.weather.weatherApp;

import javax.swing.*;
import java.awt.event.*;

import com.thatcoolcoder.weather.common.*;

public class TopBar extends JPanel {
    JTextField locationInput;

    public TopBar(CallbackWithValue<String> showWeatherAction)
    {
        super();

        locationInput = new PromptTextField(25, "Enter city name");
        add(locationInput);

        JButton searchButton = new JButton("Go!");
        searchButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                showWeatherAction.Call(locationInput.getText());
            }
        });
        add(searchButton);
    }
}

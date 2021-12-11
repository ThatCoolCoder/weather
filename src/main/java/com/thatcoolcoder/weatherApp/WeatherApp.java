package com.thatcoolcoder.weatherApp;

import javax.swing.*;

public class WeatherApp extends JFrame {
    private JPanel mainPanel = new JPanel();

    public WeatherApp()
    {
        super("Weather App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        add(mainPanel);

        JLabel label = new JLabel();
        label.setText("Yay swing is working");
        mainPanel.add(label);
    }
}
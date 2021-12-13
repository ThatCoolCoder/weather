package com.thatcoolcoder.weather.weatherApp;

import javax.swing.*;

public class UIUtils
{
    public static void showException(JFrame component, Exception e, String context)
    {
        // context is something like "fetching weather data"
        JOptionPane.showMessageDialog(component,
            "Unexpected error " + context + "\n" + 
            "Details: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }

    public static void showException(JFrame component, String message)
    {
        // context is something like "fetching weather data"
        JOptionPane.showMessageDialog(component,
            message,
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

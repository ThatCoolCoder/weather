package com.thatcoolcoder.weather.weatherApp;

import javax.swing.*;
import javax.swing.border.*;

public class UIUtils
{
    public static void showException(JFrame component, String message)
    {
        JOptionPane.showMessageDialog(component,
            message,
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }

    public static void showException(JFrame component, Exception e, String context)
    {
        // context is something like "fetching weather data"
        String errorMessage = "Unexpected error " + context + "\n" + 
            "Details: " + e.getClass().getName() + ": " + e.getMessage();
        JOptionPane.showMessageDialog(component,
            errorMessage,
            "Error",
            JOptionPane.ERROR_MESSAGE);
        if (Config.current.detailedErrorMessages) e.printStackTrace();
    }

    public static CompoundBorder createTitledBorder(String title)
    {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(title),
            BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
}

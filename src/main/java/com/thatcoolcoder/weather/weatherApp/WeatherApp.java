package com.thatcoolcoder.weather.weatherApp;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.io.IOException;

import com.thatcoolcoder.weather.common.*;
import com.thatcoolcoder.weather.common.OS.OSType;
import com.thatcoolcoder.weather.weatherApi.*;
import com.thatcoolcoder.weather.weatherApi.exceptions.InvalidApiKey;
import com.thatcoolcoder.weather.weatherApi.exceptions.NoLocationProvided;
import com.thatcoolcoder.weather.weatherApi.models.WeatherSnapshot;

public class WeatherApp extends JFrame {
    private WeatherService weatherService;
    private WeatherDisplayPanel weatherDisplayPanel = new WeatherDisplayPanel();

    public WeatherApp(WeatherService weatherService)
    {
        super("Weather by ThatCoolCoder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        useSystemLookAndFeel();
        
        this.weatherService = weatherService;
        TopBar topBar = new TopBar((String location) -> showWeather(location));
        add(topBar, BorderLayout.NORTH);
        add(weatherDisplayPanel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                try
                {
                    Config.save();
                }
                catch (Exception e)
                {
                    // do nothing - saving config is not a major error
                }
            }

            public void windowOpened(WindowEvent we)
            {
                if (Config.current.autoOpenLastLocation)
                {
                    showWeather(Config.current.locationLastVisited);
                }
            }
        });
    }

    private void useSystemLookAndFeel()
    {
        try
        {
            String lookAndFeelName;
            switch (OS.getOS())
            {
                case WINDOWS:
                    lookAndFeelName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
                    break;
                case LINUX:
                    lookAndFeelName = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
                    break;
                default:
                    lookAndFeelName = "javax.swing.plaf.metal.MetalLookAndFeel";
            }
            UIManager.setLookAndFeel(lookAndFeelName);
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch (Exception e)
        {
            System.err.println("Failed to use native look and theme");
        }
    }

    private void showWeather(String location)
    {
        try
        {
            Config.current.locationLastVisited = location;
            weatherService.apiKey = Config.current.weatherApiKey;
            WeatherSnapshot weatherSnapshot = weatherService.getCurrentWeather(location);
            weatherDisplayPanel.showWeather(weatherSnapshot);
        }
        catch (IOException | InterruptedException e)
        {
            UIUtils.showException(this, e, "fetching weather data");
        }
        catch (InvalidApiKey e)
        {
            if (Config.current.weatherApiKey.isEmpty())
            {
                UIUtils.showException(this, "No API key set. Set one in the settings menu.");
            }
            else
            {
                UIUtils.showException(this, "Invalid API key.");
            }
        }
        catch (NoLocationProvided e)
        {
            // do nothing
        }
        catch (Exception e)
        {
            UIUtils.showException(this, e, "displaying weather data");
        }
    }
}

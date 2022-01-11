package com.thatcoolcoder.weather.weatherApp;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

import com.thatcoolcoder.weather.common.*;
import com.thatcoolcoder.weather.weatherApi.*;
import com.thatcoolcoder.weather.weatherApi.exceptions.*;
import com.thatcoolcoder.weather.weatherApi.models.*;
import com.thatcoolcoder.weather.weatherApp.weatherDisplayPanel.WeatherDisplayPanel;

public class WeatherApp extends JFrame {
    private WeatherService weatherService;
    private WeatherDisplayPanel weatherDisplayPanel = new WeatherDisplayPanel();

    public WeatherApp(WeatherService weatherService)
    {
        super("Weather by ThatCoolCoder");
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setIconImage(new ImageIcon(ClassLoader.getSystemResource("icon.png")).getImage());
        useSystemLookAndFeel();

        this.weatherService = weatherService;

        setupChildComponents();
        setupWindowListeners();

        Actions.searchWeather.add((String location) -> showWeather(location));
    }

    private void setupChildComponents()
    {

        setLayout(new BorderLayout());
        TopBar topBar = new TopBar();
        add(topBar, BorderLayout.NORTH);
        
        WeatherApiLink weatherApiLink = new WeatherApiLink();
        add(weatherApiLink, BorderLayout.SOUTH);

        add(weatherDisplayPanel, BorderLayout.CENTER);
        weatherDisplayPanel.setVisible(false);
    }

    private void setupWindowListeners()
    {
        addWindowListener(new WindowAdapter()
        {
            public void windowOpened(WindowEvent we)
            {
                if (Config.current.autoOpenLastLocation && ! Config.current.locationLastVisited.isEmpty())
                {
                    showWeather(Config.current.locationLastVisited);
                }
            }

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
            weatherDisplayPanel.setVisible(true);
            weatherDisplayPanel.displayWeather(weatherSnapshot);
        }
        catch (InvalidApiKeyException e)
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
        catch (NoLocationProvidedException e)
        {
            // do nothing
        }
        catch (InvalidLocationException e)
        {
            UIUtils.showException(this, e.getMessage());
        }
        catch (Exception e)
        {
            UIUtils.showException(this, e, "fetching weather data");
        }
    }
}

package com.thatcoolcoder.weather.weatherApp.weatherDisplayPanel;

import com.thatcoolcoder.weather.weatherApi.models.WeatherSnapshot;
import com.thatcoolcoder.weather.weatherApp.Fonts;
import com.thatcoolcoder.weather.weatherApp.UIUtils;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.InsetsUIResource;
import java.net.URL;

public class SummaryPanel extends JPanel implements WeatherDisplayer {
    private JLabel conditionIcon;
    private JLabel condition;
    private JLabel temperature;
    private JLabel temperatureFeelsLike;

    public SummaryPanel()
    {
        setLayout(new GridBagLayout());
        setBorder(UIUtils.createTitledBorder("Summary"));
        InsetsUIResource layoutInsets = new InsetsUIResource(5, 5, 5, 5);

        conditionIcon = new JLabel();
        add(conditionIcon, new GridBagConstraints() {{
            gridx = 0;
            gridy = 0;
            gridwidth = 1;
            gridheight = 3;
            insets = layoutInsets;
        }});

        condition = new JLabel();
        condition.setFont(Fonts.heading2);
        add(condition, new GridBagConstraints() {{
            gridx = 2;
            gridy = 0;
            gridwidth = 1;
            insets = layoutInsets;
            anchor = GridBagConstraints.WEST;
        }});

        temperature = new JLabel();
        temperature.setFont(Fonts.text);
        add(temperature, new GridBagConstraints() {{
            gridx = 2;
            gridy = 1;
            insets = layoutInsets;
            anchor = GridBagConstraints.WEST;
        }});

        temperatureFeelsLike = new JLabel();
        temperatureFeelsLike.setFont(Fonts.text);
        temperatureFeelsLike.setAlignmentX(0);
        add(temperatureFeelsLike, new GridBagConstraints() {{
            gridx = 2;
            gridy = 2;
            gridwidth = 2;
            insets = layoutInsets;
            anchor = GridBagConstraints.WEST;
        }});
    }

    @Override
    public void displayWeather(WeatherSnapshot snapshot) {
        try
        {
            conditionIcon.setIcon(new ImageIcon(new URL(snapshot.conditionIconUrl)));
        }
        catch (Exception e) {}
        condition.setText(snapshot.condition);
        temperature.setText(String.format("%.0f° C", snapshot.temperature));
        temperatureFeelsLike.setText(String.format("Feels like %.0f° C",
            snapshot.temperatureFeelsLike));
    }
}

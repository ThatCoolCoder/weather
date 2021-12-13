package com.thatcoolcoder.weather.weatherApp;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.InsetsUIResource;

public class SettingsPopup extends JDialog {
    public SettingsPopup()
    {
        super();
        setModal(true);
        setAlwaysOnTop (true);
        setModalityType(ModalityType.DOCUMENT_MODAL);

        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new InsetsUIResource(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.gridheight = 1;
        add(new JLabel("Settings"), c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        add(new JLabel("API key"), c);

        JTextField apiKeyInput = new JTextField(Config.current.weatherApiKey, 20);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 1;
        add(apiKeyInput, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        add(new JLabel("Open previous location on startup"), c);

        JCheckBox autoOpenLocationInput = new JCheckBox();
        autoOpenLocationInput.setSelected(Config.current.autoOpenLastLocation);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 3;
        c.gridheight = 1;
        add(autoOpenLocationInput, c);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(a -> {
            Config.current.weatherApiKey = apiKeyInput.getText();
            Config.current.autoOpenLastLocation = autoOpenLocationInput.isSelected();
            dispose();
        });
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        add(saveButton, c);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(a -> {
            dispose();
        });
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        add(cancelButton, c);

        pack();
        setResizable(false);
    }
}

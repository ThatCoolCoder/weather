package com.thatcoolcoder.weather.common;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.net.URI;

public class Hyperlink extends JLabel {
    private String href;
    private int oldFontStyle;

    public Hyperlink()
    {
        this("");
    }

    public Hyperlink(String text)
    {
        this(text, text);
    }
    
    public Hyperlink(String text, String href)
    {
        this.href = href;
        setText(text);
        setForeground(Color.BLUE.darker());
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                try
                {
                    Desktop.getDesktop().browse(new URI(href));
                }
                catch (Exception ex)
                {
                    System.err.println("Failed to open hyperlink");
                }
            }
         
            @Override
            public void mouseEntered(MouseEvent e)
            {
                Map<TextAttribute, Object> attributes = new HashMap<>(getFont().getAttributes());
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                setFont(getFont().deriveFont(attributes));
            }
         
            @Override
            public void mouseExited(MouseEvent e)
            {
                Map<TextAttribute, Object> attributes = new HashMap<>(getFont().getAttributes());
                attributes.put(TextAttribute.UNDERLINE, -1);
                setFont(getFont().deriveFont(attributes));
            }
        });
    }

    public String getHref()
    {
        return href;
    }

    public void setHref(String href)
    {
        this.href = href;
    }
}

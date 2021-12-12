package com.thatcoolcoder.weather.common;

import javax.swing.*;
import java.awt.event.*;

public class PromptTextField extends JTextField implements KeyListener
{
    private boolean isShowingPrompt = true;
    private String promptText;

    public PromptTextField(String promptText) {
        super();
        addKeyListener(this);
        setPromptText(promptText);
        setText(promptText);
    }

    public PromptTextField(String text, String promptText)
    {
        super(text);
        addKeyListener(this);
        setPromptText(promptText);
        setText(promptText);
    }

    public PromptTextField(String text, int columns, String promptText)
    {
        super(text, columns);
        addKeyListener(this);
        setPromptText(promptText);
        setText(promptText);
    }


    public PromptTextField(int columns, String promptText)
    {
        super(columns);
        addKeyListener(this);
        setPromptText(promptText);
        setText(promptText);
    }

    public String getPromptText()
    {
        return promptText;
    }

    public void setPromptText(String promptText)
    {
        this.promptText = promptText;
    }

    public void keyPressed(KeyEvent e)
    {
        // Method is not needed but must include it to implement KeyListener
    }

    public void keyReleased(KeyEvent e)
    {
        // Method is not needed but must include it to implement KeyListener
    }

    public void keyTyped(KeyEvent e)
    {
        if (getText().isEmpty() && ! isShowingPrompt)
        {
            isShowingPrompt = true;
        }

        else if (isShowingPrompt && Utils.isPrintableChar(e.getKeyChar()))
        {
            setText("");
            isShowingPrompt = false;
        }
        if (isShowingPrompt)
        {
            setText(promptText);
        }
    }
}
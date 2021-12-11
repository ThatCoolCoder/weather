package com.thatcoolcoder.weather.common;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.awt.event.*;

public class Utils {
    public static String urlEncode(String text)
    {
        // URL-encode a piece of text (eg replacing space with %20)
        try
        {
            return URLEncoder.encode(text, StandardCharsets.UTF_8.toString());
        }
        catch (Exception e)
        {
            return "";
        }
    }

    public static boolean isPrintableChar(char c) {
        Character.UnicodeBlock block = Character.UnicodeBlock.of(c);
        return (! Character.isISOControl(c)) &&
            c != KeyEvent.CHAR_UNDEFINED &&
            block != null &&
            block != Character.UnicodeBlock.SPECIALS;
    }
    
}

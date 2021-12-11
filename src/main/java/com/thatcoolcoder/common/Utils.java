package com.thatcoolcoder.common;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
}

package com.thatcoolcoder.weather.common;

public class OS
{
    public enum OSType
    {
        WINDOWS, LINUX, MAC, OTHER
    }

    private OSType os = null;

    public OSType getOS()
    {
        if (os == null)
        {
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.contains("win")) os = OSType.WINDOWS;
            else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) os = OSType.LINUX;
            else if (osName.contains("mac")) os = OSType.MAC;
            else os = OSType.OTHER;
        }
        return os;
    }
}
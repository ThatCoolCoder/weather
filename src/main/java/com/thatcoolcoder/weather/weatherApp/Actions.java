package com.thatcoolcoder.weather.weatherApp;

import com.thatcoolcoder.weather.common.Subscribable;

public class Actions {
    // Bunch of SubscribableActions that can be executed
    // Grouped into one place so they basically act like signals - no callbacks required!

    public static Subscribable<String> searchWeather = new Subscribable<String>();
}

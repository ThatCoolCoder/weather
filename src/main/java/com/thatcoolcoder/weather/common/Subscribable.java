package com.thatcoolcoder.weather.common;

import java.util.*;
import java.util.function.*;

public class Subscribable<T> {
    private ArrayList<Consumer<T>> subscribers = new ArrayList<Consumer<T>>();
    public boolean enabled = true;

    public void add(Consumer<T> subscriber)
    {
        subscribers.add(subscriber);
    }

    public void remove(Consumer<T> subscriber)
    {
        subscribers.remove(subscriber);
    }

    public void execute(T data)
    {
        if (enabled)
        {
            for (Consumer<T> s : subscribers)
            {
                s.accept(data);
            }
        }
    }
}

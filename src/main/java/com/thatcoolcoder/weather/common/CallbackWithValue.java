package com.thatcoolcoder.weather.common;

public abstract class CallbackWithValue<T>
{
    public CallbackWithValue()
    {
        
    }

    public abstract void OnCalled(T value);

    public void Call(T value)
    {
        OnCalled(value);
    }
}

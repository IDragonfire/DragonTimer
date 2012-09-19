package com.github.idragonfire.dragontimer.api;

import com.github.idragonfire.dragontimer.DLoadException;

public interface DTimerListener {

    public abstract void onDTimerEvent(DTimer event);

    public abstract void onDTimerEventPassed(DTimer event);

    public abstract void onDLoadException(DLoadException e);
}

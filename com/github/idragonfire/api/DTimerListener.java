package com.github.idragonfire.api;

import com.github.idragonfire.DLoadException;

public interface DTimerListener {

    public abstract void onDTimerEvent(DTimer event);

    public abstract void onDTimerEventPassed(DTimer event);

    public abstract void onDLoadException(DLoadException e);
}

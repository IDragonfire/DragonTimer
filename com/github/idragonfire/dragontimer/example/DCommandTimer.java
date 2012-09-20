package com.github.idragonfire.dragontimer.example;

import java.util.Date;

import com.github.idragonfire.dragontimer.api.DTimer;

public class DCommandTimer extends DTimer {
    protected String[] commands;

    public DCommandTimer(String pluginName, String eventName, Date startTime,
            String... commands) {
        super(pluginName, eventName, startTime);
        this.commands = commands;
    }

    public String[] getCommands() {
        return this.commands;
    }
}

package com.github.idragonfire.dragontimer;

import java.text.SimpleDateFormat;

import org.bukkit.plugin.java.JavaPlugin;

public class DTimerPlugin extends JavaPlugin {
    // TODO: not thread safe
    public static final String DATE_PATTERN = "yyyyMMdd_HHmmss";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
            DTimerPlugin.DATE_PATTERN);
    protected static DScheduler DSCHEDULER;

    @Override
    public void onEnable() {
        DTimerPlugin.DSCHEDULER = new DScheduler();

    }

    @Override
    public void onDisable() {
        DTimerPlugin.DSCHEDULER.disable();
        DTimerPlugin.DSCHEDULER = null;
    }

    public void onCommand() {
        // TODO: implement
    }

    public static DScheduler getDScheduler() {
        return DTimerPlugin.DSCHEDULER;
    }
}
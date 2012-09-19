package com.github.idragonfire.dragontimer;

import org.bukkit.plugin.java.JavaPlugin;


public class DTimerPlugin extends JavaPlugin {
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
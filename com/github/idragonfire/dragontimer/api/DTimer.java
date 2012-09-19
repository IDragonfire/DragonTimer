package com.github.idragonfire.dragontimer.api;

import java.io.File;
import java.util.Date;

import org.bukkit.plugin.Plugin;

public abstract class DTimer {
    protected String pluginName;
    protected boolean isAsync;
    protected boolean isRealtime;
    protected Date startTime;

    public DTimer(Plugin plugin) {
        this.pluginName = plugin.getName();
    }

    public Date getExecutionTime() {
        return null;
    }

    public Date getNextExecutionTime() {
        return null;
    }

    public boolean isRepeatingTask() {
        return getNextExecutionTime() != null;
    }

    public String getPluginName() {
        return this.pluginName;
    }

    public abstract String getName();

    public boolean isAsyncTask() {
        return false;
    }

    public boolean isRealTimeTask() {
        return true;
    }

    public abstract void save(File file);

    public abstract DTimer load(File file);
}
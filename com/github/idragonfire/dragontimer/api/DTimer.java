package com.github.idragonfire.dragontimer.api;

import java.text.ParseException;
import java.util.Date;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import com.github.idragonfire.dragontimer.DTimerPlugin;

//TODO: merge DTimer with same startTime
public abstract class DTimer {
    protected String pluginName;
    protected boolean isAsync;
    protected boolean isRealtime;
    protected Date startTime;

    public DTimer(Plugin plugin, Date startTime) {
        this.pluginName = plugin.getName();
        this.startTime = startTime;
    }

    public DTimer(FileConfiguration config) {
        load(config);
    }

    public Date getStartTime() {
        return this.startTime;
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

    public void save(FileConfiguration config) {
        config.set("pluginname", this.pluginName);
        config.set("isasync", this.isAsync);
        config.set("isrealtime", this.isRealtime);
        config
                .set("starttime", DTimerPlugin.DATE_FORMAT
                        .format(this.startTime));
    }

    public void load(FileConfiguration config) {
        this.pluginName = config.getString("pluginname");
        this.isAsync = config.getBoolean("isasync");
        this.isRealtime = config.getBoolean("isrealtime");
        try {
            this.startTime = DTimerPlugin.DATE_FORMAT.parse(config
                    .getString("starttime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
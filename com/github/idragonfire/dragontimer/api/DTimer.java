package com.github.idragonfire.dragontimer.api;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public abstract class DTimer {
    public static final String FORMAT = "yyyy.MM.dd-HH:mm:ss";
    protected String pluginName;
    protected boolean isAsync;
    protected boolean isRealtime;
    protected Date startTime;

    public DTimer(Plugin plugin) {
        this.pluginName = plugin.getName();
    }

    public DTimer(File f) {
        load(f);
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

    public void save(File file) {
        YamlConfiguration config = new YamlConfiguration();
        config.set("pluginname", this.pluginName);
        config.set("isasync", this.isAsync);
        config.set("isrealtime", this.isRealtime);
        config.set("starttime", new SimpleDateFormat(DTimer.FORMAT)
                .format(this.startTime));
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(File file) {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        this.pluginName = config.getString("pluginname");
        this.isAsync = config.getBoolean("isasync");
        this.isRealtime = config.getBoolean("isrealtime");
        try {
            this.startTime = new SimpleDateFormat(DTimer.FORMAT).parse(config
                    .getString("starttime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
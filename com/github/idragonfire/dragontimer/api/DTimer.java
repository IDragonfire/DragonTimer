package com.github.idragonfire.dragontimer.api;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.bukkit.plugin.Plugin;

//TODO: merge DTimer with same startTime
@XmlRootElement(name = "DTimer")
public abstract class DTimer {
    protected String pluginName;
    protected boolean asyncTask;
    protected boolean realTimeTask;
    protected Date startTime;

    public DTimer(Plugin plugin, Date startTime) {
        this.pluginName = plugin.getName();
        this.startTime = startTime;
        this.asyncTask = true;
        this.realTimeTask = true;
    }

    public DTimer() {
        // for XMLEncoder
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
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
        return this.asyncTask;
    }

    public void setAsyncTask(boolean asyncTask) {
        this.asyncTask = asyncTask;
    }

    public boolean isRealTimeTask() {
        return this.realTimeTask;
    }

    public void setRealTimeTask(boolean realTimeTask) {
        this.realTimeTask = realTimeTask;
    }

}
package com.github.idragonfire.dragontimer.api;

import java.util.Date;

//TODO: merge DTimer with same startTime
public abstract class DTimer {
    protected String pluginName;
    protected String eventName;
    protected boolean asyncTask;
    protected boolean realTimeTask;
    protected Date startTime;
    protected DRepeat repeat;

    public DTimer(String pluginName, String eventName, Date startTime) {
        this.pluginName = pluginName;
        this.eventName = eventName;
        this.startTime = startTime;
    }

    public void setDRepeater(DRepeat repeat) {
        this.repeat = repeat;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public Date getNextExecutionTime() {
        try {
            return this.repeat.getNextExecutionTime(getStartTime());
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isRepeatingTask() {
        return getNextExecutionTime() != null;
    }

    public String getPluginName() {
        return this.pluginName;
    }

    public String getEventName() {
        return this.eventName;
    }

    public boolean isAsyncTask() {
        return false;
    }

    public boolean isRealTimeTask() {
        return true;
    }
}
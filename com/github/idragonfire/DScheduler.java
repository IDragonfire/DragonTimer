package com.github.idragonfire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.plugin.Plugin;

import com.github.idragonfire.api.DTimer;
import com.github.idragonfire.api.DTimerListener;

public class DScheduler {
    private HashMap<String, Plugin> plugins;
    private HashMap<String, List<DTimerListener>> listeners;

    public int scheduleTask(Plugin plugin, DTimer timer) {
        return -1;
    }

    public void registerListener(Plugin plugin, String eventName,
            DTimerListener listener) {
        this.plugins.put(plugin.getName(), plugin);
        List<DTimerListener> eventListener = this.listeners.get(eventName);
        if (eventListener == null) {
            eventListener = new ArrayList<DTimerListener>();
            this.listeners.put(eventName, eventListener);
        }
        eventListener.add(listener);
    }

    public void triggerEvent(DTimer event) {
        List<DTimerListener> eventListeners = this.listeners.get(event
                .getName());
        if (eventListeners == null || eventListeners.size() == 0) {
            // debug no list
        }
        for (DTimerListener listener : eventListeners) {
            listener.onDTimerEvent(event);
        }
    }

    public void disable() {
        // TODO Auto-generated method stub
    }
}
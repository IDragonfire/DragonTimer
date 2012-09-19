package com.github.idragonfire.dragontimer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import com.github.idragonfire.dragontimer.api.DTimer;
import com.github.idragonfire.dragontimer.api.DTimerListener;

//TODO: trigger all event of eventname
public class DScheduler {
    private HashMap<String, Plugin> plugins;
    private HashMap<String, List<DTimerListener>> listeners;

    public int scheduleTask(Plugin plugin, DTimer timer) {
        DTimerPlugin.DTIMERSTORAGE.saveTask(timer);
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

    public void triggerEvent(final DTimer event) {
        List<DTimerListener> eventListeners = this.listeners.get(event
                .getName());
        if (eventListeners == null || eventListeners.size() == 0) {
            // debug no list
        }
        for (final DTimerListener listener : eventListeners) {
            // Bukkit injection
            if (event.isAsyncTask()) {
                Bukkit.getScheduler().scheduleAsyncDelayedTask(
                        this.plugins.get(event.getPluginName()),
                        new Runnable() {
                            @Override
                            public void run() {
                                listener.onDTimerEvent(event);
                            }
                        });
            } else {
                Bukkit.getScheduler().scheduleSyncDelayedTask(
                        this.plugins.get(event.getPluginName()),
                        new Runnable() {
                            @Override
                            public void run() {
                                listener.onDTimerEvent(event);
                            }
                        });
            }
        }
    }

    public void disable() {
        // TODO Auto-generated method stub
    }

    public static void main(String[] args) {

    }
}
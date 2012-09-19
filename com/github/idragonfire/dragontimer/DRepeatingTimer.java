package com.github.idragonfire.dragontimer;

import java.util.Date;

import org.bukkit.plugin.Plugin;

import com.github.idragonfire.dragontimer.api.DRepeat;
import com.github.idragonfire.dragontimer.api.DTimer;

public abstract class DRepeatingTimer extends DTimer {
    protected DRepeat repeat;

    public DRepeatingTimer(Plugin plugin, Date startTime, DRepeat repeat) {
        super(plugin, startTime);
        this.repeat = repeat;
    }

    @Override
    public Date getNextExecutionTime() {
        try {
            return this.repeat.getNextExecutionTime(getStartTime());
        } catch (Exception e) {
            return null;
        }
    }

}

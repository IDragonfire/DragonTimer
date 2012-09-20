package com.github.idragonfire.dragontimer;

import java.util.Date;

import org.bukkit.plugin.Plugin;

import com.github.idragonfire.dragontimer.api.DRepeat;
import com.github.idragonfire.dragontimer.api.DTimer;

public abstract class DRepeatingTimer extends DTimer {
    public DRepeat getRepeat() {
        return this.repeat;
    }

    public void setRepeat(DRepeat repeat) {
        this.repeat = repeat;
    }

    protected DRepeat repeat;

    public DRepeatingTimer(Plugin plugin, Date startTime, DRepeat repeat) {
        super(plugin, startTime);
        this.repeat = repeat;
    }

    public DRepeatingTimer() {
        super();
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

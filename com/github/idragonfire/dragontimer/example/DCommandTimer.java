package com.github.idragonfire.dragontimer.example;

import java.util.Date;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import com.github.idragonfire.dragontimer.DRepeatingTimer;
import com.github.idragonfire.dragontimer.api.DRepeat;

public class DCommandTimer extends DRepeatingTimer {
    protected String[] commands;

    public DCommandTimer(Plugin plugin, Date startTime, DRepeat repeat,
            String... commands) {
        super(plugin, startTime, repeat);
        this.commands = commands;
    }

    public String[] getCommands() {
        return this.commands;
    }

    // TODO: rework save meachnism
    @Override
    public void save(FileConfiguration config) {
        super.save(config);
        config.set("pluginname", super.pluginName);
        config.set("commands", this.commands);
    }

    // TODO: rework load meachnism
    @Override
    public void load(FileConfiguration config) {
        super.load(config);
        this.commands = config.getStringList("commands").toArray(new String[0]);
    }

    @Override
    public String getName() {
        // TODO: make it better
        return this.pluginName;
    }
}

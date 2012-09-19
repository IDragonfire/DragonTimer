package com.github.idragonfire.dragontimer.example;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import com.github.idragonfire.dragontimer.DRepeat;
import com.github.idragonfire.dragontimer.api.DTimer;

public class DCommandTimer extends DTimer {
    protected String[] commands;
    protected DRepeat repeater;

    public DCommandTimer(Plugin plugin, DRepeat repeater, String... commands) {
        super(plugin);
        this.repeater = repeater;
        this.commands = commands;
    }

    @Override
    public Date getNextExecutionTime() {
        return this.repeater.getNextExecutionTime(new Date());
    }

    public String[] getCommands() {
        return this.commands;
    }

    @Override
    public void save(File file) {
        FileConfiguration data = new YamlConfiguration();
        data.set("pluginname", super.pluginName);
        data.set("commands", this.commands);
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DTimer load(File file) {
        // return new Configuration(data.getString("pluginName"), data
        // .getList("commands"));
        return null;
    }

    @Override
    public String getName() {
        // TODO: make it better
        return this.pluginName + this.commands[0];
    }
}

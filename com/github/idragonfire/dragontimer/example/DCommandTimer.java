package com.github.idragonfire.dragontimer.example;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import com.github.idragonfire.dragontimer.DRepeatingTimer;
import com.github.idragonfire.dragontimer.api.DRepeat;

public class DCommandTimer extends DRepeatingTimer {
    protected String[] commands;

    public DCommandTimer(Plugin plugin, DRepeat repeat, String... commands) {
        super(plugin, repeat);
        this.commands = commands;
    }

    public String[] getCommands() {
        return this.commands;
    }

    // TODO: rework save meachnism
    @Override
    public void save(File file) {
        super.save(file);
        FileConfiguration data = new YamlConfiguration();
        data.set("pluginname", super.pluginName);
        data.set("commands", this.commands);
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: rework load meachnism
    @Override
    public void load(File file) {
        super.load(file);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        this.commands = config.getStringList("commands").toArray(new String[0]);
    }

    @Override
    public String getName() {
        // TODO: make it better
        return this.pluginName + this.commands[0];
    }
}

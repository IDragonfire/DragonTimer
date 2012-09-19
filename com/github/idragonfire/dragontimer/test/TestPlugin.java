package com.github.idragonfire.dragontimer.test;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;

import com.avaje.ebean.EbeanServer;

public class TestPlugin implements Plugin {
    protected String name;

    public TestPlugin(String name) {
        this.name = name;
    }

    @Override
    public FileConfiguration getConfig() {
        return null;
    }

    @Override
    public File getDataFolder() {
        return null;
    }

    @Override
    public EbeanServer getDatabase() {
        return null;
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String arg0, String arg1) {
        return null;
    }

    @Override
    public PluginDescriptionFile getDescription() {
        return null;
    }

    @Override
    public Logger getLogger() {
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public PluginLoader getPluginLoader() {
        return null;
    }

    @Override
    public InputStream getResource(String arg0) {
        return null;
    }

    @Override
    public Server getServer() {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean isNaggable() {
        return false;
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onLoad() {

    }

    @Override
    public void reloadConfig() {
    }

    @Override
    public void saveConfig() {
    }

    @Override
    public void saveDefaultConfig() {

    }

    @Override
    public void saveResource(String arg0, boolean arg1) {

    }

    @Override
    public void setNaggable(boolean arg0) {
    }

    @Override
    public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
            String[] arg3) {
        return false;
    }

}

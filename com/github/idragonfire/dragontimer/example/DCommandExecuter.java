package com.github.idragonfire.dragontimer.example;

import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import com.github.idragonfire.dragontimer.DLoadException;
import com.github.idragonfire.dragontimer.DTimerPlugin;
import com.github.idragonfire.dragontimer.api.DTimer;
import com.github.idragonfire.dragontimer.api.DTimerListener;

public class DCommandExecuter {

    public static int executeCommand(Plugin plugin, Date startTime,
            String... commands) {
        return executeCommand(plugin, startTime, -1L, false, commands);
    }

    public static int executeCommand(Plugin plugin, Date startTime,
            long repeatingTime, String... commands) {
        return executeCommand(plugin, startTime, repeatingTime, false, commands);
    }

    public static int executeCommand(Plugin plugin, Date startTime,
            long repeatingTime, boolean reallifeTime, String... commands) {
        DTimer timer = null;
        if (repeatingTime <= 0) {
            timer = new DCommandTimer(plugin, startTime, null, commands);
        } else {
            // timer = new DRepeatingCommandTimer(plugin, startTime, new DRepeat(
            // repeatTime), reallifeTime, commands);
        }

        return DTimerPlugin.getDScheduler().scheduleTask(plugin, timer);
    }

    public class DCommandExecuterListener implements DTimerListener {
        public void onDTimerEvent(DTimer timer) {
            if (!(timer instanceof DCommandTimer)) {
                // Exception
                return;
            }
            DCommandTimer cmdTimer = (DCommandTimer) timer;
            for (String cmd : cmdTimer.getCommands()) {
                // cmd
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                        cmd);
            }
        }

        public void onDLoadException(DLoadException e) {
            e.printStackTrace();
        }

        @Override
        public void onDTimerEventPassed(DTimer event) {
            // TODO Auto-generated method stub

        }
    }
}

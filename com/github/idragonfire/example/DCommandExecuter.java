package com.github.idragonfire.example;

import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import com.github.idragonfire.DLoadException;
import com.github.idragonfire.DTimerPlugin;
import com.github.idragonfire.api.DTimer;
import com.github.idragonfire.api.DTimerListener;

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
            // timer = new DCommandTimerEvent(plugin, startTime, reallifeTime,
            // commands);
        } else {
            // timer = new DRepeatingCommandTimer(plugin, startTime, new DRepeat(
            // repeatTime), reallifeTime, commands);
        }
        DTimerPlugin.getDScheduler().scheduleTask(plugin, timer);
        return -1;
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

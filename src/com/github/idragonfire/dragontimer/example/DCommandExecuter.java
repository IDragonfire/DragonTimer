package com.github.idragonfire.dragontimer.example;

import java.util.Date;

import org.bukkit.Bukkit;

import com.github.idragonfire.dragontimer.DLoadException;
import com.github.idragonfire.dragontimer.DLongRepeat;
import com.github.idragonfire.dragontimer.DTimerPlugin;
import com.github.idragonfire.dragontimer.api.DRepeat;
import com.github.idragonfire.dragontimer.api.DTimer;
import com.github.idragonfire.dragontimer.api.DTimerListener;

public class DCommandExecuter {

    public static int executeCommand(String pluginName, Date startTime,
            String... commands) {
        return executeCommand(pluginName, startTime, null, commands);
    }

    public static int executeCommand(String pluginName, Date startTime,
            long repeatingTime, String... commands) {
        return executeCommand(pluginName, startTime, new DLongRepeat(
                repeatingTime), commands);
    }

    public static int executeCommand(String pluginName, Date startTime,
            DRepeat repeatingTime, String... commands) {
        DTimer timer = null;
        timer = new DCommandTimer(pluginName, "command", startTime, commands);
        if (repeatingTime != null) {
            timer.setDRepeater(repeatingTime);
        }

        return DTimerPlugin.getDScheduler().scheduleTask(timer);
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

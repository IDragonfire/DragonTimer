package com.github.idragonfire.dragontimer.test;

import java.util.Date;

import com.github.idragonfire.dragontimer.example.DCommandExecuter;

public class TestTaskCreator {
    public static void createFakeTasks() {
        for (int i = 1; i <= 3; i++) {
            DCommandExecuter
                    .executeCommand(new TestPlugin("DPlugin"), new Date(System
                            .currentTimeMillis()
                            + i * 1000), "cmd " + i);
        }
    }

    public static void main(String[] args) {
        TestTaskCreator.createFakeTasks();
    }
}

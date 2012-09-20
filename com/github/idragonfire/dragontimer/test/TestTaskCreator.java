package com.github.idragonfire.dragontimer.test;

import java.util.Date;

import com.github.idragonfire.dragontimer.example.DCommandExecuter;

public class TestTaskCreator {
    public static void createFakeTasks() {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            DCommandExecuter
                    .executeCommand(new TestPlugin("DPlugin"), new Date(System
                            .currentTimeMillis()
                            + i * 1000), "cmd " + i);
        }
        System.out.println("milis: " + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            TestTaskCreator.createFakeTasks();
        }
    }
}

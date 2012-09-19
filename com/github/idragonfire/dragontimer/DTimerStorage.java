package com.github.idragonfire.dragontimer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

public class DTimerStorage {
    public static final String DATA_FOLDER = "Timers";
    protected HashMap<String, ArrayList<DateFile>> eventMapping;
    protected String basePath;
    protected File baseFolder;

    public DTimerStorage(String basePath) {
        this.eventMapping = new HashMap<String, ArrayList<DateFile>>();
        this.basePath = basePath;
        initStorage();
        hashStorage();
    }

    protected void initStorage() {
        this.baseFolder = new File(this.basePath + File.separator + DATA_FOLDER);
        if (!this.baseFolder.exists()) {
            this.baseFolder.mkdir();
        }
    }

    protected void hashStorage() {
        // TODO use nio file system
        File[] files = this.baseFolder.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                this.eventMapping.put(file.getName(),
                        getNextFilesForEvents(file.getName()));
            }
        }
    }

    public File getNextTask() {
        ArrayList<DateFile> nextEvents = new ArrayList<DateFile>();
        for (ArrayList<DateFile> value : this.eventMapping.values()) {
            try {
                nextEvents.add(value.get(0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Collections.sort(nextEvents);
        return nextEvents.get(0).getFile();
    }

    // TODO: sort out expired tasks
    public ArrayList<DateFile> getNextFilesForEvents(String eventname) {
        try {
            File[] files = new File(this.baseFolder.getPath() + File.separator
                    + eventname).listFiles();
            ArrayList<DateFile> eventsForExecution = new ArrayList<DateFile>();
            for (File file : files) {
                try {
                    Date startTime = DTimerPlugin.DATE_FORMAT.parse(file
                            .getName().substring(0,
                                    DTimerPlugin.DATE_PATTERN.length()));
                    eventsForExecution.add(new DateFile(startTime, file));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Collections.sort(eventsForExecution);
            return eventsForExecution;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public class DateFile implements Comparable<DateFile> {
        protected File file;
        protected Date date;

        public DateFile(Date date, File file) {
            this.file = file;
            this.date = date;
        }

        public File getFile() {
            return this.file;
        }

        public Date getDate() {
            return this.date;
        }

        @Override
        public String toString() {
            return "DateFile [" + this.date + ", " + this.file + "]";
        }

        @Override
        public int compareTo(DateFile o) {
            return this.date.compareTo(o.getDate());
        }
    }

    public static void main(String[] args) {
        DTimerStorage s = new DTimerStorage("D:\\Minecraft\\test");
        System.out.println(s.getNextTask());
    }
}

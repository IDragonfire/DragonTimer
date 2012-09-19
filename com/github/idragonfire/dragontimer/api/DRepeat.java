package com.github.idragonfire.dragontimer.api;

import java.util.Date;

public abstract class DRepeat {
    public abstract Date getNextExecutionTime(Date time);
}

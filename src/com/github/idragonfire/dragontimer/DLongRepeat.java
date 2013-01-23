package com.github.idragonfire.dragontimer;

import java.util.Date;

import com.github.idragonfire.dragontimer.api.DRepeat;

public class DLongRepeat extends DRepeat {
    protected long delayMilis;

    public DLongRepeat(long delayMilis) {
        this.delayMilis = delayMilis;
    }

    @Override
    public Date getNextExecutionTime(Date time) {
        return new Date(time.getTime() + this.delayMilis);
    }

}
